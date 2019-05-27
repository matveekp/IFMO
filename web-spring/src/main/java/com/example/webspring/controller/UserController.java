package com.example.webspring.controller;

import com.example.webspring.entity.AppUser;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller // аннотация говорит что класс будет обрабатывать запросы
public class UserController {

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String showForm(AppUser appUser){

        return "registration";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute @Valid AppUser appUser, BindingResult result){

        if (result.hasErrors()){ // если форма заполнена с ошибками

            return "registration"; // если есть ошибки, возвращаем ту же самую страницу
        }

        System.out.println(appUser);

        //добавить в базу
        // отобразить страницу с авторизацией
        return "registration";
    }

}
