import entity.*;
import repository.BookRepository;
import repository.FilialRepository;
import repository.LibraryRepository;
import specification.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LibraryTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("MyLibrary");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        BookRepository bookRepository = new BookRepository(entityManager);
        LibraryRepository libraryRepository = new LibraryRepository(entityManager);
        FilialRepository filialRepository = new FilialRepository(entityManager);



        Library library = new Library();
        library.setName("Центральная библиотека");
//----------------------------------------------


        Filial filial1 = new Filial();
        Filial filial2 = new Filial();
        filial1.setName("Филиал 1");
        filial2.setName("Филиал 2");

        library.getFilials().add(filial1);
        library.getFilials().add(filial2);
        filial1.setLibrary(library);
        filial2.setLibrary(library);

//----------------------------------------------
//        Faculty faculty1 = new Faculty();
//        Faculty faculty2 = new Faculty();
//        faculty1.setTitle("Факультет 1");
//        faculty2.setTitle("Факультет 2");
//
//
//
//
//
////----------------------------------------------
//
        Author author1 = new Author();
        Author author2 = new Author();
        author1.setName("John");
        author2.setName("Bob");
//
//
//
//
////----------------------------------------------
//
//
        Publisher publisher1 = new Publisher();
        publisher1.setName("Издательсвтво 1");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Издательсвтво 2");

        Book book1 = new Book();
        book1.setPageCount(500);
        book1.setAuthor(author1);
        book1.setCost(1000.00);
        book1.setPublisher(publisher1);
        book1.setTitle("Книга 1");
        book1.setIllustrationCount(5);
        book1.getFilials().add(filial1);
////        book1.setFaculty(faculty1);
//
//
        Book book2 = new Book();
        book2.setPageCount(700);
        book2.setAuthor(author1);
        book2.setCost(800.00);
        book2.setPublisher(publisher1);
        book2.setTitle("Книга 2");
        book2.setIllustrationCount(8);
        book2.getFilials().add(filial2);
////        book1.setFaculty(faculty1);
//
//
        Book book3 = new Book();
        book3.setPageCount(400);
        book3.setAuthor(author2);
        book3.setCost(6000.00);
        book3.setPublisher(publisher2);
        book3.setTitle("Книга 3");
        book3.setIllustrationCount(27);
        book3.getFilials().add(filial2);
////        book1.setFaculty(faculty2);
//
//




        filial1.getBooks().add(book1);
        filial2.getBooks().add(book2);
        filial2.getBooks().add(book3);



        Student student1 = new Student();
        student1.setName("Студент 1");
        student1.getBooks().add(book1);
        student1.getBooks().add(book3);

        Student student2 = new Student();
        student2.setName("Студент 2");
        student2.getBooks().add(book2);


//
//
//
//
////----------------------------------------
//

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book3);


        publisher1.getBooks().add(book1);
        publisher1.getBooks().add(book2);
        publisher2.getBooks().add(book3);

        Faculty faculty1 = new Faculty();
        Faculty faculty2 = new Faculty();
        Faculty faculty3 = new Faculty();
        Faculty faculty4 = new Faculty();



        faculty1.getBooks().add(book1);

        faculty2.getBooks().add(book1);
        faculty2.getBooks().add(book2);

        faculty3.getBooks().add(book1);
        faculty3.getBooks().add(book2);
        faculty3.getBooks().add(book3);

        faculty4.getBooks().add(book1);
        faculty4.getBooks().add(book3);


        book1.getFaculties().add(faculty1);
        book1.getFaculties().add(faculty2);
        book1.getFaculties().add(faculty3);
        book1.getFaculties().add(faculty4);

        book2.getFaculties().add(faculty2);
        book2.getFaculties().add(faculty3);

        book3.getFaculties().add(faculty3);
        book3.getFaculties().add(faculty4);





//        libraryRepository.add(library);
//        filialRepository.add(filial1);
//        filialRepository.add(filial2);
//        bookRepository.add(book1);
//        bookRepository.add(book2);
//        bookRepository.add(book3);





        entityManager.getTransaction().begin();



        entityManager.persist(library);
        entityManager.persist(filial1);
        entityManager.persist(filial2);

        entityManager.persist(author1);
        entityManager.persist(author2);

        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);

        entityManager.persist(publisher1);
        entityManager.persist(publisher2);

        entityManager.persist(student1);
        entityManager.persist(student2);

        entityManager.persist(faculty1);
        entityManager.persist(faculty2);
        entityManager.persist(faculty3);
        entityManager.persist(faculty4);






        entityManager.getTransaction().commit();


        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");


        for (Book book : bookRepository.getAll()) {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getPageCount());
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");


        for (Filial filial : filialRepository.getAll()) {
            System.out.println(filial.getLibrary().getName() + " " + filial.getName() + " " + filial.getBooks());
        }





        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");



        Specification<Book> multiSpec = new TwoSpecification<Book>(new BooksByFilial("Филиал 1"), new BookByTitle("Книга 1"));

        List<Book> bookList = bookRepository.getBySpecification(multiSpec);

        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }




        entityManager.close();
        entityManagerFactory.close();





    }


}
