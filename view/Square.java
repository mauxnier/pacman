package view;

import java.awt.Rectangle;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 *
 * @author launay
 * @version 2017.01.01
 *
 * @inv getWidth() == getHeight()
 */

public class Square extends Figure
{

    /**
     * Create a new square.
     *
     * @param size the square initial size
     * @param x the square initial x location
     * @param y the square initial y location
     * @param color the square initial color.
     *
     * @pre size >= 0
     * @pre color.equals("white") || color.equals("black") || color.equals("red") || color.equals("blue") || color.equals("yellow") || color.equals("green")
     */
    public Square(int size, int x, int y, String color)
    {
        super(size, size, x, y, color);
    }

    /**
     * Give the square size in pixels
     *
     * @return the square size in pixels
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
     * Draw the square with current specifications on screen.
     */
    protected void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, getColor(), new Rectangle(getX(), getY(), getWidth(), getHeight()));
    }

    /**
     * Check the class invariant
     */
    protected void invariant() {
        super.invariant();
        assert getWidth() == getHeight() : "Invariant violated: wrong dimensions";
    }
}
