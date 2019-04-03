package lesson9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectClass {

    public static void main(String[] args) throws IOException {

        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Cars"));
        bookArrayList.add(2, new Book( "Alphabet"));

        Set<Book> bookSet = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return 0;
            }
        });

        ClassLoader classLoader = ClassLoader.class.getClassLoader();

        File file = new File(classLoader.getResource("file.txt").getFile());


        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase().replaceAll("\\p{Punct}", "").trim().split("\\s");

            for (String s : wordSplit) {

                if (s.length() > 0)
                words.add(s.trim());
            }

        }

        for (String word : words) {
            System.out.println(word);
        }

    }
}


class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}







//}
//
//class Person {
//    String name;
//    int age;
//    int salary;
//    String company;
//
//}
// напистаь генератор объектов (в метод generate передать только количество).
//уложить в TreeSet и отсортировать

//сортировать по
//имени
//имени и зарплате
//
//
//
//
//



