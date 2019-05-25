package ru.matveev.demo.repositories;

import ru.matveev.demo.entity.News;
import org.springframework.data.repository.CrudRepository;


public interface NewsRepository extends CrudRepository<News, Integer> {



}
