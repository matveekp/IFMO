package streamApi;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class WarStream {
    public static void main(String[] args) throws IOException {
        File file = new File("wp.txt");

//        Map<String, Integer> map =
//                // получаем строки из файла
//                Files.lines(file.toPath())
//                // указываем что стрим д.б. параллельным
//                .parallel()
//                .map(line -> line.toLowerCase().replaceAll("\\pP", " "))
//                .flatMap(line -> Arrays.stream(line.split(" ")))
//                .map(String::trim)
//                .filter(word -> !"".equals(word))
//                .collect(groupingBy(Function.identity(), counting()))
//                .entrySet()
//                .parallelStream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .limit(10)
//                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
