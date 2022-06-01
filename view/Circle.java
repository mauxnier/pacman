package view;
import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 *
 * @author launay
 * @version 2017.01.01
 *
 * @inv getWidth() == getHeight()
 */

public class Circle extends Figure
{

    /**
     * Create a new circle.
     *
     * @param size the circle initial size
     * @param x the circle initial x location
     * @param y the circle initial y location
     * @param color the circle initial color.
     *
     * @pre size >= 0
     * @pre color.equals("white") || color.equals("black") || color.equals("red") || color.equals("blue") || color.equals("yellow") || color.equals("green")
     */
    public Circle(int size, int x, int y, String color)
    {
        super(size, size, x, y, color);
    }

    /**
     * Give the circle size in pixels
     *
     * @return the circle size in pixels
     */
    public int getSize()
    {
        return getWidth();
    }

    /**
     * Change the size to the new size (in pixels).
     *
     * @param size the new size in pixels
     *
     * @pre size >= 0
     */
    public void setSize(int size)
    {
        super.setSize(size, size);
    }

    /**
     * Change the size to the new size (in pixels).
     *
     * @param width the new width in pixels
     * @param height the new height in pixels
     *
     * @pre width >= 0 && height == width
     */
    public void setSize(int width, int height)
    {
        assert width >= 0 && height == width : "Wrong dimensions";
        super.setSize(width, height);
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    protected void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, getColor(), new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight()));
    }

    /**
     * Check the class invariant
     */
    protected void invariant() {
        super.invariant();
        assert getWidth() == getHeight() : "Invariant violated: wrong dimensions";
    }
}
