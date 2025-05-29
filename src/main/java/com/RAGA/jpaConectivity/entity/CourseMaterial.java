package com.RAGA.jpaConectivity.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.mapping.Join;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")

public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name="COURSE_MATERIAL_SEQUENCE",
            sequenceName = "COURSE_MATERIAL_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COURSE_MATERIAL_SEQUENCE"
    )

    private long crmid;
    private String url;

    //CourseMaterial=parent
    //Course=child

//    CourseMaterial owns the relationship (because it has @JoinColumn).
    @OneToOne(
            cascade =CascadeType.ALL, //CascadeType.ALL means when you save CourseMaterial, the Course is also saved.
            fetch=FetchType.LAZY
    )
    @JoinColumn(
            name="course_id",
            referencedColumnName = "crid" //id from course entity
    )
    private Course course;

}
