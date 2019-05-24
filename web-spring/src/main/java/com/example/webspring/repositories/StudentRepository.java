package com.example.webspring.repositories;

import com.example.webspring.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    //все основные методы уже реализованы, нужно добавить тольк сложные если нужно
    // уже есть:
    // добавление записи
    // удаление записи
    // обновление записи
    // получение по первичному ключу
    // получение всех записей

    @Query("SELECT c FROM Student c WHERE c.studentCode = :studentCode")
        // сюда должны прийти данные
    Optional<Student> findByCode(@Param("studentCode") String studentCode);
    // когда будет вызван метод findbycode мы передадим код
    // optional удобен тем, что если не найдет ничего, то ошибок не будет

//    если второй параметр:
//    @Query("SELECT c FROM Student c WHERE c.studentCode = :studentCode AND c.id = :some_id")
//    Optional<Student> findByCode(@Param("studentCode") String studentCode, @Param("some_id) int i);

}


