// // package com.example.demo.service.impl;

// // import com.example.demo.exception.BadRequestException;
// // import com.example.demo.model.TaskAssignmentRecord;
// // import com.example.demo.model.TaskRecord;
// // import com.example.demo.model.VolunteerProfile;
// // import com.example.demo.model.VolunteerSkillRecord;
// // import com.example.demo.repository.TaskAssignmentRecordRepository;
// // import com.example.demo.repository.TaskRecordRepository;
// // import com.example.demo.repository.VolunteerProfileRepository;
// // import com.example.demo.repository.VolunteerSkillRecordRepository;
// // import com.example.demo.service.TaskAssignmentService;
// // import com.example.demo.util.SkillLevelUtil;
// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service    
// // public class TaskAssignmentServiceImpl implements TaskAssignmentService {

// //     private final TaskAssignmentRecordRepository taskAssignmentRecordRepository;
// //     private final TaskRecordRepository taskRecordRepository;
// //     private final VolunteerProfileRepository volunteerProfileRepository;
// //     private final VolunteerSkillRecordRepository volunteerSkillRecordRepository;

// //     public TaskAssignmentServiceImpl(
// //             TaskAssignmentRecordRepository taskAssignmentRecordRepository,
// //             TaskRecordRepository taskRecordRepository,
// //             VolunteerProfileRepository volunteerProfileRepository,
// //             VolunteerSkillRecordRepository volunteerSkillRecordRepository
// //     ) {
// //         this.taskAssignmentRecordRepository = taskAssignmentRecordRepository;
// //         this.taskRecordRepository = taskRecordRepository;
// //         this.volunteerProfileRepository = volunteerProfileRepository;
// //         this.volunteerSkillRecordRepository = volunteerSkillRecordRepository;
// //     }

// //     @Override
// //     public TaskAssignmentRecord assignTask(Long taskId) {

// //         if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
// //             throw new BadRequestException("ACTIVE assignment exists");
// //         }

// //         TaskRecord task = taskRecordRepository.findById(taskId)
// //                 .orElseThrow(() -> new BadRequestException("Task not found"));

// //         List<VolunteerProfile> volunteers =
// //                 volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

// //         if (volunteers.isEmpty()) {
// //             throw new BadRequestException("No AVAILABLE volunteers");
// //         }

// //         for (VolunteerProfile volunteer : volunteers) {
// //             List<VolunteerSkillRecord> skills =
// //                     volunteerSkillRecordRepository.findByVolunteerId(volunteer.getId());

// //             for (VolunteerSkillRecord skill : skills) {
// //                 if (skill.getSkillName().equals(task.getRequiredSkill()) &&
// //                         SkillLevelUtil.levelRank(skill.getSkillLevel()) >=
// //                                 SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

// //                     TaskAssignmentRecord record = new TaskAssignmentRecord();
// //                     record.setTaskId(taskId);
// //                     record.setVolunteerId(volunteer.getId());

// //                     task.setStatus("ACTIVE");
// //                     taskRecordRepository.save(task);

// //                     return taskAssignmentRecordRepository.save(record);
// //                 }
// //             }
// //         }

// //         throw new BadRequestException("required skill level not met");
// //     }

// //     @Override
// //     public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
// //         return taskAssignmentRecordRepository.findByTaskId(taskId);
// //     }

// //     @Override
// //     public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
// //         return taskAssignmentRecordRepository.findByVolunteerId(volunteerId);
// //     }

// //     @Override
// //     public List<TaskAssignmentRecord> getAllAssignments() {
// //         return taskAssignmentRecordRepository.findAll();
// //     }
// // }
// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.model.TaskRecord;
// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.repository.TaskAssignmentRecordRepository;
// import com.example.demo.repository.TaskRecordRepository;
// import com.example.demo.repository.VolunteerProfileRepository;
// import com.example.demo.repository.VolunteerSkillRecordRepository;
// import com.example.demo.service.TaskAssignmentService;
// import com.example.demo.util.SkillLevelUtil;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TaskAssignmentServiceImpl implements TaskAssignmentService {

