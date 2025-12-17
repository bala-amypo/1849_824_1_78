package.com.example.demo;
public class AssignmentEvaliationRecord{
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

}