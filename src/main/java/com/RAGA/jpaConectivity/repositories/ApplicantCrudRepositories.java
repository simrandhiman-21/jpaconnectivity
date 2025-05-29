package com.RAGA.jpaConectivity.repositories;

import com.RAGA.jpaConectivity.entity.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantCrudRepositories extends CrudRepository<Applicant, Long> {// Applicant is entity and long is datatype of our primaryKey

}
