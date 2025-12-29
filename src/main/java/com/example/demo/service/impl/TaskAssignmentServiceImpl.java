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

        // ✅ 1. Load task FIRST (test requirement)
        TaskRecord task = taskRecordRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        // ✅ 2. Check for existing ACTIVE assignment
        if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has an ACTIVE assignment");
        }

        // ✅ 3. Fetch AVAILABLE volunteers
        List<VolunteerProfile> availableVolunteers =
                volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

        if (availableVolunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        VolunteerProfile selectedVolunteer = null;

        for (VolunteerProfile volunteer : availableVolunteers) {
            List<VolunteerSkillRecord> skills =
                    volunteerSkillRecordRepository.findByVolunteerId(volunteer.getId());

            for (VolunteerSkillRecord skill : skills) {
                if (skill.getSkillName().equals(task.getRequiredSkill()) &&
                        SkillLevelUtil.hasRequiredSkillLevel(
                                skill.getSkillLevel(),
                                task.getRequiredSkillLevel())) {

                    selectedVolunteer = volunteer;
                    break;
                }
            }

            if (selectedVolunteer != null) break;
        }

        if (selectedVolunteer == null) {
            throw new BadRequestException(
                    "No volunteer meets the required skill level");
        }

        // ✅ 4. Create assignment
        TaskAssignmentRecord assignment = new TaskAssignmentRecord();
        assignment.setTaskId(taskId);
        assignment.setVolunteerId(selectedVolunteer.getId());
        assignment.setStatus("ACTIVE");

        TaskAssignmentRecord saved =
                taskAssignmentRecordRepository.save(assignment);

        // ✅ 5. Update task status
        task.setStatus("ACTIVE");
        taskRecordRepository.save(task);

        return saved;
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
