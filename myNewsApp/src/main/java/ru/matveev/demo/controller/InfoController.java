package ru.matveev.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // класс будет реагировать на запросы
public class InfoController {

    // на какой запрос какой метод будет вызван
    @RequestMapping("/")
    public String index(){
        return "index";     // имя файла в папке с template
                            // если файл лежит в подпапке, то        folder/index
    }

    @RequestMapping("/test")
    public String test(){
        return "test";     // имя файла в папке с template
        // если файл лежит в подпапке, то        folder/index
    }


}
