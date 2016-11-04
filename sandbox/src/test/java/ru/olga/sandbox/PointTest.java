package ru.olga.sandbox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Olga on 04.11.2016.
 */
public class PointTest {
    @Test
    public void testDistanceTo() throws Exception {
        Point a = new Point(1.,2.);
        assertEquals(a.distanceTo (a), 0.0);
    }


    @Test
    public void testDistance() throws Exception {
        Point a = new Point(1.,2.);
        Point b = new Point (2.,1);

        double distance = Point.distance (a,b);

        assertEquals(distance, 1.4142135623730951);

    }

}
