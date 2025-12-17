package.com.example.demo.model;
public class VolunteerProfile{
    private Long id;
    private String volunteer;
    private String fullName;
    private String email;
    private String phone;
    private String availabilityStatus;
    private LocalDataTime createdAt;
     
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
    public String FullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
}