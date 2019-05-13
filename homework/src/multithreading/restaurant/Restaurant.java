package multithreading.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant {

    public static void main(String[] args) throws InterruptedException {

        List<Visitor> visitorList = new ArrayList<>();
        List<CashDesk> cashDeskList = new ArrayList<>();

        //Создаем посетителей
        for (int i = 1; i <= 250; i++) {
            visitorList.add(new Visitor("visitor" + i, i));
        }

        //Создаем кассы
        for (int i = 1; i <= 3; i++) {
            cashDeskList.add(new CashDesk(i));
        }




        //Отправляем посетителей на кассы
        for (Visitor visitor : visitorList) {
            getRandomCashDesk(cashDeskList).addVisitor(visitor);
        }

        //Запускаем потоки касс
        for (CashDesk cashDesk : cashDeskList) {
            new Thread(cashDesk).start();
        }


        Thread.sleep(3000);

        for (CashDesk cashDesk : cashDeskList) {
            sortQueues(cashDeskList);
        }

        Thread.sleep(3000);

        for (CashDesk cashDesk : cashDeskList) {
            sortQueues(cashDeskList);
        }

    }


    public static CashDesk getRandomCashDesk(List<CashDesk> list) {
        return list.get(new Random().nextInt(list.size()));
    }


    public static void sortQueues(List<CashDesk> list) {

        if (list.size() >= 2) {

            for (int i = 0; i < list.size()-1; i++) {

                if (list.get(i).getSize()+1 < list.get(i + 1).getSize()) {
                    list.get(i).addVisitor(list.get(i + 1).removeVisitor());
                    System.out.println("Посетитель с id " + list.get(i+1).getId() + " перешел из очереди " + list.get(i).getId() + " в очередь " + list.get(i+1).getId());
                }

                if (list.get(i).getSize()+1 > list.get(i + 1).getSize()) {
                    list.get(i+1).addVisitor(list.get(i).removeVisitor());
                    System.out.println("Посетитель с id " + list.get(i).getId() + " перешел из очереди " + list.get(i+1).getId() + " в очередь " + list.get(i).getId());
                }



            }

        } else return;

    }






    }


