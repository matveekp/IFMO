package lesson11;

import java.io.*;
import java.util.Vector;

public class Task2 {

    public static void main(String[] args) {

        try {
            //splitFiles(); не готово
            glueFiles();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void splitFiles() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите на сколько частей нужно разбить файл");
        int count = Integer.parseInt(reader.readLine());

        System.out.println("Введите имя исходного файла");
        String sourceFileName = reader.readLine();

        String[] outputNames = new String[count];


        for (int i = 0; i < outputNames.length; i++) {
            System.out.println("Введите имя файла " + i);
            outputNames[i] = reader.readLine();
        }


        try (FileInputStream fileInputStream = new FileInputStream(sourceFileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

             // FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
             //  BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            while (bufferedInputStream.available() > 0) {


               // int data = fileInputStream.read();
                // fileOutputStream.write(data);


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




