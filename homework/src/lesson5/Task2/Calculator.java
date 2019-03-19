package lesson5.Task2;

public class Calculator {

    private Action action;

    public Calculator(Action action) {
        this.action = action;
    }

    public int execute(int x, int y) {
        return action.execute(x, y);
    }

    }