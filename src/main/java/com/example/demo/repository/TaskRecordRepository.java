package com.example.demo.repository;
import org.springframework.data.jap.repository.JpaRepository;
import com.example.demo.Entityclass.TaskRecordRepository;
public interface TaskRecordRepository extends JpaRepository< TaskRecordRepository,Long>{
    
}