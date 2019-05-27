package com.example.webspring.controller;

import com.example.webspring.entity.Event;
import com.example.webspring.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/event/add" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute Event event, Model model){

        model.addAttribute("event", new Event());
        return "add_event";
    }

    @RequestMapping(value = "/event/add" , method = RequestMethod.POST)
    private String submitForm(@ModelAttribute Event event, Model model) {

        eventRepository.save(event);
        model.addAttribute("addInfo", event.getEventTitle()); //передаем оратно название события
        return "add_event";
    }



}
