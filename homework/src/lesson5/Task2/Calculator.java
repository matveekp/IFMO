package lesson5.Task2;

//        Задание 2:
//        Написать калькулятор, где каждое действие (сложение, вычитание и тд)  - отдельный класс.
//        У каждой такого класса должен быть метод execute() - возвращает результат  (если сложение,
//        то execute возвращает результат сложения двух чисел и тд). Все данные считывать из консоли.
//        Объекты создаются в зависимости от переданного в консоль оператора (+ -  и тд).

public class Calculator {

    private Action action;

    public Calculator(Action action) {
        this.action = action;
    }

    public int execute(int x, int y) {
        return action.execute(x, y);
    }

    }