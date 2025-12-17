package.com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class AssignmentEvaluationRecord{
    @Id
    private Long id;
    private Long assignmentId;
    private Integer rating;
    private String feedback;
    private LocalDateTime evaluatedAt;
      
    public Long getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public Long getAssignedId(){
        return assignedId;
    }
    public void setAssignedId(Long assignedId){
        this.assignedId=assignedId;
    }
    public Integer getRating(){
        return rating;
    }
    public void setRating(Integer rating){
        this.rating=rating;
    }

    public String getFeedback(){
         return feedback;
    }
    public void setFeedback(String feedback){
        this.feedback=feedback;
    }
    public LocalDateTime getEvaluatedAt(){
         return evaluatedAt;
    }
    public void setEvaluatedAt(LocalDateTime evaluatedAt){
        this.evaluatedAt=evaluatedAt;
    }
    public AssignmentEvaluationRecord(Long id,Long assignmentId,Integer rating,String feedback,LocalDateTime evaluatedAt){
    this.id=id;
    this.assignmentId=assignedId;
    this.rating=rating;
    this.feedback=feedback;
    this.evaluatedAt=evaluatedAt;
}
public AssignmentEvaluationRecord(){

}
}