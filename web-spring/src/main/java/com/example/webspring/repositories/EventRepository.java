package com.example.webspring.repositories;

import com.example.webspring.entity.Event;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer>, JpaSpecificationExecutor<Event> {
    //все основные методы уже реализованы в Crud, нужно добавить тольк сложные если нужно

    // интерфейс со спецификациями JpaSpecificationExecutor




}
