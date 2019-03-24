package lesson7.Pupil;

public class Test {

    public static void main(String[] args) {

//        Использование программы:
//    Pupil pupil = new Pupil(1324);
//    String ex[] = {"Математика","Биология"};
//    int marks[] = { 2, 5 };
//pupil.setExams(ex, marks);
//System.out.println(pupil);
//    Вывод:
//    Студент: 1324
//    Математика не сдал
//    Биология сдал

        Pupil pupil = new Pupil(123);
        String[] ex = {"Математика","Биология"};
        int[] marks = { 1, 5 };

        pupil.setExams(ex, marks);
        System.out.println(pupil);


    }
}
