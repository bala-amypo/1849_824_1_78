package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
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

        // 1️⃣ Fetch task
        TaskRecord task = taskRecordRepository.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        // 2️⃣ Ensure only one ACTIVE assignment
        if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment already exists");
        }

        // 3️⃣ Fetch AVAILABLE volunteers
        List<VolunteerProfile> volunteers =
                volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        // 4️⃣ Match volunteer by skill and level
        for (VolunteerProfile volunteer : volunteers) {

            List<VolunteerSkillRecord> skills =
                    volunteerSkillRecordRepository.findByVolunteerId(volunteer.getId());

            for (VolunteerSkillRecord skill : skills) {

                if (skill.getSkillName().equalsIgnoreCase(task.getRequiredSkill())) {

                    int volunteerRank =
                            SkillLevelUtil.levelRank(skill.getSkillLevel());
                    int requiredRank =
                            SkillLevelUtil.levelRank(task.getRequiredSkillLevel());

                    // 5️⃣ Skill level insufficient
                    if (volunteerRank < requiredRank) {
                        throw new BadRequestException(
                                "Volunteer does not meet required skill level");
                    }

                    // 6️⃣ Assign task
                    TaskAssignmentRecord assignment = new TaskAssignmentRecord();
                    assignment.setTaskId(taskId);
                    assignment.setVolunteerId(volunteer.getId());
                    assignment.setStatus("ACTIVE");

                    task.setStatus("ASSIGNED");

                    taskRecordRepository.save(task);
                    return taskAssignmentRecordRepository.save(assignment);
                }
            }
        }

        throw new BadRequestException("No suitable volunteer found");
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentRecordRepository.findAll();
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return taskAssignmentRecordRepository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return taskAssignmentRecordRepository.findByVolunteerId(volunteerId);
    }
}
