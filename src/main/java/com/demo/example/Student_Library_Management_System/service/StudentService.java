package com.demo.example.Student_Library_Management_System.service;

import com.demo.example.Student_Library_Management_System.controller.StudentController;
import com.demo.example.Student_Library_Management_System.converters.StudentConverter;
import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.enums.CardStatus;
import com.demo.example.Student_Library_Management_System.model.Card;
import com.demo.example.Student_Library_Management_System.model.Student;
import com.demo.example.Student_Library_Management_System.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public String addStudent(StudentRequestDto studentRequestDto){


         Student student= StudentConverter.convertStudentRequestDtoToStudent(studentRequestDto);
     //  whenever the student is created card is also created for that student
         Card card=new Card();
         card.setCardStatus(CardStatus.ACTIVE);
         card.setStudent(student);
         student.setCard(card);

         studentRepository.save(student);

         return "Student and Card are created";
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getStudentById(int studentId){
        Student student=studentRepository.findById(studentId).get();
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
}
