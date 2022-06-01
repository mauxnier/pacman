package view;

import java.awt.Canvas;
import java.awt.geom.Arc2D;

/**
 * A Arc Circle that can be manipulated and that draws itself on a canvas.
 *
 * @author maxime,guillaume,remi
 * @version 2017.02.14
 *
 * @inv getWidth() == getHeight()
 */

public class ArcCircle extends Figure {
    private Double start;
    private Double extent;

    /**
     * Create a new Arc Circle.
     *
     * @param size the circle initial size
     * @param x the circle initial x location
     * @param y the circle initial y location
     * @param color the circle initial color.
     *
     * @pre size >= 0
     * @pre color.equals("white") || color.equals("black") || color.equals("red") || color.equals("blue") || color.equals("yellow") || color.equals("green")
     */
    public ArcCircle(int size, int x, int y, String color,double start,double extent) {
        super(size, size, x, y, color);
        this.start=start;
        this.extent=extent;
    }

    /**
     * Give the Arc circle size in pixels
     *
     * @return the Arc circle size in pixels
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
     * Draw the Arc Circle with current specifications on screen.
     */
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, getColor(), new Arc2D.Double(getX(),getY(),getWidth(),getHeight(),this.start,this.extent,2));
    }

    /**
     * Check the class invariant
     */
    public void invariant() {
        super.invariant();
        assert getWidth() == getHeight() : "Invariant violated: wrong dimensions";
    }

    /**
     * Change l'angle de début par un nouvel angle (en degres).
     *
     * @param angSt le nouvel angle en degres
     */
    public void setAngleStart(double angSt){
        this.start=angSt;
    }

    /**
     * Change l'angle de fin par un nouvel angle (en degres).
     *
     * @param angExt le nouvel angle en degres
     */
    public void setAngleExtent(double angExt){
        this.extent=angExt;
    }
}
