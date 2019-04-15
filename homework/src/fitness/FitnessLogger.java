package fitness;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FitnessLogger {

    public static void printToFile(Human human, FitnessServiceEnumeration type) {

        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");



       File file = new File("clients");

        stringBuilder.append(human.getSurname() + " " + human.getName() + " " + type + " " + LocalDate.now() +
                " " + formatter.format(LocalTime.now()) + "\n");
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file)) ;
        ) {
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
