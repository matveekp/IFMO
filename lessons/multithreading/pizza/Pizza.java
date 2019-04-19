package multithreading.pizza;


//Пиццерия
// 3 потока - клиент, официант, повар
// 3 очереди - новые зказаы, заказы для кухни , готовые
// клиент делает заказ и доабвляет в очередь 1,
// официант берет заказ из очереди 1 и добавляет в очередь 2
// повар забирает заказ из очерди 2 и добавляет в очередь 3
// клиент забирает заказ из очереди 3

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.concurrent.ArrayBlockingQueue;

public class Pizza {
    public static void main(String[] args) {

        ArrayBlockingQueue<Order> newOrders = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Order> forCook = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Order> done = new ArrayBlockingQueue<>(3, true);

        Waiter waiter1 = new Waiter(newOrders, forCook);
        Waiter waiter2 = new Waiter(newOrders, forCook);
        Waiter waiter3 = new Waiter(newOrders, forCook);


        waiter1.start();
        waiter2.start();
        waiter3.start();

        Order meat = new Order("meat");
        Order cheese = new Order("cheese");
        Order veg = new Order("veg");
        Order tomato = new Order("tomato");
        Order coffee = new Order("coffee");


        Client client1 = new Client(newOrders, done);
        Client client2 = new Client(newOrders, done);
        Client client3 = new Client(newOrders, done);

        client1.makeOrder(meat);
        client2.makeOrder(cheese);



        client1.start();
        client2.start();
        client3.start();

        client3.makeOrder(veg);

        client1.makeOrder(tomato);
        client2.makeOrder(coffee);


        Cook cook1 = new Cook(forCook, done);
        cook1.start();


    }

}


class Order {
    String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Client extends Thread {
    private ArrayBlockingQueue<Order> newOrders;
    private ArrayBlockingQueue<Order> done;

    public Client(ArrayBlockingQueue<Order> newOrders, ArrayBlockingQueue<Order> done) {
        this.newOrders = newOrders;
        this.done = done;
    }

    public void makeOrder(Order order) {
        try {
            newOrders.put(order);
            System.out.println("Клиент сделал заказ: " + order.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                done.take();
                System.out.println("Клиент получил готовый заказ: " + done.take().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Waiter extends Thread {

    private ArrayBlockingQueue<Order> newOrders;
    private ArrayBlockingQueue<Order> forCook;

    public Waiter(ArrayBlockingQueue<Order> newOrders, ArrayBlockingQueue<Order> forCook) {
        this.newOrders = newOrders;
        this.forCook = forCook;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = newOrders.take();
                System.out.println("Официант взял нвоый заказ: " + order.getName());
                forCook.put(order);
                System.out.println("Официант передал новый заказ на кухню: " + order.getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Cook extends  Thread{
    private ArrayBlockingQueue<Order> forCook;
    private ArrayBlockingQueue<Order> done;

    public Cook (ArrayBlockingQueue<Order> forCook, ArrayBlockingQueue<Order> done) {
        this.forCook = forCook;
        this.done = done;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = forCook.take();

                System.out.println("Повар готовит заказ: " + order.getName());
                Thread.sleep(2000);
                done.put(order);
                System.out.println("Заказ готов: " + order.getName());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}