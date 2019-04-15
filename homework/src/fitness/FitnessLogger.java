package fitness;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FitnessLogger {

    public static void printToFile(Human human, FitnessServiceEnumeration type, String message) {

        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        File file = new File("clients");

        stringBuilder.append(human.getSurname() + " " + human.getName() + " " + type + " " + message + " " + LocalDate.now() +
                " " + formatter.format(LocalTime.now()) + "\n");


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        ) {
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
