package.com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class VolunteerProfile{
    @Id
    private Long id;
    private String volunteer;
    private String fullName;
    private String email;
    private String phone;
    private String availabilityStatus;
    private LocalDateTime createdAt;
     
    public Long getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getVolunteer(){
        return volunteer;
    }
    public void setVolunteer(String volunteer){
        this.volunteer=volunteer;
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