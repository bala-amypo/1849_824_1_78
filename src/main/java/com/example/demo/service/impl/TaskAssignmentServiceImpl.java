package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
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

        // 1. Ensure single ACTIVE assignment
        if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already assigned");
        }

        // 2. Load task
        TaskRecord task = taskRecordRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        // 3. Load available volunteers
        List<VolunteerProfile> volunteers =
                volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

        boolean skillFoundButLevelLow = false;

        for (VolunteerProfile volunteer : volunteers) {

            // 4. Load volunteer skills
            List<VolunteerSkillRecord> skills =
                    volunteerSkillRecordRepository.findByVolunteerId(volunteer.getId());

            for (VolunteerSkillRecord skill : skills) {

                // 5. Skill name matches
                if (skill.getSkillName().equalsIgnoreCase(task.getRequiredSkill())) {

                    // 6. Skill level check
                    if (!SkillLevelUtil.hasRequiredSkillLevel(
                            skill.getSkillLevel(),
                            task.getRequiredSkillLevel())) {

                        skillFoundButLevelLow = true;
                        continue;
                    }

                    // 7. Assign task
                    TaskAssignmentRecord assignment = new TaskAssignmentRecord();
                    assignment.setTaskId(taskId);
                    assignment.setVolunteerId(volunteer.getId());
                    assignment.setStatus("ACTIVE");

                    task.setStatus("ACTIVE");
                    taskRecordRepository.save(task);

                    return taskAssignmentRecordRepository.save(assignment);
                }
            }
        }

        // 8. Correct exception handling (THIS FIXES YOUR TEST)
        if (skillFoundButLevelLow) {
            throw new BadRequestException("Skill level insufficient");
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
