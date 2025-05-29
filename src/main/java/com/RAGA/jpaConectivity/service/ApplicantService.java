package com.RAGA.jpaConectivity.service;

import com.RAGA.jpaConectivity.entity.Applicant;
import com.RAGA.jpaConectivity.repositories.ApplicantCrudRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepositories applicantCrudRepositories;

    public List<Applicant> getAllApplicants(){
        List<Applicant> applicantList = (List<Applicant>) applicantCrudRepositories.findAll();
        return applicantList;
    }

    public Applicant saveApplicantCurd(Applicant applicant){
        return applicantCrudRepositories.save(applicant);
    }
}
