package lesson7.Pupil;

import java.util.Arrays;

public class Pupil {

//    Класс Pupil описывается с атрибутами:
//    id и результат экзаменов (массив) ExamResult[].
//
//    Класс ExamResult можно описать как в отдельном файле, так и внутренним классом. Вы создаете этот класс как внутренний (не статические member inner class).
//    ExamResult содержит следующие свойства:
//    название предмета,
//            оценка,
//    статус сдал/не сдал.
//
//    Именно класс ExamResult производит проверку сдал ученик экзамен или нет.
//
//    Использование программы:
//    Pupil pupil = new Pupil(1324);
//    String ex[] = {"Математика","Биология"};
//    int marks[] = { 2, 5 };
//pupil.setExams(ex, marks);
//System.out.println(pupil);
//    Вывод:
//    Студент: 1324
//    Математика не сдал
//    Биология сдал

    private int id;
    private ExamResult[] examResults;

    public Pupil(int id) {
        this.id = id;
    }

    public void setExams(String[] exams, int[] grade) {
        if (exams.length == grade.length) {
            for (int i = 0; i < grade.length; i++) {
                if (grade[i] < 1 && grade[i] > 5) {
                    System.out.println("Оценки должны быть в диапазоне от 1 до 5");
                    return;
                }
                else {
                    examResults[i] = new ExamResult(exams[i], grade[i]);

                }
            }
        }
        else System.out.println("Количество предметов не совпадает с количеством оценок");
    }

    @Override
    public String toString() {
        return "Студент" +
                "id=" + id +
                ", examResults=" + Arrays.toString(examResults) +
                '}';
    }

    private class ExamResult {

        String object;
        int grade;
        boolean status;


        public ExamResult(String object, int grade) {
            this.status = grade > 2;
            this.object = object;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return object + (status ? "сдал" : "не сдал");
        }
    }








}
