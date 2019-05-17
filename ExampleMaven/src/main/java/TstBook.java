import entity.Book;
import repository.BookRepository;
import specification.BookByTitle;
import specification.Specification;
import specification.TwoSpecification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        Book bookById = bookRepository.getByPk(2);

        System.out.println(bookById.getTitle());

        bookById.setTitle("Новое название книги");
        bookRepository.update(bookById);

        System.out.println(bookById.getTitle());

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

        Specification<Book> multiSpec = new TwoSpecification<Book>(new BookByTitle("Книга 3"), new BookByTitle("Книга 3"));

        List<Book> bookList = bookRepository.getBySpecification(multiSpec);

        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }

        entityManager.close();
        factory.close();


    }


}
