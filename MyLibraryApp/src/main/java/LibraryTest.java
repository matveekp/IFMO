import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibraryTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("MyLibrary");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Library library = Library.getInstance();


        Filial filial1 = new Filial();
        Filial filial2 = new Filial();

        filial1.setName("Филиал 1");
        filial2.setName("Филиал 2");

        Faculty faculty1 = new Faculty();
        faculty1.setName("Факультет 1");

        Faculty faculty2 = new Faculty();
        faculty1.setName("Факультет 2");

        Author author1 = new Author();
        author1.setName("John");

        Author author2 = new Author();
        author2.setName("Bob");




        Book book1 = new Book();
        book1.setPageCount(500);
        book1.setAuthor(author1);
        book1.setCost(1000.00);
        book1.setFaculty(faculty1);


        Book book2 = new Book();
        book1.setPageCount(700);
        book1.setAuthor(author1);
        book1.setCost(800.00);
        book1.setFaculty(faculty1);


        Book book3 = new Book();
        book1.setPageCount(400);
        book1.setAuthor(author1);
        book1.setCost(6000.00);
        book1.setFaculty(faculty2);


        Student student1 = new Student();
        student1.setName("Студент 1");

        Student student2 = new Student();
        student2.setName("Студент 2");

        Publisher publisher1 = new Publisher();
        publisher1.setName("Издательство 1");




        library.getFilials().add(filial1);
        library.getFilials().add(filial2);











        entityManager.getTransaction().begin();



        entityManager.getTransaction().commit();




        entityManager.close();
        entityManagerFactory.close();
    }




}
