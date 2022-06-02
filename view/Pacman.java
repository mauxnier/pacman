package view;

import view.src.Circle;

import java.awt.*;
import java.util.Random;

/**
 * A blue circle representing a bubble.
 *
 * @author Pascale Launay
 * @inv getSize() == 40
 * @inv getColor() != null
 * @inv getHeight() == getSize() && getWidth() == getSize()
 *
 * * @author Ikrame Bakkari
 *  * @version 01/06/2022
 */
public class Pacman extends Circle
{

    /**
     * the bubble size
     */
    public static final int SIZE = 40;

    /**
     * to generate random numbers
     */
    private static final Random RANDOM = new Random();

    /**
     * the distance for the next movement
     */
    protected int dist = 5;

    /**
     * the angle for the next movement
     */
    private double alpha = Math.PI / 2;

    /**
     * Constructor for objects of class Bubble
     *
     * @param x     the bubble initial x location
     * @param y     the bubble initial y location
     * @param color the bubble initial color.
     */
    public Pacman(int x, int y, Color color)
    {
        super(Pacman.SIZE, x, y, color);
        bubbleInvariant();
    }

    /**
     * Move the bubble in an autonomous way
     */
    @Override
    public void move()
    {
        this.alpha += Pacman.RANDOM.nextDouble() * Math.PI / 3 - Math.PI / 6;
        int dx = (int) Math.round(Math.cos(this.alpha) * this.dist);
        int dy = (int) Math.round(Math.sin(this.alpha) * this.dist);
        move(dx, dy);
        if (!isInside()) {
            this.alpha += Math.PI / 2;
            dx = (int) Math.round(Math.cos(this.alpha) * this.dist);
            dy = (int) Math.round(Math.sin(this.alpha) * this.dist);
            move(dx, dy);
        }
        bubbleInvariant();
    }

    //------------------------------------------------------------------------
    // Invariant
    //------------------------------------------------------------------------

    /**
     * Check the class invariant
     */
    protected final void bubbleInvariant()
    {
        super.circleInvariant();
        assert getSize() == 40 : "Invariant violated: wrong dimensions";
    }
}
