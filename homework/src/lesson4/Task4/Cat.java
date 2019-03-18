package lesson4.Task4;

//Реализовать метод boolean fight(Cat anotherCat):
////        реализовать механизм драки котов в зависимости от их веса, возраста и силы.
////        Зависимость придумать самостоятельно.
////        Метод должен определять, выиграли ли мы (this) бой или нет,
////        т.е. возвращать true, если выиграли и false - если нет.
////        Должно выполняться условие:
////        если cat1.fight(cat2) = true,
////        то cat2.fight(cat1) = false
////        Сам метод fight не должен выводить данные на экран.

public class Cat {
    private String name;
    private int age;
    private int weight;
    private int strength;

    public Cat(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean fight(Cat cat) {

        if (this.age+this.strength+this.weight > cat.getAge()+cat.weight+cat.getStrength())
        return true;
        else return false;
    }
}
