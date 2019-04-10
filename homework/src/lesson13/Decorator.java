package lesson13;

import java.io.*;

public class Decorator {
        public static void main(String[] args) {

           // MyInputStream myInputStream = new MyInputStream(new InputStreamReader(System.in));

    }
}

class MyInputStream extends FilterInputStream {

    public final static int XOR_KEY = 1;

    public MyInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {

        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ XOR_KEY);
        }

        return super.read(b);
    }
}

class MyOutputStream extends FilterOutputStream {

    public final static int XOR_KEY = 1;

    public MyOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {


        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ XOR_KEY);
        }

        super.write(b);
    }
}





