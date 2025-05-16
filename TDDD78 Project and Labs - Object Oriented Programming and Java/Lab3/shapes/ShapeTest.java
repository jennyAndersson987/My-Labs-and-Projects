package se.liu.jeand987.shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeTest
{
    public static void main(String[] args) {

	final ArrayList<Shape> shapes = new ArrayList<>();
	Shape sak1 = new Circle(2, 3 , 5, Color.BLUE);
	Shape sak2 = new Rectangle(4,5,Color.PINK,1,2);
	Shape sak3 = new Text(1,2,Color.PINK,4,"tjena");

	shapes.add(sak1);
	shapes.add(sak2);
	shapes.add(sak3);

	for (Shape shape : shapes) {
	    System.out.println(shape.getX() + " " + shape.getY());
	    
	}

    }
}
