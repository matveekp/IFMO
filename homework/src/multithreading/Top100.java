package multithreading;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Top100 {


    public static Map<String, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {

        ClassLoader loader = Top100.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());

        // Читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");


            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }

        List<String> words1 = new ArrayList<>(words.subList(0, words.size() / 4 +1));
        List<String> words2 = new ArrayList<>(words.subList(words.size() / 4, words.size() / 2 + 1));
        List<String> words3 = new ArrayList<>(words.subList(words.size() / 2, words.size() - words.size() / 4 + 1) );
        List<String> words4 = new ArrayList<>(words.subList(words.size() - words.size() / 4, words.size()));


        Thread thread1 = new Thread(new MyThread(words1));
        Thread thread2 = new Thread(new MyThread(words1));
        Thread thread3 = new Thread(new MyThread(words1));
        Thread thread4 = new Thread(new MyThread(words1));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TreeSet<Map.Entry<String, Integer>> mySet = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        mySet.addAll(map.entrySet());

        for (int i = 0; i < 10; i++) {
            System.out.println(mySet.pollLast());
        }

    }

}

class MyThread implements Runnable {
    List<String> list;

    public MyThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (Top100.map) {

            for (int i = 0; i < list.size(); i++) {
                if (Top100.map.containsKey(list.get(i)))
                    Top100.map.put(list.get(i), Top100.map.get(list.get(i)) + 1);
                else Top100.map.put(list.get(i), 1);
            }
        }
    }
}

