package com.RAGA.jpaConectivity.repositories;

import com.RAGA.jpaConectivity.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>{

    public List<Student> findByName(String name);

    //JPQL
    //Student s =The Student here refers to the entity class Student, not a database table.
    @Query("Select s from Student s where s.phone=?1")
    Student getStudentByPhone(String phone);


    //Native
    @Query(value ="Select s from student s where s.phone=?1", nativeQuery=true)
    Student getStudentByPhoneNative(String phone);

    //Param
    @Query("SELECT s FROM Student s WHERE s.phone = :phone")
    List<Student> getStudentByPhoneparam(@Param("phone") String phone);


    //modifying

    ////update
    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.phone = :phone WHERE s.name = :name")
    int updateStudentPhoneByName(@Param("name") String name, @Param("phone") String phone);

    ////delete
    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.phone = :phone")
    int deleteStudentByPhone(@Param("phone") String phone);

    ////insert
    @Transactional
    @Modifying
    @Query("INSERT INTO Student (name, phone) VALUES (:name, :phone)")
    void insertStudent(@Param("name") String name, @Param("phone") String phone);




}
