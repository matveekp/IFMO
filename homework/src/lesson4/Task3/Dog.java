package lesson4.Task3;

//Создать класс Dog с пятью конструкторами:
////        - Имя
////        - Имя, вес, возраст
////        - Имя, возаст
////        - Вес, цвет
////        - вес, цвет, адрес (домашний пес)
////        Задача конструктора – сделать объект валидным.
////        Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Какие свойства необходимо задать по умолчанию, а какие нет, определить самостоятельно.

public class Dog {

    String name = "Собака-улыбака";
    int age = 1;
    int weight = 3;
    String color;
    String address;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Dog(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Dog(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
    }


}
