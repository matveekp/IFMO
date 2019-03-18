package lesson4.Task2;

//Задание 2
//
//        Создать фигуры: Circle, Rectangle, Triangle, у которых будут координаты.
//        Все фигуры должны иметь методы, которые возвращают площадь и периметр (для окружности - длина окружности).

public abstract class Figure {

    private int x;
    private int y;


    public abstract double getArea();
    public abstract double getPerimeter();


}
