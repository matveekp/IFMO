package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Library {

    private static Library ourInstance = new Library();

    public static Library getInstance() {
        return ourInstance;
    }

    private Library() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Author> authors = new ArrayList<Author>();

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Book> books = new ArrayList<Book>();

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Student> students = new ArrayList<Student>();

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Faculty> faculties = new ArrayList<Faculty>();

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Filial> filials = new ArrayList<Filial>();

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Publisher> publishers = new ArrayList<Publisher>();

    public static Library getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Library ourInstance) {
        Library.ourInstance = ourInstance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Filial> getFilials() {
        return filials;
    }

    public void setFilials(List<Filial> filials) {
        this.filials = filials;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }
}
