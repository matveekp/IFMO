package com.gpch.login.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //	генерация всех служебных методов,
//заменяет сразу команды @ToString, @EqualsAndHashCode,
//        Getter, Setter, @RequiredArgsConstructor
@Builder //реализация паттерна bulder,
//Singular – используется для объектов в
//        единственном экземпляре (добавления элемента
//        в коллекции и т.п.)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
