package lambda;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {


        Predicate<Integer> pos = (num) -> num > 0;
        Predicate<Integer> neg = (num) -> num < 0;
        Predicate<Integer> four = (num) -> num == 4;

        System.out.println(pos.test(5));
        System.out.println(neg.test(5));
        System.out.println(four.test(4));

        System.out.println(pos.and(four).test(4));
        System.out.println(pos.or(four).test(3));


        //интерйфейс Function<T, R> принимает значение в качестве аргумента одного типа (Т)
        //и возвращает другое (R)
        //метод R apply(T t)
//        default
        //andThen
//        compose
        //
        //


        Function<Integer, String> convert = a -> a + "$";
        System.out.println(convert.apply(5));

        Function<Integer, Double> tenPercent = a -> a * 0.1;
        System.out.println(tenPercent.apply(100));

//        System.out.println(tenPercent.andThen(tenPercent).apply(1000));

        Function<Integer, Integer> plusTen = a -> a + 10;
        Function<Integer, Integer> plusFive = a -> a + 5;

        System.out.println(plusTen.andThen(plusFive).andThen(tenPercent).apply(20));


        Function<Integer, Integer> addTwo = a -> a * 2;
        Function<Integer, Integer> squared = a -> a * a;

        System.out.println(addTwo.andThen(squared).apply(3));
        System.out.println(addTwo.compose(squared).apply(3));


//         задача: дан предикат (Predicate) condition и две функции (Function) ifTrue and ifFalse
//         написать метод, который вернет функцию (Function),
//        возвращающую значение функции ifTrue, если condition - true и наоборот

        Predicate<Integer> condiotion = num -> num > 0;
        Function<Integer, Integer> ifTrue = a -> a + 10;
        Function<Integer, Integer> ifFalse = a -> a - 10;

        Function<Integer, Integer> func = getFunction(condiotion, ifTrue, ifFalse);

        System.out.println(func.apply(34));
        System.out.println(func.apply(-34));


        //BinaryOperator<T>



    }

    public static Function<Integer, Integer> getFunction(
            Predicate<Integer> condition,
            Function<Integer, Integer> ifTrue,
            Function<Integer, Integer> ifFalse
    ) {
        return a -> condition.test(a) ? ifTrue.apply(a) : ifFalse.apply(a);
    }
}
