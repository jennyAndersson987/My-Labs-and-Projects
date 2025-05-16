package se.liu.jeand987.shapes;

import se.liu.jeand987.lab1.Lab2_Excercise1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DiagramComponent extends JComponent
{

    private List<Shape> shapes = new ArrayList<>();

    public DiagramComponent(final List<Shape> shapes) {
	this.shapes = shapes;
    }

    public void addShape(Shape s){
	shapes.add(s);
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	for (Shape shape: shapes){
	    shape.draw(g);
	}
    }
}