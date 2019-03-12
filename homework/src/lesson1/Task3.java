package lesson1;

public class Task3 {

    public static void main(String[] args) {

//        Задача 3:
//        Найдите площадь овального кольца, полученного из овала площадью 15 дм2 вырезанием овала площадью 600 см2.



        int squareBigOval = 15;
        int squareCutOval = 600/100; //перевели в дм2


        System.out.println("Площадь овального кольца = " + (squareBigOval-squareCutOval) + " дм2.");



        

    }

}
