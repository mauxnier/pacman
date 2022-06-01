package view.src;

import java.awt.*;

/**
 * A square that can be manipulated and drawn on a canvas.
 *
 * @author Pascale Launay
 * @inv getWidth() >= 0 && getHeight() >= 0
 * @inv getColor() != null
 * @inv getHeight() == getSize() && getWidth() == getSize()
 */
public class Square extends Rectangle
{
    /**
     * Create a new square.
     *
     * @param size  the square initial size
     * @param x     the square initial x location
     * @param y     the square initial y location
     * @param color the square initial color.
     * @pre size >= 0 && color != null
     */
    public Square(int size, int x, int y, Color color)
    {
        super(size, size, x, y, color);
        squareInvariant();
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
    protected final void squareInvariant()
    {
        super.invariant();
        assert getHeight() == getSize() && getWidth() == getSize() : "Invariant violated: wrong dimensions";
    }
}
