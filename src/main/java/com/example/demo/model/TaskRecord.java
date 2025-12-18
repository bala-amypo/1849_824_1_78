package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class TaskRecord{
    @Id
    private Long id;
    private String taskcode;
    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status;
    private LocalDateTime createdAt;
      
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTaskcode(){
        return taskcode;
    }
    public void setTaskcode(String taskcode){
        this.taskcode=taskcode;
    }
    public String getTaskName(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName=taskName;
    }

    public String getRequiredSkill(){
         return requiredSkill;
    }
    public void setRequiredSkill(String requiredSkill){
        this.requiredSkill=requiredSkill;
    }
    public String getRequiredSkillLevel(){
         return requiredSkillLevel;
    }
    public void setRequiredSkillLevel(String requiredSkillLevel){
        this.requiredSkillLevel=requiredSkillLevel;
    }

    public String getPriority(){
         return priority;
    }
    public void setPriority(String priority){
        this.priority=priority;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;

    }

    public LocalDateTime getCreatedAt(){
         return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public TaskRecord(Long id,String taskcode,String taskName,String requiredSkill,String requiredSkillLevel,String priority,String status,LocalDateTime createdAt){
    this.id=id;
    this.taskcode=taskcode;
    this.taskName=taskName;
    this.requiredSkill=requiredSkill;
    this.requiredSkillLevel=requiredSkillLevel;
    this.priority=priority;
    this.status=status;
    this.createdAt=createdAt;
}
public TaskRecord(){

}
}