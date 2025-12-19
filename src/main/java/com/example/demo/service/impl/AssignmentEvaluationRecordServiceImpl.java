package com.example.demo.service.impl;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AssignmentEvaluationRecordServiceImpl implements AssignmentEvaluationService{

@Autowired
AssignmentEvaluationRepository aer;
public AssignmentEvaluation createAssignmentEvaluation(AssignmentEvaluation ae){

    return aer.save(ae);
}


}