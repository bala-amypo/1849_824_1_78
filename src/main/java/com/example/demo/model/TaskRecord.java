package.com.example.demo.model;
public class TaskRecord{
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
    public void setId(String id){
        this.id=id;
    }
    public String getTaskcode(){
        return taskcode;
    }
    public void setTaskcode(String taskcode){
        this.taskcode=taskcode;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }

    public String getEmail(){
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
}