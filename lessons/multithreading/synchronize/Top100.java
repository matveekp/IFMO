package multithreading.synchronize;

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

        List<String> words1 = new ArrayList<>(words.subList(0, words.size() / 4));
        List<String> words2 = new ArrayList<>(words.subList(words.size() / 4, words.size() / 2));
        List<String> words3 = new ArrayList<>(words.subList(words.size() / 2, words.size() - words.size() / 4));
        List<String> words4 = new ArrayList<>(words.subList(words.size() - words.size() / 4, words.size()));


//        Map<String, Integer> myMap = new TreeMap<>();
//
//        for (int i = 0; i < words.size(); i++) {
//            if (myMap.containsKey(words.get(i)))
//                myMap.put(words.get(i), myMap.get(words.get(i)) + 1);
//            else myMap.put(words.get(i), 1);
//        }


//        for (int i = 0; i < 100; i++) {
//            //System.out.println(set.pollLast());
//
//            //System.out.println(set);
//        }


        new Thread(new MyThread(words1, map)).start();
        new Thread(new MyThread(words2, map)).start();
        new Thread(new MyThread(words3, map)).start();
        new Thread(new MyThread(words4, map)).start();


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}

class MyThread implements Runnable {
    Map<String, Integer> map;
    List<String> list;

    public MyThread(List<String> list, Map<String, Integer> map) {
        this.list = list;
        this.map = map;
    }

    @Override
    public void run() {

        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i)))
                map.put(list.get(i), map.get(list.get(i)) + 1);
            else map.put(list.get(i), 1);
        }
    }
}

