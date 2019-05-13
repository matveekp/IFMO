package multithreading.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public static void main(String[] args) throws InterruptedException {

        List<Visitor> visitorList = new ArrayList<>();
        List<CashDesk> cashDeskList = new ArrayList<>();

        //Создаем посетителей
        for (int i = 1; i <= 25; i++) {
            visitorList.add(new Visitor("visitor" + i, i));
        }

        //Создаем кассы
        for (int i = 1; i <= 2; i++) {
            cashDeskList.add(new CashDesk(i));
        }

        //Запускаем потоки касс
        for (CashDesk cashDesk : cashDeskList) {
            new Thread(cashDesk).start();
        }

        //Отправляем посетителей на кассы
        for (Visitor visitor : visitorList) {
            getCashDeskWithMinQueue(cashDeskList).addVisitor(visitor);
            Thread.sleep(1000);
        }

        //Отправляем посетителей на кассы
        for (Visitor visitor : visitorList) {
            getCashDeskWithMinQueue(cashDeskList).addVisitor(visitor);
        }

    }


    public static CashDesk getCashDeskWithMinQueue(List<CashDesk> list) {

        CashDesk сashDeskWithMinQueue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getSize() < сashDeskWithMinQueue.getSize())
                сashDeskWithMinQueue = list.get(i);
        }

        return сashDeskWithMinQueue;

    }





    }


