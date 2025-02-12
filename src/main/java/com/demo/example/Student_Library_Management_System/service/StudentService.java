package com.demo.example.Student_Library_Management_System.service;

import com.demo.example.Student_Library_Management_System.controller.StudentController;
import com.demo.example.Student_Library_Management_System.converters.StudentConverter;
import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.enums.CardStatus;
import com.demo.example.Student_Library_Management_System.model.Card;
import com.demo.example.Student_Library_Management_System.model.Student;
import com.demo.example.Student_Library_Management_System.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
import static org.hibernate.query.Page.page;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    Logger logger= LoggerFactory.getLogger(StudentService.class);

    public String addStudent(StudentRequestDto studentRequestDto){
         logger.info("addStudent methods started");

         Student student= StudentConverter.convertStudentRequestDtoToStudent(studentRequestDto);
     //  whenever the student is created card is also created for that student
         Card card=new Card();
         card.setCardStatus(CardStatus.ACTIVE);
         card.setStudent(student);
         student.setCard(card);

        logger.info("Card information is also saving in database along with Student");
         studentRepository.save(student);

        logger.info("addStudent methods ended");
         return "Student and Card are created";
    }

    public List<Student> getAllStudent(){

        List<Student> studentList = studentRepository.findAll();

        if(studentList.isEmpty()){
            throw new RuntimeException("Student List is not found");
        }
        return studentList;
    }

    /*
    pagination-> fetching records or data in the form of page
    pageNumber-> number of page we want to see(page number starts with 0,1,2,3,4,......)
    pageSize-> total number of page in each record( and it is fixed in each page)
    database-> total records = 28 , pagesize=5
    0th page->1-5
    1st page->6-10
    2nd page->11-15
    3rd page->16-20
    4th page->21-25
    5th page->26-28
     */

    public List<Student> getAllStudentsByPages(int pageNo, int pageSize,String sortInput){
     Page<Student> studentPage  =studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortInput).ascending()));
       // we can not send studentPage output directly
       // so we need to convert page into the list and send list as output

        List<Student> studentList= new ArrayList<>();
        for(Student std1:studentPage){
            studentList.add(std1);
        }
     return studentList;
    }

    public Student getStudentById(int studentId){

        logger.info("getStudentById method started");

        Student student=studentRepository.findById(studentId).get();

        if(student==null){
            logger.error("Student not found");
            throw new RuntimeException("Student are not found with id :"+studentId);
        }
        logger.info("getStudentById method ended");
        return student ;
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);

        return "Student got deleted successfully";
    }

    public String countStudent(){
        long totlecount= studentRepository.count();
        return "the number of students present is: "+totlecount;
    }

    public String updateStudent(StudentRequestDto studentRequestDto, int studentId){
        Student student= getStudentById(studentId);
        if(student==null){
            throw new RuntimeException("Student is not present with id: "+studentId);
        }
        if(student!=null){

           student.setName(studentRequestDto.getName());
           student.setEmail(studentRequestDto.getEmail());
           student.setAge(studentRequestDto.getAge());
           student.setMobile(studentRequestDto.getMobile());
           student.setAddress(studentRequestDto.getAddress());

            studentRepository.save(student);
            return "Student updated successfully";
        }
        else{
            return "Student with studentId :"+studentId+" not found";
        }

    }

    public Student getStudentByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student;
    }


    public Student getStudentByEmailQuery(String email){
        Student student=studentRepository.findByEmail(email);
        return student;
    }
}
