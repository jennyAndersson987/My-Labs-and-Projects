package se.liu.jeand987.shapes;

import java.awt.*;
import java.util.ArrayList;

public class CirceTest
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();
	Circle circle1 = new Circle(1, 2, 3, Color.BLACK);
	Circle circle2 = new Circle(2, 3, 4, Color.BLUE);
	circles.add(circle1);
	circles.add(circle2);
	for (Circle circle : circles) {
	    System.out.println(circle.getX() + " " + circle.getY());
	}
    }
}
