package lesson1;

public class Task1 {

//    Задача 1:
//    Задайте высоту, длину и ширину прямоугольного параллелепипеда и найти его площадь.
//    Узнайте, что больше: ширина или высота и выведите информацию об этом в консоль.

    public static void main(String[] args) {
        

        int height = 3;
        int length = 5;
        int width = 2;


        System.out.println(getArea(height,length,width));

    }


   public static int getArea(int height, int length, int width) {

        return 2*( height*width + width*length + height*length );

    }

}
