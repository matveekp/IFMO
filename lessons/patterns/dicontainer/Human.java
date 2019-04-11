package patterns.dicontainer;

import patterns.dicontainer.di.AutoField;
import patterns.dicontainer.di.AutoRun;
import patterns.dicontainer.di.Component;

@Component
public class Human {
    @AutoField
    Cat cat;
    @AutoField
    Dog dog;

    public Human() {
        System.out.println("human init");
    }

    @AutoRun
    public void walkWithCat() {
        System.out.println("walk with " + cat.getCatName());
    }

    @AutoRun
    public void walkWithDog() {
        System.out.println("walk with " + dog.getDogName());
    }

}
