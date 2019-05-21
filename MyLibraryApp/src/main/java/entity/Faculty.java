package entity;

import javax.persistence.*;

@Entity
@Table
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



}
