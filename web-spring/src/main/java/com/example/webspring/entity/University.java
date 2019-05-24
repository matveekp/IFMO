package com.example.webspring.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table

public class University {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment") // аннотация spring
    private int id;

    private String universityName;


    @OneToMany(mappedBy = "university", //имя поля, которое в студентах
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true // когда в одной таблице удаляется, во всех связанных тоже
    )
    private List<Student> students = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
