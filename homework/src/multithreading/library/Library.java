package multithreading.library;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Library {

    private ConcurrentHashMap<Integer, Book> books;

    public Library() {
        books = new ConcurrentHashMap<>();
    }


    public ConcurrentHashMap<Integer, Book> getBooks() {
        return books;
    }

    public ConcurrentHashMap<Integer, Book> takeBook(Book book) {
        books.remove(book.getId(), book);
        return books;
    }

    public void addBook(Book book) {
        books.putIfAbsent(book.getId(), book);

    }

    public void printAllBooks(){
        System.out.println();
        for (Map.Entry<Integer, Book> integerBookEntry : books.entrySet()) {
            System.out.println(integerBookEntry.getKey() + " : " + integerBookEntry.getValue().getTitle() + " - " + integerBookEntry.getValue().getAuthor());
        }
        System.out.println();
    }

}
