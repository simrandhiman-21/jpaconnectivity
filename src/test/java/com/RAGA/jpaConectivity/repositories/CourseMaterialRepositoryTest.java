package com.RAGA.jpaConectivity.repositories;

import com.RAGA.jpaConectivity.entity.Course;
import com.RAGA.jpaConectivity.entity.CourseMaterial;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository; //through this save to database

    @Test
    public  void saveCourseMaterial(){

        Course course=Course.builder()
                .title("JPA")
                .credit(4)
                .build();

        // entity
        CourseMaterial courseMaterial=CourseMaterial.builder()
                 .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }
    //try to save course without coursee material so use cascade

    //print
    @Test
    public void printCoursematerial(){
        List<CourseMaterial> list=repository.findAll();
        System.out.println(list);
    }



}