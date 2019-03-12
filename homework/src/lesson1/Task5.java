package lesson1;

public class Task5 {
    public static void main(String[] args) {
//        Задача 5:
//        В три переменные a, b и c записаны три вещественных числа. Создать программу,
//        которая будет находить и выводить на экран вещественные корни квадратного
//        уравнения ax²+bx+c=0, либо сообщать, что корней нет.

        double a = 7;
        double b = 6;
        double c = 19;

            find(a,b,c);


            
    }

    public static void find(double a, double b, double c) {
        double discriminant = (b * b) - (4 * a * c); // вычисляем дискриминант


        if (discriminant < 0)
            System.out.println("Корней нет");

        else if (discriminant == 0) {
            System.out.println("X = " + (-b/2*a));
        }

        else {
            System.out.println("X1 = " + (-b + Math.sqrt(discriminant))/2*a);
            System.out.println("X2 = " + (-b - Math.sqrt(discriminant)/2*a));

        }


    }

}
