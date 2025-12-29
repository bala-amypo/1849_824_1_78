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
        if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already assigned");
        }

        TaskRecord task = taskRecordRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        List<VolunteerProfile> volunteers =
                volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

        for (VolunteerProfile v : volunteers) {
            List<VolunteerSkillRecord> skills =
                    volunteerSkillRecordRepository.findByVolunteerId(v.getId());

            for (VolunteerSkillRecord s : skills) {
                if (s.getSkillName().equals(task.getRequiredSkill())
                        && SkillLevelUtil.hasRequiredSkillLevel(
                                s.getSkillLevel(), task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord assignment = new TaskAssignmentRecord();
                    assignment.setTaskId(taskId);
                    assignment.setVolunteerId(v.getId());
                    assignment.setStatus("ACTIVE");

                    task.setStatus("ACTIVE");
                    taskRecordRepository.save(task);

                    return taskAssignmentRecordRepository.save(assignment);
                }
            }
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
