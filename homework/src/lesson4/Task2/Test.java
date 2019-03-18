package lesson4.Task2;

import javax.sound.midi.Track;

public class Test {
    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle(new Point(0,0), new Point(0,2), new Point(2,2), new Point(2,0));

        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());


        Triangle triangle = new Triangle(new Point(0,0), new Point(0,2), new Point(3,0));
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());

        Circle circle = new Circle(new Point(0,0), 5);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

    }
}
