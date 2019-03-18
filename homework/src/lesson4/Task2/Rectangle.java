package lesson4.Task2;

public class Rectangle extends Figure {

    Point p1;
    Point p2;
    Point p3;
    Point p4;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public double getArea() {
        return Point.getLength(p1,p2)*Point.getLength(p2, p3);
    }

    @Override
    public double getPerimeter() {
        return Point.getLength(p1, p2) + Point.getLength(p2,p3) + Point.getLength(p3,p4) + Point.getLength(p4,p1);
    }
}
