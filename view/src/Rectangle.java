package view.src;

import java.awt.*;

/**
 * A rectangle that can be manipulated and drawn on a canvas.
 *
 * @author Pascale Launay
 * @inv getWidth() >= 0 && getHeight() >= 0
 * @inv getColor() != null
 */
public class Rectangle extends SimpleFigure
{
    /**
     * Create a new square.
     *
     * @param width  the rectangle initial width
     * @param height the rectangle initial height
     * @param x      the square initial x location
     * @param y      the square initial y location
     * @param color  the square initial color.
     * @pre width >= 0 && height >= 0 && color != null
     */
    public Rectangle(int width, int height, int x, int y, Color color)
    {
        super(width, height, x, y, color);
    }

    //------------------------------------------------------------------------
    // Draw
    //------------------------------------------------------------------------

    /**
     * {@inheritDoc }
     */
    @Override
    protected Shape makeShape()
    {
        return new java.awt.Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
