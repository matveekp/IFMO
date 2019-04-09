package lesson11;

import java.io.*;

public class Task3a {

    public static void main(String[] args) {

        try {
            encryptByPass("D:\\java_test\\wp.txt", "D:\\java_test\\encryptedWP3a.txt", "D:\\java_test\\cryptoFile.txt");
            encryptByPass("D:\\java_test\\encryptedWP3a.txt", "D:\\java_test\\decryptedWP3a.txt", "D:\\java_test\\cryptoFile.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void encryptByPass(String inputFileName, String outputFileName, String cryptoFileName) throws IOException {


        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFileName));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                BufferedInputStream bufferedCryptoStream = new BufferedInputStream(new FileInputStream(cryptoFileName));
                ByteArrayOutputStream byteArrayCryptoStream = new ByteArrayOutputStream();

                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));
        ) {
            byte[] buffer = new byte[1024];

            while (bufferedInputStream.available() > 0) {
                int count = bufferedInputStream.read(buffer);
                byteArrayOutputStream.write(buffer, 0 , count);
            }

            while (bufferedCryptoStream.available() > 0) {
                int count = bufferedCryptoStream.read(buffer);
                byteArrayCryptoStream.write(buffer, 0 , count);
            }


            byte[] file = byteArrayOutputStream.toByteArray();
            byte[] cryptoFile = byteArrayCryptoStream.toByteArray();

            for (int i = 0; i < file.length; i++) {
                file[i] = (byte) (file[i]^cryptoFile[i%cryptoFile.length]);
            }

            bufferedOutputStream.write(file);



        }

    }
}
