package multithreading.concur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentExample {

    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();

        list.add("qwe");
        list.add("asd");
        list.add("zxc");
        list.add("rty");

        ((CopyOnWriteArrayList<String>) list).addIfAbsent("rty");

        new WriteThreadd(list).start();
        new ReadThread(list).start();


    }

}

class WriteThreadd extends Thread {

    private List<String> list;
    private ArrayList<String> data = new ArrayList<>();


    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (count == data.size() - 1) count = 0;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(data.get(count));
            count++;
            System.out.println("WriteThread added " + data.get(count));

        }

    }

    public WriteThreadd(List<String> list) {
        this.list = list;

        data.add("qwer");
        data.add("asdf");
        data.add("zxcv");
        data.add("rtyu");
        data.add("fghj");


    }
}


class ReadThread extends Thread {

    private List<String> list;

    public ReadThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            String res = "ReadThread res: ";
//            Iterator<String> iterator = list.iterator();
//            while (iterator.hasNext()) {
//                String next = iterator.next();
//                res += next + " ";
//
//
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }

            for (String str : list) {

                if (list.contains("asd")) {
                    list.remove("asd");
                }


                res += str + " ";
            }

            try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            System.out.println(res);
        }
    }
}