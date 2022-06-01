package view.src;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A circle that can be manipulated and drawn on a canvas.
 *
 * @author Pascale Launay
 * @inv getWidth() >= 0 && getHeight() >= 0
 * @inv getColor() != null
 * @inv getHeight() == getSize() && getWidth() == getSize()
 */
public class Circle extends SimpleFigure
{

    /**
     * Create a new circle.
     *
     * @param size  the circle initial size
     * @param x     the circle initial x location
     * @param y     the circle initial y location
     * @param color the circle initial color.
     * @pre size >= 0 && color != null
     */
    public Circle(int size, int x, int y, Color color)
    {
        super(size, size, x, y, color);
        circleInvariant();
    }

    //------------------------------------------------------------------------
    // Draw
    //------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    protected Shape makeShape()
    {
        return new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());
    }

    //------------------------------------------------------------------------
    // Getters
    //------------------------------------------------------------------------

    /**
     * Give the square size in pixels
     *
     * @return the square size in pixels
     */
    public int getSize()
    {
        return getWidth();
    }

    //------------------------------------------------------------------------
    // Invariant
    //------------------------------------------------------------------------

    /**
     * Check the class invariant
     */
    protected final void circleInvariant()
    {
        super.simpleFigureInvariant();
        assert getHeight() == getSize() && getWidth() == getSize() : "Invariant violated: wrong dimensions";
    }
}
