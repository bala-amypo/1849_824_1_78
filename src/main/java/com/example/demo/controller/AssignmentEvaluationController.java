// // package com.example.demo.controller;

// // import com.example.demo.dto.EvaluationRequest;
// // import com.example.demo.model.AssignmentEvaluationRecord;
// // import com.example.demo.service.AssignmentEvaluationService;

// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/api/evaluations")
// // public class AssignmentEvaluationController {

// //     private final AssignmentEvaluationService service;

// //     public AssignmentEvaluationController(
// //             AssignmentEvaluationService service) {
// //         this.service = service;
// //     }

// //     @PostMapping
// //     public AssignmentEvaluationRecord evaluate(
// //             @RequestBody EvaluationRequest request) {

// //         AssignmentEvaluationRecord record =
// //                 new AssignmentEvaluationRecord(
// //                         request.getAssignmentId(),
// //                         request.getRating(),
// //                         request.getComments()
// //                 );

// //         return service.evaluateAssignment(record);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.service.AssignmentEvaluationService;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @RestController
// @RequestMapping("/api/evaluations")
// public class AssignmentEvaluationController {

//     private final AssignmentEvaluationService service;

//     public AssignmentEvaluationController(AssignmentEvaluationService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public AssignmentEvaluationRecord evaluateAssignment(
//             @RequestBody AssignmentEvaluationRecord record) {
//         return service.evaluateAssignment(record);
//     }
// }
package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    @Autowired
    private AssignmentEvaluationService assignmentEvaluationService;

    @PostMapping
    public ResponseEntity<AssignmentEvaluationRecord> evaluateAssignment(@RequestBody AssignmentEvaluationRecord evaluation) {
        if (evaluation.getAssignmentId() == null || evaluation.getRating() == null) {
            throw new BadRequestException("Assignment ID and Rating are required");
        }
        AssignmentEvaluationRecord created = assignmentEvaluationService.evaluateAssignment(evaluation);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<AssignmentEvaluationRecord>> getEvaluationsByAssignment(@PathVariable Long assignmentId) {
        List<AssignmentEvaluationRecord> evaluations = assignmentEvaluationService.getEvaluationsByAssignment(assignmentId);
        return ResponseEntity.ok(evaluations);
    }
}