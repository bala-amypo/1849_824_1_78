// package com.example.demo.controller;

// import com.example.demo.dto.EvaluationRequest;
// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.service.AssignmentEvaluationService;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/evaluations")
// public class AssignmentEvaluationController {

//     private final AssignmentEvaluationService service;

//     public AssignmentEvaluationController(
//             AssignmentEvaluationService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public AssignmentEvaluationRecord evaluate(
//             @RequestBody EvaluationRequest request) {

//         AssignmentEvaluationRecord record =
//                 new AssignmentEvaluationRecord(
//                         request.getAssignmentId(),
//                         request.getRating(),
//                         request.getComments()
//                 );

//         return service.evaluateAssignment(record);
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public AssignmentEvaluationRecord evaluate(
            @Valid @RequestBody EvaluationRequest request) {

        AssignmentEvaluationRecord record =
                new AssignmentEvaluationRecord(
                        request.getAssignmentId(),
                        request.getRating(),
                        request.getComments()
                );

        return service.evaluateAssignment(record);
    }
}
