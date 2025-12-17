package.com.example.demo;
public class TaskAssignmentRecord{
    private Long id;
    private Long taskId;
    private Long volunteerId;
    private LocalDateTime assignedAt;
    private String status;
    private LocalDateTime createdAt;
      
    public Long getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public Long getTaskId(){
        return taskId;
    }
    public void setTaskId(Long taskId){
        this.taskId=taskId;
    }
    public Long getVolunteerId(){
        return volunteerId;
    }
    public void setVolunteerId(Long volunteerId){
        this.volunteerId=volunteerId;
    }

    public getL getAssignedAt(){
         return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPhone(){
         return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getAvailabilityStatus(){
         return availabilityStatus;
    }
    public void setAvailabilityStatus(String availabilityStatus){
        this.availabilityStatus=availabilityStatus;
    }

    public LocalDateTime getCreatedAt(){
         return email;
    }
    public void setEmail(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}
