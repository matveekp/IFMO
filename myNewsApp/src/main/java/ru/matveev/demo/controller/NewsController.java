package ru.matveev.demo.controller;


import ru.matveev.demo.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.matveev.demo.repositories.NewsRepository;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value = "/news/add" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute News event, Model model){

        model.addAttribute("news", new News());
        return "add_news";
    }

    @RequestMapping(value = "/news/add" , method = RequestMethod.POST)
    public String submitForm(@ModelAttribute News news, Model model) {

        newsRepository.save(news);
        model.addAttribute("addInfo", news.getTitle());
        return "add_news";
    }




}
