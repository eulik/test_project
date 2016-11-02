package ru.olga.sandbox;

/**
 * Created by Olga on 01.11.2016.
 */
public class PointDistance {
    public static void main(String[] args) {
        Point a = new Point();
        Point b = new Point();

        a.inputPoint();
        b.inputPoint();

     System.out.println(Point.distance(a,b));

        a.printPoint();
        b.printPoint();

    a.distanceTo(b);

     System.out.println(a.distanceTo(b));
    }
}
