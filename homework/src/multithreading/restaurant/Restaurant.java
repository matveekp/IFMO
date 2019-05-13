package multithreading.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant {

    private static List<Visitor> visitorList = new ArrayList<>();
    private static List<CashDesk> cashDeskList = new ArrayList<>();



    public static void main(String[] args)  {

        //Создаем посетителей
        for (int i = 1; i <= 15; i++) {
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

        // Кассы начинают работу
        for (CashDesk cashDesk : cashDeskList) {
            new Thread(cashDesk).start();
        }

    }


    public static CashDesk getRandomCashDesk(List<CashDesk> list) {
        return list.get(new Random().nextInt(list.size()));
    }


    public static void sortQueues() {

        if (cashDeskList.size() >= 2) {
            for (int i = 0; i < cashDeskList.size() - 1; i++) {
                if (cashDeskList.get(i).getSize() + 1 < cashDeskList.get(i + 1).getSize()) {
                    cashDeskList.get(i).addVisitor(cashDeskList.get(i + 1).removeVisitor());
//                    System.out.println("Посетитель с id " + cashDeskList.get(i + 1).getId() + " перешел из очереди " + cashDeskList.get(i).getId() + " в очередь " + cashDeskList.get(i + 1).getId());
                }

                else if (cashDeskList.get(i).getSize()  > cashDeskList.get(i + 1).getSize() +1) {
                    cashDeskList.get(i + 1).addVisitor(cashDeskList.get(i).removeVisitor());
//                    System.out.println("Посетитель с id " + cashDeskList.get(i).getId() + " перешел из очереди " + cashDeskList.get(i + 1).getId() + " в очередь " + cashDeskList.get(i).getId());
                }
            }
        } else return;

    }
}


