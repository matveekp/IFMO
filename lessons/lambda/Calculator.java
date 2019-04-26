package lambda;

public class Calculator {

    public double calculate(int a, int b, Operation operation){

        return operation.execute(a, b);
    }

    public static void main(String[] args) {
         Calculator calculator = new Calculator();
         Operation add = (a, b) -> a+b;

        System.out.println(calculator.calculate(3, 5, add ));

        Operation div = (a, b) -> {
          if ( b == 0) {

              throw new NullPointerException("на 0 делить нельзя");

          }

          return a/b;


        };

        System.out.println(calculator.calculate(6, 12, div));


        System.out.println(calculator.calculate(6, 12, ((a, b) -> a - b)));

    }

}

@FunctionalInterface
interface Operation {
    double execute(double a, double b);
}
