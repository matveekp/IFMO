package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "faculty_book", //отвечает за формирование временной таблицы
            joinColumns = @JoinColumn(name = "faculty_id"),  // связь с текущей таблицей
            inverseJoinColumns = @JoinColumn (name = "book_id"))  // связь с другой таблицей
    private List<Book> books = new ArrayList<Book>();


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
