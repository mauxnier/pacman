package view.src;

/**
 * A figure composed of one or more figures
 *
 * @author Pascale Launay
 * @inv getFigures() != null && getFigures().length > 0
 */
public class CompoundFigure extends Figure
{

    /**
     * the figures that compose the compound figure
     */
    private final Figure[] figures;

    /**
     * Initialize a compound figure composed of the gievn figures
     *
     * @param figures the figures that compose the compound figure
     * @pre figures != null && figures.length > 0
     */
    public CompoundFigure(Figure[] figures)
    {
        super();
        assert figures != null && figures.length > 0 : "empty figures list";
        this.figures = figures;
        compoundFigureInvariant();
    }

    /**
     * Initialize a compound figure composed of the gievn figures
     *
     * @param nbFigures the number of figures that compose the compound figure
     * @pre nbFigures > 0
     */
    public CompoundFigure(int nbFigures)
    {
        super();
        assert nbFigures > 0 : "empty figures list";
        this.figures = new Figure[nbFigures];
        compoundFigureInvariant();
    }

    /**
     * Set a figure at the given index
     *
     * @param idx    the index of the new figure
     * @param figure the figure
     * @pre idx >= 0 && idx < getFigures().length
     */
    public void setFigure(int idx, Figure figure)
    {
        this.figures[idx] = figure;
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
        for (int i = 0; i < figures.length; i++) {
            if (this.figures[i] != null) {
                this.figures[i].draw();
            }
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void erase()
    {
        for (int i = 0; i < figures.length; i++) {
            if (this.figures[i] != null) {
                this.figures[i].erase();
            }
        }
    }

    //------------------------------------------------------------------------
    // Getters
    //------------------------------------------------------------------------

    /**
     * Give the figures that compose the current figure
     *
     * @return the figures that compose this figure
     */
    public Figure[] getFigures()
    {
        return this.figures;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getX()
    {
        // look for the smallest x
        boolean first = true;
        int x = 0;
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null && (first || this.figures[i].getX() < x)) {
                x = this.figures[i].getX();
                first = false;
            }
        }
        return x;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getY()
    {
        // look for the smallest y
        boolean first = true;
        int y = 0;
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null && (first || this.figures[i].getY() < y)) {
                y = this.figures[i].getY();
                first = false;
            }
        }
        return y;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getWidth()
    {
        // look for the greatest x
        int x = 0;
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null && (this.figures[i].getX() + this.figures[i].getWidth()) > x) {
                x = this.figures[i].getX() + this.figures[i].getWidth();
            }
        }
        // return the difference between the greatest and the smallest x
        return x - this.getX();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getHeight()
    {
        // look for the greatest y
        int y = 0;
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null && (this.figures[i].getY() + this.figures[i].getHeight()) > y) {
                y = this.figures[i].getY() + this.figures[i].getHeight();
            }
        }
        // return the difference between the greatest and the smallest y
        return y - this.getY();
    }

    //------------------------------------------------------------------------
    // Setters
    //------------------------------------------------------------------------

    /**
     * {@inheritDoc }
     */
    @Override
    public void move()
    {
        for (Figure figure : this.figures) {
            figure.move();
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void move(int dx, int dy)
    {
        for (Figure figure : this.figures) {
            figure.move(dx, dy);
        }
    }

    //------------------------------------------------------------------------
    // Invariant
    //------------------------------------------------------------------------

    /**
     * Check the class invariant
     */
    protected final void compoundFigureInvariant()
    {
        super.invariant();
        assert this.figures != null && this.figures.length > 0 : "Invariant violated: empty figures list";
    }
}