//     private final TaskAssignmentRecordRepository taskAssignmentRecordRepository;
//     private final TaskRecordRepository taskRecordRepository;
//     private final VolunteerProfileRepository volunteerProfileRepository;
//     private final VolunteerSkillRecordRepository volunteerSkillRecordRepository;

//     public TaskAssignmentServiceImpl(
//             TaskAssignmentRecordRepository taskAssignmentRecordRepository,
//             TaskRecordRepository taskRecordRepository,
//             VolunteerProfileRepository volunteerProfileRepository,
//             VolunteerSkillRecordRepository volunteerSkillRecordRepository
//     ) {
//         this.taskAssignmentRecordRepository = taskAssignmentRecordRepository;
//         this.taskRecordRepository = taskRecordRepository;
//         this.volunteerProfileRepository = volunteerProfileRepository;
//         this.volunteerSkillRecordRepository = volunteerSkillRecordRepository;
//     }

//     @Override
//     public TaskAssignmentRecord assignTask(Long taskId) {

//         // Prevent duplicate ACTIVE assignment
//         if (taskAssignmentRecordRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
//             throw new BadRequestException("ACTIVE assignment exists");
//         }

//         TaskRecord task = taskRecordRepository.findById(taskId)
//                 .orElseThrow(() -> new BadRequestException("Task not found"));

//         List<VolunteerProfile> volunteers =
//                 volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

//         if (volunteers.isEmpty()) {
//             throw new BadRequestException("No AVAILABLE volunteers");
//         }

//         for (VolunteerProfile volunteer : volunteers) {

//             Long volunteerId = volunteer.getId(); // ✅ FIXED

//             List<VolunteerSkillRecord> skills =
//                     volunteerSkillRecordRepository.findByVolunteerId(volunteerId);

//             for (VolunteerSkillRecord skill : skills) {
//                 if (skill.getSkillName().equals(task.getRequiredSkill()) &&
//                         SkillLevelUtil.levelRank(skill.getSkillLevel()) >=
//                                 SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

//                     TaskAssignmentRecord record = new TaskAssignmentRecord();
//                     record.setTaskId(taskId);
//                     record.setVolunteerId(volunteerId);
//                     record.setStatus("ACTIVE");

//                     task.setStatus("ACTIVE");
//                     taskRecordRepository.save(task);

//                     return taskAssignmentRecordRepository.save(record);
//                 }
//             }
//         }

//         throw new BadRequestException("required skill level not met");
//     }

//     @Override
//     public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
//         return taskAssignmentRecordRepository.findByTaskId(taskId);
//     }

//     @Override
//     public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
//         return taskAssignmentRecordRepository.findByVolunteerId(volunteerId);
//     }

//     @Override
//     public List<TaskAssignmentRecord> getAllAssignments() {
//         return taskAssignmentRecordRepository.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
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
public class TaskAssignmentServiceImpl
        implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository profileRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository assignmentRepo,
            TaskRecordRepository taskRepo,
            VolunteerProfileRepository profileRepo,
            VolunteerSkillRecordRepository skillRepo) {
        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment exists");
        }

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        List<VolunteerProfile> volunteers =
                profileRepo.findByAvailabilityStatus("AVAILABLE");

        for (VolunteerProfile volunteer : volunteers) {

            List<VolunteerSkillRecord> skills =
                    skillRepo.findByVolunteerId(volunteer.getId());

            for (VolunteerSkillRecord skill : skills) {
                if (skill.getSkillName().equals(task.getRequiredSkill()) &&
                        SkillLevelUtil.levelRank(skill.getSkillLevel()) >=
                                SkillLevelUtil.levelRank(
                                        task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord record =
                            new TaskAssignmentRecord();
                    record.setTaskId(taskId);
                    record.setVolunteerId(volunteer.getId());
                    record.setStatus("ACTIVE");

                    task.setStatus("ACTIVE");
                    taskRepo.save(task);

                    return assignmentRepo.save(record);
                }
            }
        }

        throw new BadRequestException(
                "required skill level not met");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(
            Long taskId) {
        return assignmentRepo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            Long volunteerId) {
        return assignmentRepo.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentRepo.findAll();
    }
}
