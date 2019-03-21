package lesson6.classWork;

public class SomeClass {

    private static final SomeClass instance = new SomeClass();

    private SomeClass(){}

    static SomeClass getObj(){

        return instance;

    }

    public void printInfo(String string) {
        System.out.println("info" + string);
    }



}

class SomeClass2 {

    public void someVoid() {

        SomeClass someClass = SomeClass.getObj();
        someClass.printInfo("data");

        SomeClass someClass1 = SomeClass.getObj();
        someClass.printInfo("data");
    }}