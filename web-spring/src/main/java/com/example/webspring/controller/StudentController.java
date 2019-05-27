package com.example.webspring.controller;

import com.example.webspring.entity.Event;
import com.example.webspring.entity.Student;
import com.example.webspring.entity.University;
import com.example.webspring.repositories.EventRepository;
import com.example.webspring.repositories.StudentRepository;
import com.example.webspring.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController  {

    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String showForm(Model model
    // если только передаем на страницу, то достаточно Model, а если получаем из форм, то @ModelAttribute(POST)
    ){

        model.addAttribute("universities", universityRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("student" , new Student()); // возвращаем нового студента, для коотрого будем заполнять форму
        return "add_student"; //метод должен возвращать страницу с формой

    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Student student
//        @ModelAttribute Student student из формы получаем студента
        , @RequestParam (name = "universityId") int universityId, //сюда придет то что мы указали в th:value="${university.id}"
          @RequestParam (name = "eventId") int eventId,
        Model model
    ){

        University university = universityRepository.findById(universityId).get();
        Event event = eventRepository.findById(eventId).get();

        String studentCode = student.getStudentCode();
        boolean isPresent = studentRepository.findByCode(studentCode).isPresent();

        if (isPresent){
            // обновляем студента, если такой уже етсь
            Student presentStudent = studentRepository.findByCode(studentCode).get();
            updateStudentInfo(presentStudent, event, university);
            studentRepository.save(presentStudent);
        }
        else {
            //если студента такого еще нет, добавляем его
            updateStudentInfo(student, event, university);
            studentRepository.save(student);


        }

        model.addAttribute("universities", universityRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("student" , new Student()); // возвращаем нового студента, для коотрого будем заполнять форму

        return "add_student";
    }

    private void updateStudentInfo(Student student, Event event, University university){

        student.getEvents().add(event);
        student.setUniversity(university);

        university.getStudents().add(student);

        event.getStudents().add(student);


    }
}
