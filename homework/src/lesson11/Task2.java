package lesson11;

import java.io.*;
import java.util.Vector;

public class Task2 {

    public static void main(String[] args) {

        try {
            splitFiles();
            glueFiles();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void splitFiles() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("По сколько мегобайт нужно разбить файл");
        int count = Integer.parseInt(reader.readLine()) * 1000000;

        System.out.println("Введите имя исходного файла");
        String sourceFileName = reader.readLine();

        String outputFileName = sourceFileName;

        try (FileInputStream fileInputStream = new FileInputStream(sourceFileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);) {

            byte[] buf = new byte[count];
            int len;
            int i = 0;

            while ((len = bufferedInputStream.read(buf)) > 0) {

                try (FileOutputStream fileOutputStream = new FileOutputStream(outputFileName+i);
                     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                ) {
                   bufferedOutputStream.write(buf, 0, len);


                    }

                i++;
                }
            }
        }




    public static void glueFiles() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите количество исходных файлов");
        int count = Integer.parseInt(reader.readLine());

        System.out.println("Введите имя итогового файла");
        String outputFileName = reader.readLine();

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
                //ByteArrayOutputStream bout = new ByteArrayOutputStream()
        ) {

            Vector<InputStream> sequence = new Vector<>();

            for (int i = 0; i < count; i++) {

                System.out.println("Введите имя файла " + i);

                InputStream stream = new FileInputStream(reader.readLine());
                sequence.add(stream);
            }

            SequenceInputStream sequenceInputStream = new SequenceInputStream(sequence.elements());

            byte[] buf = new byte[1024];
            int len;
            while ((len = sequenceInputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, len);
            }
        }
    }



}




