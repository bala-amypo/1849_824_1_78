package com.example.demo.service.impl;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.entity.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService{

@Autowired
AssignmentEvaluationRepository gr;
public AssignmentEvaluation createGarage(Garage gar){

    return gr.save(gar);
}


}