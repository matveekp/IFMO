package lesson11;

import java.io.*;

public class Task1 {



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String outputFileName = reader.readLine();

        long sum=0;

        try (FileInputStream fileInputStream = new FileInputStream(sourceFileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ){
            while (bufferedInputStream.available() > 0) {

                int data = fileInputStream.read();
                bufferedOutputStream.write(data);
                sum +=data;

            }
        }

        System.out.println(sum);

    }
}
