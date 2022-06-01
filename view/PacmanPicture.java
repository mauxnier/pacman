package view;

import view.src.CanvasFrame;

import java.awt.*;
import java.util.Random;

/**
 * A program that displays and animates bubbles on the screen
 *
 * @author Pascale Launay
 */
public class PacmanPicture
{
    /**
     * the initial number of bubbles to be displayed
     */
    private static final int NB_BUBBLES = 10;

    /**
     * to generate random numbers
     */
    private static final Random RANDOM = new Random();

    /**
     * the bubbles to be displayed
     */
    private final Pacman[] bubbles;

    /**
     * the effective number of bubbles
     */
    private int nbBubbles;

    /**
     * Constructor for objects of class BubblePicture
     */
    public PacmanPicture()
    {
        CanvasFrame canvas = CanvasFrame.getCanvas();
        this.nbBubbles = PacmanPicture.NB_BUBBLES;
        this.bubbles = new Pacman[PacmanPicture.NB_BUBBLES];
        for (int i = 0; i < PacmanPicture.NB_BUBBLES; i++) {
            int x = PacmanPicture.RANDOM.nextInt(canvas.getWidth() - Pacman.SIZE);
            int y = PacmanPicture.RANDOM.nextInt(canvas.getHeight() - Pacman.SIZE);
            this.bubbles[i] = new Pacman(x, y, Color.CYAN);
        }
    }

    /**
     * Displays and animates bubbles on the screen
     *
     * @param args NONE
     */
    public static void main(String[] args)
    {
        PacmanPicture picture = new PacmanPicture();
        picture.draw();
        picture.animate();
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        for (int i = 0; i < this.nbBubbles; i++) {
            this.bubbles[i].draw();
        }
    }

    /**
     * Animate this picture.
     */
    public void animate()
    {
        CanvasFrame canvas = CanvasFrame.getCanvas();
        while (true) {
            move();
            canvas.wait(50);
            canvas.redraw();
        }
    }

    /**
     * Move the bubbles in this picture
     */
    protected void move()
    {
        for (int i = 0; i < this.nbBubbles; i++) {
            this.bubbles[i].move();
        }
    }

    /**
     * Give a bubble of this picture that is touched by an other given bubble,
     * if any. If no bubble is touched, return null. If several bubbles are
     * touched, give one amongst them.
     *
     * @param other a bubble
     * @return a touched bubble, if any
     */
    public Pacman getTouchedBubble(Pacman other)
    {
        for (int i = 0; i < this.nbBubbles; i++) {
            if (other.intersects(this.bubbles[i])) {
                return this.bubbles[i];
            }
        }
        return null;
    }

    /**
     * Remove a bubble from the picture. If the bubble is not in the picture, do
     * nothing
     *
     * @param bubble a bubble
     */
    public void removeBubble(Pacman bubble)
    {
        boolean found = false;
        for (int i = 0; i < this.nbBubbles; i++) {
            if (this.bubbles[i] == bubble) {
                bubble.erase();
                found = true;
            }
            if (found && i < this.nbBubbles - 1) {
                this.bubbles[i] = this.bubbles[i + 1];
            }
        }
        if (found) {
            this.nbBubbles--;
        }
    }
}
