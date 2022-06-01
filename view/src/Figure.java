package view.src;

/**
 * An abstract figure that can be manipulated and drawn on a frame.
 *
 * @author Pascale Launay
 * @inv getWidth() >= 0 && getHeight() >= 0
 */
public abstract class Figure
{
    /**
     * the x location of the upper left corner of the figure bounding rectangle
     * in pixels
     */
    private int x;

    /**
     * the y location of the upper left corner of the figure bounding rectangle
     * in pixels
     */
    private int y;

    /**
     * the width of the figure bounding rectangle in pixels
     */
    private int width;

    /**
     * the height of the figure bounding rectangle in pixels
     */
    private int height;

    /**
     * Initialize the figure default properties
     */
    public Figure()
    {
        invariant();
    }

    /**
     * Initialize the figure properties
     *
     * @param width  the width of the figure bounding rectangle in pixels
     * @param height the height of the figure bounding rectangle in pixels
     * @param x      the x location of the upper left corner of the figure
     *               bounding rectangle in pixels
     * @param y      the y location of the upper left corner of the figure
     *               bounding rectangle in pixels
     * @pre width >= 0 && height >= 0
     */
    public Figure(int width, int height, int x, int y)
    {
        assert width >= 0 && height >= 0 : "Precondition violated: wrong dimensions";

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        invariant();
    }

    //------------------------------------------------------------------------
    // Draw
    //------------------------------------------------------------------------

    /**
     * Draw the figure with the current properties on the canvas.
     */
    public abstract void draw();

    /**
     * Erase the current figure from the canvas.
     */
    public abstract void erase();

    //------------------------------------------------------------------------
    // Getters
    //------------------------------------------------------------------------

    /**
     * Give the width of the figure bounding rectangle in pixels
     *
     * @return the figure width
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Give the height of the figure bounding rectangle in pixels
     *
     * @return the figure height
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Give the x location of the upper left corner of the figure bounding
     * rectangle in pixels
     *
     * @return the figure x location
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Give the y location of the upper left corner of the figure bounding
     * rectangle in pixels
     *
     * @return the figure y location
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Check whether the figure bounding rectangle is inside the canvas
     *
     * @return true if the figure is inside the canvas
     */
    protected boolean isInside()
    {
        CanvasFrame canvas = CanvasFrame.getCanvas();
        return getX() >= 0 && getY() >= 0 && getX() + getWidth() <= canvas.getWidth() && getY() + getHeight() <= canvas.getHeight();
    }

    /**
     * Check whether the current figure and the given figure bounding rectangles
     * have common points
     *
     * @return true if the figures have a non empty intersection
     */
    protected boolean intersects(Figure figure)
    {
        boolean intersectsX = (getX() > figure.getX() && getX() < figure.getX() + figure.getWidth())
                || (figure.getX() > getX() && figure.getX() < getX() + getWidth());
        if (intersectsX) {
            return (getY() > figure.getY() && getY() < figure.getY() + figure.getHeight())
                    || (figure.getY() > getY() && figure.getY() < getY() + getHeight());
        }
        return false;
    }

    //------------------------------------------------------------------------
    // Setters
    //------------------------------------------------------------------------

    /**
     * Change the location of the upper left corner of the figure bounding
     * rectangle
     *
     * @param dx number of pixels to move the figure to the right (dx>0) or left
     *           (dx<0)
     * @param dy number of pixels to move the figure to the bottom (dy>0) or top
     *           (dy<0)
     */
    public void move(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
        draw();
        invariant();
    }

    /**
     * Move the figure in an autonomous way (i.e. the dx and dy moves are chosen
     * by the object itself)
     */
    public void move()
    {
        // do nothing
        invariant();
    }

    //------------------------------------------------------------------------
    // Invariant
    //------------------------------------------------------------------------

    /**
     * Check the class invariant
     */
    protected final void invariant()
    {
        assert this.width >= 0 && this.height >= 0 : "Invariant violated: wrong dimensions";
    }
}
