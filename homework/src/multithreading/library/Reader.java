package multithreading.library;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Reader implements Runnable {
    private String firstName;
    private String secondName;
    private Book book;
    private Library library;

    private LinkedBlockingQueue<Book> listOfTakenHomeBooks;
    private LinkedBlockingQueue<Book> listOfReadAtLibraryBooks;

    public Reader(String firstName, String secondName, Library library) {
        this.firstName = firstName;
        this.secondName = secondName;
        listOfTakenHomeBooks = new LinkedBlockingQueue<>();
        listOfReadAtLibraryBooks = new LinkedBlockingQueue<>();
        this.library = library;

    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public void run() {

        while (!library.getBooks().isEmpty()) {
            System.out.println("--------------------------");
            System.out.println("Список книг в библиотеке:");

            library.printAllBooks();
            System.out.println("Укажите id книги, которую хотите взять или exit");

            Scanner scanner = new Scanner(System.in);
            int bookChoise;
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Повторите ввод ID");
                scanner.next();
            }
            bookChoise = scanner.nextInt();

            for (Book book : library.getBooks().values()) {

                if (bookChoise == book.getId()) {

                    if (!book.isTakeHome()) {
                        System.out.println("данная книга доступна для чтения только в читальном зале");
                        library.takeBook(book);
                        listOfReadAtLibraryBooks.add(book);

                    } else {
                        System.out.println("Желаете взять книгу домой? (да/нет или yes/no)");
                        String takeHomeChoice = scanner.next();

                        if (takeHomeChoice.equalsIgnoreCase("да") || takeHomeChoice.equalsIgnoreCase("yes")) {
                            library.takeBook(book);
                            listOfTakenHomeBooks.add(book);
                        } else if (takeHomeChoice.equalsIgnoreCase("нет") || takeHomeChoice.equalsIgnoreCase("no")) {
                            library.takeBook(book);
                            listOfReadAtLibraryBooks.add(book);
                        } else {
                            System.out.println("ошибка :(");
                        }


                    }


                }

            }
            System.out.println("--------------------------");
            System.out.println("Список книг, взятых домой:");

            for (Book listOfTakenHomeBook : listOfTakenHomeBooks) {
                System.out.println(listOfTakenHomeBook);
            }

            System.out.println();
            System.out.println("--------------------------");
            System.out.println("Список книг, взятых для чтения в читальном зале:");

            for (Book listOfReadAtLibraryBook : listOfReadAtLibraryBooks) {
                System.out.println(listOfReadAtLibraryBook);
            }


        }


    }


}
