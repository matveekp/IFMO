package lesson2;

public class Task7 {

//    Задача 7*
//    Электронные часы показывают время в формате от 00:00 до 23:59.
//    Подсчитать сколько раз за сутки случается так, что слева от двоеточия показывается
//    симметричная комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).

    public static void main(String[] args) {

        int count = 0;

        for (int x = 00; x < 24; x++) {

            for (int y = 00; y < 60 ; y++) {

                int x1 = x % 10;
                int x2 = x / 10 % 10;

                int y1 = y % 10;
                int y2 = y / 10 % 10;


                if (x1==y2 && x2 == y1) {

                    //System.out.println(x + ":" + y);

                    System.out.println(String.format("%02d:%02d", x, y));

                    count++;
                }

            }

        }

        System.out.println("------------------");
        System.out.println(count);

    }
}
