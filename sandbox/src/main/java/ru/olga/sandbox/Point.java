package ru.olga.sandbox;

import java.util.Scanner;

/**
 * Created by Olga on 01.11.2016.
 */
public class Point {

   public Point (){
       this.x = 0;
       this.y = 0;
   }
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void inputPoint() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Set x coordinate: ");
        this.x = inp.nextDouble();
        System.out.print("Set y coordinate: ");
        this.y = inp.nextDouble();
    }

    void printPoint (){
        System.out.println("Point has coordinates:("+x+" ; "+y+")");
    }



    public static String distance(Point a, Point b){

        double distance = Math.sqrt (Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
        return "Distance between Point a and Point b is " + distance;
    }

    public String distanceTo (Point other){
        return Point.distance (this,other);
    }
}

