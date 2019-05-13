package multithreading.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant {

    public static void main(String[] args) {

        List<Visitor> visitorList = new ArrayList<>();
        List<CashDesk> cashDeskList = new ArrayList<>();

        //Создаем посетителей
        for (int i = 1; i < 25 ; i++) {
            visitorList.add(new Visitor("visitor"+i, i));
        }

        //Создаем кассы
        for (int i = 1; i < 5 ; i++) {
            cashDeskList.add(new CashDesk(i));
        }

        //Запускаем потоки касс
        for (CashDesk cashDesk : cashDeskList) {
            new Thread(cashDesk).start();
        }

        //Отправляем посетителей на кассы
        for (Visitor visitor : visitorList) {
            getCashDesk(cashDeskList).addVisitor(visitor);
        }


    }


    public static CashDesk getCashDesk(List<CashDesk> list) {
        return list.get(new Random().nextInt(list.size()));
    }

}
