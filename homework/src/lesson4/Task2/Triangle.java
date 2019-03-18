package lesson4.Task2;

public class Triangle extends Figure {

    Point p1;
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }


    @Override
    public double getArea() {

        double semiPerimeter = getPerimeter()/2;
        return Math.sqrt((semiPerimeter*(semiPerimeter-Point.getLength(p1,p2))*(semiPerimeter-Point.getLength(p2,p3))*(semiPerimeter-Point.getLength(p3,p1))));
    }

    @Override
    public double getPerimeter() {
        return Point.getLength(p1, p2)+Point.getLength(p2,p3)+Point.getLength(p3,p1);
    }
}
