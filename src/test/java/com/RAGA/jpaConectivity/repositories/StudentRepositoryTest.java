package com.RAGA.jpaConectivity.repositories;

import com.RAGA.jpaConectivity.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    //StudentRepository is a Spring Bean (because it extends JpaRepository).
    //Spring Boot creates the bean and puts it inside ApplicationContext.

    @Test
    public void savestudent(){
        //Student st = new Student(null, "seennu", "1234567890");
        Student st = Student.builder() //you have added @Builder on your Student entity.
                .name("Alice")
                .phone("0215")
                .build();


        studentRepository.save(st);
    }

    @Test
    public void printAllStudents(){
        List<Student> list=studentRepository.findAll();
        System.out.println(list);
    }


    @Test
    public void findByName(){
        List<Student> studentbynamefound=studentRepository.findByName("seenu");
        System.out.println("Student Found "+ studentbynamefound);
    }


    //Query
    //JPQL
    //native
    //param

    ////JPQL
    @Test
    public void getStudentByPhone(){
        Student studentbynamefoundUsingPhone=studentRepository.getStudentByPhone("12345");
        System.out.println("Student Found "+ studentbynamefoundUsingPhone);
    }

    ////native
    @Test
    public void getStudentByPhoneNative(){
        Student studentbynamefoundUsingPhone=studentRepository.getStudentByPhone("98854");
        System.out.println("Student Found "+ studentbynamefoundUsingPhone);
    }

    ////param
    @Test
    public void getStudentByPhoneparam() {
        // Call the repository method to get students by phone
        List<Student> students = studentRepository.getStudentByPhoneparam("0215");
        System.out.println("Student Found: " + students);
    }

    //modifying

    //update
    @Test
    public void updateStudentPhoneUsingModifying() {
        int result = studentRepository.updateStudentPhoneByName("seenu", "8877995566");
        System.out.println("Rows updated: " + result);
    }

    //delete
    @Test
    public void deleteStudentPhoneUsingModifying() {
        int result = studentRepository.deleteStudentByPhone("1234567890");
        System.out.println("Rows updated: " + result);
    }

    //insert
    @Test
    public void insertStudentPhoneUsingModifying() {
        studentRepository.insertStudent("karan","99999999");
    }


}