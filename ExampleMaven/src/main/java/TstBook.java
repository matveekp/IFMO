import entity.Book;
import repository.BookRepository;
import specification.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class TstBook {

    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = factory.createEntityManager();

        BookRepository bookRepository = new BookRepository(entityManager);

//
//        for (int i = 1; i < 6; i++) {
//            Book book = new Book();
//            book.setTitle("Книга " + i);
//            book.setPageCount(new Random().nextInt(100));
//            book.setAddDate(new GregorianCalendar());
//
//            // создали объект, теперь добавляем его в бд
//            bookRepository.add(book);
//        }


        // получить книгу по id:
//        Book bookById = bookRepository.getByPk(2);
//
//        System.out.println(bookById.getTitle());
//
//        bookById.setTitle("Новое название книги");
//        bookRepository.update(bookById);
//
//        System.out.println(bookById.getTitle());

        // удаление книги из бд
//        bookRepository.delete(1);

        System.out.println(bookRepository.getAll());

        for (Book book : bookRepository.getAll()) {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getPageCount());
        }


        List<Book> booksByTitle = bookRepository.getBySpecification(new BookByTitle("Книга 3"));

        for (Book book : booksByTitle) {
            System.out.println(book.getTitle());
        }

        List<Book> booksByPageCount = bookRepository.getBySpecification(new BookByPageCount(50));

        for (Book book : booksByPageCount) {

            System.out.println(book.getTitle() + " : " + book.getPageCount());
        }

        System.out.println("-------------------------------------------------");

        List<Book> booksByDate = bookRepository.getBySpecification(new BookByDate(new GregorianCalendar(2017, 0 , 25, 14, 15)));

        for (Book book : booksByDate) {
            System.out.println(book.getTitle());
        }


        System.out.println("-------------------------------------------------");

        Specification<Book> multiSpec = new TwoSpecification<Book>(new BookByTitle("Книга 5"), new BookByPageCount(75));

        List<Book> bookList = bookRepository.getBySpecification(multiSpec);

        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }

        System.out.println("-------------------------------------------------");

        List<Book> booksOfLastYear = bookRepository.getBySpecification(new BookByLastYear());

        for (Book book : booksOfLastYear) {

            System.out.println(book.getTitle());
        }


        System.out.println("---------------------------------------");
        List<Specification> specifications = new ArrayList<Specification>();

        specifications.add(new BookByLastYear());
        specifications.add(new BookByPageCount(50));


                                                // IS NOT WORKING :

//        List<Book> booksDoubleSelect = bookRepository.getBySpecification(new BooksBySeveralSpecs(specifications));
//
//        for (Book book : booksDoubleSelect) {
//            System.out.println(book.getTitle());
//        }

        System.out.println("------------------------------");



        entityManager.close();
        factory.close();


    }


}
