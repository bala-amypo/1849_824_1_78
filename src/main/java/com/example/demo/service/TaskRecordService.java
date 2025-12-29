// package com.example.demo.service;

// import com.example.demo.model.TaskRecord;
// import java.util.List;
// import java.util.Optional;

// public interface TaskRecordService {

//     TaskRecord createTask(TaskRecord task);

//     TaskRecord updateTask(Long id, TaskRecord task);

//     TaskRecord getTaskById(Long id); // REQUIRED

//     Optional<TaskRecord> getTaskByCode(String taskCode);

//     List<TaskRecord> getOpenTasks();

//     List<TaskRecord> getAllTasks();
// }
package com.example.demo.service;

import com.example.demo.model.TaskRecord;

import java.util.List;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    List<TaskRecord> getAllTasks();
}
