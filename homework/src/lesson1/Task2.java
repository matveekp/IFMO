package lesson1;

public class Task2 {

    public static void main(String[] args) {

//        Задача 2:
//        На садовом участке площадью 10 соток , разбили грядки 15 на 25 метров. Сколько м2 осталось незанято?

        int height = 15;
        int width = 25;
        int allArea = 10 *100 ;

        System.out.println("Площадь участка: " + allArea + " м2.");
        System.out.println("Площадь грядок: " + height*width + " м2." );
        System.out.println();
        System.out.println("Осталось незанято " + getFreeArea(height, width, allArea)+ " м2.");



        
    }

    public static int getFreeArea(int height, int width, int allArea) {

        return allArea - (height*width);

    }
    }


