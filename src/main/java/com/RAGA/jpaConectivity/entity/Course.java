package com.RAGA.jpaConectivity.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Course {

    @Id
    @SequenceGenerator(
            name = "COURSE_SEQUENCE",
            sequenceName = "COURSE_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COURSE_SEQUENCE"
    )
    private long crid;
    private String title;
    private int credit;


    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;



}
