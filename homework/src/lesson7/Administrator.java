package lesson7;

public class Administrator {


    private static Administrator ourInstance = new Administrator();

    public static Administrator getInstance() {
       return ourInstance;
    }

    private Administrator() {
    }

    public void set(){

    }



}
