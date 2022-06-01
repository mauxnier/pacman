package view.src;

import view.src.CanvasFrame;
import view.src.Figure;

import java.awt.*;

/**
 * An abstract figure composed of a single shape
 *
 * @author Pascale Launay
 * @inv getWidth() >= 0 && getHeight() >= 0
 * @inv getColor() != null
 */
public abstract class SimpleFigure extends Figure
{
    /**
     * the shape color
     */
    private Color color;

    /**
     * Initialize the figure properties
     *
     * @param width  the width of the figure bounding rectangle in pixels
     * @param height the height of the figure bounding rectangle in pixels
     * @param x      the x location of the upper left corner of the figure
     *               bounding rectangle in pixels
     * @param y      the y location of the upper left corner of the figure
     *               bounding rectangle in pixels
     * @param color  the shape color
     * @pre width >= 0 && height >= 0 && color != null
     */
    public SimpleFigure(int width, int height, int x, int y, Color color)
    {
        super(width, height, x, y);
        assert color != null : "color is null";
        this.color = color;

        simpleFigureInvariant();
    }

    //------------------------------------------------------------------------
    // Draw
    //------------------------------------------------------------------------

    /**
     * {@inheritDoc }
     */
    @Override
    public void draw()
    {
        CanvasFrame canvas = CanvasFrame.getCanvas();
        canvas.draw(this);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void erase()
    {
        CanvasFrame canvas = CanvasFrame.getCanvas();
        canvas.erase(this);
    }

    /**
     * Make a shape that represents this figure at the current location and size
     *
     * @return shape representing this figure
     */
    protected abstract Shape makeShape();

    //------------------------------------------------------------------------
    // Getters
    //------------------------------------------------------------------------

    /**
     * Give the figure color
     *
     * @return the figure color
     */
    public Color getColor()
    {
        return this.color;
    }

    //------------------------------------------------------------------------
    // Setters
    //------------------------------------------------------------------------

    /**
     * Set the figure color
     *
     * @param color the figure color
     * @pre color != null
     */
    public void setColor(Color color)
    {
        assert color != null : "color is null";
        this.color = color;
        simpleFigureInvariant();
    }

    //------------------------------------------------------------------------
    // Invariant
    //------------------------------------------------------------------------

    /**
     * Check the class invariant
     */
    protected final void simpleFigureInvariant()
    {
        super.invariant();
        assert this.color != null : "Invariant violated: color is null";
    }
}
