package lesson4.Task2;

import java.awt.geom.Point2D;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double getLength(Point p1, Point p2) {
 //       double length=p2.getX()-p1.getX()
//        return length;

        double distance = Point2D.distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
