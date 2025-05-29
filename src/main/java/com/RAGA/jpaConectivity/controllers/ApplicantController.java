package com.RAGA.jpaConectivity.controllers;

import com.RAGA.jpaConectivity.entity.Applicant;
import com.RAGA.jpaConectivity.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.getAllApplicants();
    }

    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        return applicantService.saveApplicantCurd(applicant);
    }
}
