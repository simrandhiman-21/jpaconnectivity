package com.RAGA.jpaConectivity.repositories;

import com.RAGA.jpaConectivity.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long>{
}
