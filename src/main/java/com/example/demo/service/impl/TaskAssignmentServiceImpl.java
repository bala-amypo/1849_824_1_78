package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;

import java.util.List;

public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository tar;
    private final TaskRecordRepository tr;
    private final VolunteerProfileRepository vr;
    private final VolunteerSkillRecordRepository sr;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository tar,
            TaskRecordRepository tr,
            VolunteerProfileRepository vr,
            VolunteerSkillRecordRepository sr) {
        this.tar = tar;
        this.tr = tr;
        this.vr = vr;
        this.sr = sr;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        if (tar.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment exists");
        }

        TaskRecord task = tr.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        List<VolunteerProfile> volunteers =
                vr.findByAvailabilityStatus("AVAILABLE");

        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        for (VolunteerProfile v : volunteers) {
            List<VolunteerSkillRecord> skills =
                    sr.findByVolunteerId(v.getId());

            for (VolunteerSkillRecord s : skills) {
                if (s.getSkillName().equals(task.getRequiredSkill()) &&
                    SkillLevelUtil.levelRank(s.getSkillLevel()) >=
                    SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord rec = new TaskAssignmentRecord();
                    rec.setTaskId(taskId);
                    rec.setVolunteerId(v.getId());

                    task.setStatus("ACTIVE");
                    tr.save(task);

                    return tar.save(rec);
                }
            }
        }

        throw new BadRequestException("required skill level not met");
    }

    // other getters used in tests
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long id) {
        return tar.findByTaskId(id);
    }

    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long id) {
        return tar.findByVolunteerId(id);
    }

    public List<TaskAssignmentRecord> getAllAssignments() {
        return tar.findAll();
    }
}
