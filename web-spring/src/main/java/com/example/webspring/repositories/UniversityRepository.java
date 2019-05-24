package com.example.webspring.repositories;

import com.example.webspring.entity.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Integer> {
    //все основные методы уже реализованы, нужно добавить тольк сложные если нужно
}
