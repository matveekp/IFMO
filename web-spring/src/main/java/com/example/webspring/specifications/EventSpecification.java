package com.example.webspring.specifications;

import com.example.webspring.entity.Event;
import org.springframework.data.jpa.domain.Specification;

public class EventSpecification {

    // событие по названию
    public static Specification<Event> eventByTitle(String title){

        return (Specification<Event>)(root, criteriaQuery, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("eventTitle"), title);

        // root это таблица с которой мы работаем, создается автоматически на основе типа данных Event,
        // проверяем то что в табличке root.get("eventTitle")
        // и то что передали - title
    }

}
