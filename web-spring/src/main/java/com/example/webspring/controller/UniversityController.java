package com.example.webspring.controller;

import com.example.webspring.entity.University;
import com.example.webspring.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UniversityController {
    @Autowired //любые объекты отмеченные этой аннотацией будут созданы
    private UniversityRepository universityRepository;

    @RequestMapping(value = "/university/add", method = RequestMethod.GET)
    //если придет такой запрос с методом гет, отработает метод, который должен открыть страницу
    public String showForm(@ModelAttribute University university, Model model){
        // model передает данные из java в tf (который в html)
        model.addAttribute("university", new University());

        //когда форма отобразится, к ней будет привязан пустой объект. Потом будут добавляться поля

        return "add_university";
    }


    @RequestMapping(value = "/university/add", method = RequestMethod.POST)
    // пользователь отправил данные на сервер, мы их должны добавить в базу и вернуть страницу
    private String submitForm(@ModelAttribute University university, Model model){
        // здесь model вернет объект

        universityRepository.save(university);
        model.addAttribute("addInfo", university.getUniversityName()); //передаем оратно название университета
        return "add_university";
    }




}
