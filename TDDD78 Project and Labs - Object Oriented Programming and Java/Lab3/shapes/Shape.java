package se.liu.jeand987.shapes;

import java.awt.*;


public interface Shape
{
    public int getX();

    public int getY();

    public Color getColor();

    public void draw(final Graphics g);

}
