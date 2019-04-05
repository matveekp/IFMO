package lesson10;


import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Homework10 {

    public static void main(String[] args) throws IOException {


        ClassLoader loader = Homework10.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());

        // Читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> words = new ArrayList<>();




        for (String line: lines){
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");

        for (String s: wordSplit){
            if (s.length() > 0) {
                words.add(s.trim());
            }
        }
        }

        // -----------Task 1 ------------------
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < words.size(); i++) {
            if (map.containsKey(words.get(i)))
                map.put(words.get(i), map.get(words.get(i))+1);
            else map.put(words.get(i), 1);
        }


        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " : " + stringIntegerEntry.getValue());
        }

        // -----------Task 2 ------------------
        System.out.println("-------------------------------");




        // -----------Task 3 ------------------ 3. Вывести топ 10 самых частых слов и фраз.
        System.out.println("-------------------------------");

        Map<String, Integer> map3 = new HashMap<>(map);


        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };


       // Collections.sort(map3, new valueComparator);
        //List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<Map.Entry<String, String>>();





        // -----------Task 4 ------------------
        System.out.println("-------------------------------");




        // -----------Task 5 ------------------
        System.out.println("-------------------------------");








    }
}
