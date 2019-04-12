package patterns.dicontainer;

import patterns.dicontainer.di.Config;

@Config
public class Dog {
    private String dogName;

    public Dog() {
        System.out.println("dog init");
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                '}';
    }
}
