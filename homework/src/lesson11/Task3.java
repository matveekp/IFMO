package lesson11;

import java.io.*;

public class Task3 {

    public static void main(String[] args) {

        try {
            encryptByPass(); // не готово


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void encryptByPass() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите исходный файлов");
        String inputFileName = reader.readLine();

        System.out.println("Введите имя зашифрованного файла файла");
        String outputFileName = reader.readLine();

        System.out.println("Введите ключ шифрования");
        String pass = reader.readLine();

        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFileName));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));

               // BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)

        ) {

            byte[] buffer = new byte[1024];

            while (bufferedInputStream.available() > 0) {

                int count = bufferedInputStream.read(buffer);




            }
        }

    }
}
