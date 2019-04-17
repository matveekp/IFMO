package multithreading.synchronize;

public class Library {
    public static void main(String[] args) {

        BookStorage bookStorage = new BookStorage();
        new Thread(new PutThread(bookStorage)).start();
        new Thread(new GetTHread(bookStorage)).start();



    }
}

class BookStorage {

    int booksCount = 0;


    public synchronized void getBook() throws InterruptedException {

        System.out.println("getBook - начало выполнения");
            while (booksCount<1) {
                wait();
                System.out.println("getBook в ожидании...");
            }
            booksCount--;
        System.out.println("1 забрали, осталось: " + booksCount);
        System.out.println("getBook - окончание выполнения");
        notify();
    }

    public synchronized void putBook() throws InterruptedException {
        System.out.println("putBook - начало выполнения работ");
            while (booksCount>=5) {
                wait();
                System.out.println("putBook в ожидании");
            }

            booksCount++;

        System.out.println("1 добавили, в хранилище: " + booksCount);

        System.out.println("putBook - окончание выполнения");
    }



}

class PutThread implements Runnable {

    BookStorage storage;

    public PutThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetTHread implements Runnable {
    BookStorage storage;

    public GetTHread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
