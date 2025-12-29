package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository taskAssignmentRecordRepository;
    private final TaskRecordRepository taskRecordRepository;
    private final VolunteerProfileRepository volunteerProfileRepository;
    private final VolunteerSkillRecordRepository volunteerSkillRecordRepository;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository taskAssignmentRecordRepository,
            TaskRecordRepository taskRecordRepository,
            VolunteerProfileRepository volunteerProfileRepository,
            VolunteerSkillRecordRepository volunteerSkillRecordRepository) {
        this.taskAssignmentRecordRepository = taskAssignmentRecordRepository;
        this.taskRecordRepository = taskRecordRepository;
        this.volunteerProfileRepository = volunteerProfileRepository;
        this.volunteerSkillRecordRepository = volunteerSkillRecordRepository;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        // ✅ 1. Task must exist FIRST
        TaskRecord task = taskRecordRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        // ✅ 2. Only one ACTIVE assignment allowed
        if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has an ACTIVE assignment");
        }

        // ✅ 3. Find AVAILABLE volunteers
        List<VolunteerProfile> volunteers =
                volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

        boolean skillFoundButLevelInsufficient = false;

        for (VolunteerProfile volunteer : volunteers) {
            List<VolunteerSkillRecord> skills =
                    volunteerSkillRecordRepository.findByVolunteerId(volunteer.getId());

            for (VolunteerSkillRecord skill : skills) {

                // ✅ Case-insensitive skill match (TEST EXPECTS THIS)
                if (skill.getSkillName() != null
                        && task.getRequiredSkill() != null
                        && skill.getSkillName().equalsIgnoreCase(task.getRequiredSkill())) {

                    // Skill exists but level may be insufficient
                    if (SkillLevelUtil.hasRequiredSkillLevel(
                            skill.getSkillLevel(),
                            task.getRequiredSkillLevel())) {

                        TaskAssignmentRecord assignment = new TaskAssignmentRecord();
                        assignment.setTaskId(taskId);
                        assignment.setVolunteerId(volunteer.getId());
                        assignment.setStatus("ACTIVE");

                        task.setStatus("ACTIVE");
                        taskRecordRepository.save(task);

                        return taskAssignmentRecordRepository.save(assignment);
                    } else {
                        skillFoundButLevelInsufficient = true;
                    }
                }
            }
        }

        // ✅ 4. Correct exception based on failure reason
        if (skillFoundButLevelInsufficient) {
            throw new BadRequestException("Volunteer skill level insufficient");
        }

        throw new BadRequestException("No suitable volunteer found");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return taskAssignmentRecordRepository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return taskAssignmentRecordRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentRecordRepository.findAll();
    }
}
