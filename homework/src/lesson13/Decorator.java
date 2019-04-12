package lesson13;

import java.io.*;

public class Decorator {
    public static void main(String[] args) {

        // MyInputStream myInputStream = new MyInputStream(new InputStreamReader(System.in));

    }
}

class MyInputStream extends FilterInputStream {

    //    public final static int XOR_KEY = 1;
    private byte[] key;
    private int currentKeyPosition;

    public MyInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {

        int data = super.read(b);
//дешифровка
        return data;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int data = super.read(b, off, len);

        //дешифровка
        return data;

    }
}

class MyOutputStream extends FilterOutputStream {

//    public final static int XOR_KEY = 1;

    private byte[] key;
    private int currentKeyPosition;

    public MyOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(byte[] b) throws IOException {


//        for (int i = 0; i < b.length; i++) {
//            b[i] = (byte) (b[i] ^ XOR_KEY);
//        }

        super.write(b);
    }


    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }
}





