package lesson11;

import java.io.*;

public class Task3 {

    public static void main(String[] args) {

        try {
            encryptByPass("D:\\java_test\\wp.txt", "D:\\java_test\\encryptedWP.txt", "Qq12345678");
            encryptByPass("D:\\java_test\\encryptedWP.txt", "D:\\java_test\\decryptedWP.txt", "Qq12345678");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void encryptByPass(String inputFileName, String outputFileName, String pass) throws IOException {


        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFileName));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));

               // BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)

        ) {
            byte[] buffer = new byte[1024];

            while (bufferedInputStream.available() > 0) {
                int count = bufferedInputStream.read(buffer);
                byteArrayOutputStream.write(buffer, 0 , count);
            }

            byte[] passBytes = pass.getBytes();
            byte[] file = byteArrayOutputStream.toByteArray();

            for (int i = 0; i < file.length; i++) {
                file[i] = (byte) (file[i]^passBytes[i%passBytes.length]);
            }

            bufferedOutputStream.write(file);



        }

    }
}
