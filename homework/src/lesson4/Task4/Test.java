package lesson4.Task4;

public class Test {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Cat1", 5, 5, 10);
        Cat cat2 = new Cat("Cat2", 3, 4, 14);

        Cat cat3 = new Cat("cat3", 5, 5, 10);

        System.out.println(cat2.fight(cat1));
        System.out.println(cat3.fight(cat1));





    }
}
