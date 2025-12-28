// package com.example.demo.dto;

// public class AssignmentStatusUpdateRequest {

//     private Long assignmentId;
//     private String status;

//     public AssignmentStatusUpdateRequest() {
//     }

//     public AssignmentStatusUpdateRequest(Long assignmentId, String status) {
//         this.assignmentId = assignmentId;
//         this.status = status;
//     }

//     public Long getAssignmentId() {
//         return assignmentId;
//     }

//     public void setAssignmentId(Long assignmentId) {
//         this.assignmentId = assignmentId;
//     }

//     public String getStatus() {
//         return status;
//     }
    
//     public void setStatus(String status) {
//         this.status = status;
//     }
// }
package com.example.demo.dto;

public class EvaluationRequest {

    private Long assignmentId;
    private Integer rating;
    private String feedback;

    public EvaluationRequest() {}

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
