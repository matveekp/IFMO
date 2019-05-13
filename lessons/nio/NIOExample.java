package nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOExample {
    public static void main(String[] args) {
//        Path path = Paths.get("/catalog1/catalog2/file.txt");
//        Path path1 = Paths.get("/catalog1/catalog2/");
//
//        System.out.println(path.getNameCount());
//        System.out.println(path.getName(2));

//        path.normalize();
//
//        Files.createFile();
//        Files.createDirectory();
//        Files.createTempFile();
//        Files.createTempDirectory();
//
//        Files.copy();
//        Files.delete();
//        Files.move();
//        Files.deleteIfExists();
//
//
//        Files.write();


//
//
//        Files.readAllLines(); //list
//        Files.lines(); //stream
//        Files.readAllBytes(); //array of bytes


        ByteBuffer buffer = ByteBuffer.allocate(16); // создаем буфре заданного размера. Размер неизменяемый

        assert buffer.position() == 0; //для созданног буфера изначаольно позиция на 0

        assert buffer.capacity() == 16; // для созданного буфера всегда одинаково

        assert buffer.limit() == 16; //для только что созданного лимит = размеру. И всегда не больше размера

        assert buffer.remaining() == 16; //разница между текущей позицией и лимтом
//has remaining


        buffer.putInt(100);
        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        buffer.putDouble(100.25);
        System.out.println(buffer.position());

        // лимит на текущую позицию
        // позицию на 0
        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;

        int someInt = buffer.getInt();
        System.out.println(someInt);
        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        double someDouble = buffer.getDouble();
        System.out.println(someDouble);
        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        buffer.rewind(); // подготавливает буфер для повторного чтения


        buffer.clear();


        buffer.compact(); // как сказал препод - "в принципе" подготавливает для записи


        //FileChannel; // создает каанал между программой и файлом
        //DatagramChannel;; // канал для передачи данных по udp протоколу
        //SocketChannel; // канал для передачи данных по tcp протоколу
        //ServerSocketChannel // позволяет слушать входящие tcp соединения.
                                // для каждого соединения воссоздает SocketChannel



//        FileChannel;
//        ИЗ СТРИМОВ получаем
//        fileOutputStream.getChannel;
//        fileInputStream.getChannel
//                randomAccessFile.getChannel;


//
//
//Connect;
//        SelectionKey.OP_



    }

}
