package multithreading.library;

public class Main {

    public static void main(String[] args) {


        Book book1 = new Book("Шерлок Холмс", "Конан Дойль", 1, true);
        Book book2 = new Book("Властелин Колец", "Джон Толкин", 2, false);
        Book book3 = new Book("Три мушкетера", "Александр Дюма", 3, true);
        Book book4 = new Book("Война и мир", "Лев Толстой", 4, false);


        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);


        new Thread(new Reader("Иван", "Иванов", library)).start();


    }
}
