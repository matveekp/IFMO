package nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NIOFiles {

    public static void main(String[] args) throws IOException {
        File file = new File("nio.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 600; i++) {
            stringBuilder.append(i).append("\n");

        }

        //writeToFile(file.toPath(), stringBuilder.toString());

        readFromFile(file.toPath());

    }

    public static void writeToFile(Path path, String string) throws IOException {

//        try (FileChannel channel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.APPEND)) {
//
//            ByteBuffer byteBuffer = ByteBuffer.allocate(string.getBytes().length);
//
//            byteBuffer.put(string.getBytes(Charset.forName("utf-8")));
//            byteBuffer.flip();
//
//            int written = channel.write(byteBuffer);
//            System.out.println("written: " + written + " bytes to file: " + path.getFileName());
//
//        }

        Files.write(path, string.getBytes(), StandardOpenOption.APPEND);


    }

    public static void readFromFile(Path path) throws IOException {
        int count=0;
        try (FileChannel channel = (FileChannel) Files.newByteChannel(path)){

            ByteBuffer byteBuffer = ByteBuffer.allocate(512);

            do {
                count = channel.read(byteBuffer);
                System.out.println("Прочитано: " + count);
                if ( count!= -1) {

                    byteBuffer.rewind();
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        builder.append(new String(byteBuffer.array(), 0, byteBuffer.remaining()));
                    }
                    System.out.println(builder.toString());
                }


            } while (count != -1);
        }

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String line : lines) {
            System.out.println(line);
        }

        Files.lines(path, StandardCharsets.UTF_8).forEach(System.out::println);



    }

}
