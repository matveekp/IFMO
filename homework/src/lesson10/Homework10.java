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
        // Сосчитать частоту встречаемости слов в War and peace (файл wp.txt).
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
        // Собрать все слова в группы по количеству букв: например, в одну группу попадут слова: [the, war, jar, get, met...], в другую [on, up, no, of...].
        System.out.println("-------------------------------");

       // Map<Integer, List<String>> map2 = new HashMap<>();
        Map<Integer, HashSet<String>> map2 = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            if (!map2.containsKey(length)) {
                map2.put(length, new HashSet<>());
            }
            map2.get(length).add(word);
        }
        for (Map.Entry<Integer, HashSet<String>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        // -----------Task 3 ------------------
        // Вывести топ 10 самых частых слов и фраз.
        System.out.println("-------------------------------");

        Map<String, Integer> map3 = new HashMap<>(map);


        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };


        TreeSet<Map.Entry<String, Integer>> set3 = new TreeSet<>(valueComparator);
                set3.addAll(map3.entrySet());

        for (int i = 0; i < 10 ; i++) {
            System.out.println(set3.pollLast());
        }






        // -----------Task 4 ------------------
        // Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...).
        System.out.println("-------------------------------");

        Map<Integer, HashSet<String>> map4 = new HashMap<>();

        List<String> articles = new ArrayList<>();
        articles.add("the");
        articles.add("a");
        articles.add("on");
        articles.add("to");
        articles.add("at");

        List<String> words4 = new ArrayList<>(words);
        words4.removeAll(articles);


        for (String word : words4) {
            int length = word.length();
            if (!map4.containsKey(length)) {
                map4.put(length, new HashSet<>());
            }
            map4.get(length).add(word);
        }
        for (Map.Entry<Integer, HashSet<String>> entry : map4.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        // -----------Task 5 ------------------
        // Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы.
        System.out.println("-------------------------------");

        ArrayList<Character> chars = new ArrayList<>();

        for (String word : words) {

            char[] chars1 = word.replaceAll("\\d", "").toCharArray();
            for (char c : chars1) {
                chars.add(c);
            }
        }

        Map<Character, Double> map5 = new TreeMap<>();

        for (int i = 0; i < chars.size(); i++) {
            if (map5.containsKey(chars.get(i)))
                map5.put(chars.get(i), map5.get(chars.get(i))+1);
            else map5.put(chars.get(i), 1.0);
        }


        for (Map.Entry<Character, Double> entry : map5.entrySet()) {
           Double count =  Math.rint(100.0 * ((entry.getValue() * 100) / chars.size())) / 100.0;
           System.out.println(entry.getKey() + " : " + count + "%");
        }









    }
}
