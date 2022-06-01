package view;

import view.src.CanvasFrame;

import java.awt.*;

/**
 * This class represents a simple picture, composed of different figures: a
 * house, a sun and a person
 *
 * @author Pascale Launay
 */
public class SimplePicture
{

    /**
     * the canvas used to display the figure
     */
    private final CanvasFrame canvas;

    /**
     * the figure displayed
     */
    private final Figure[] figures;

    /**
     * Constructor for objects of class SimplePicture
     */
    public SimplePicture()
    {
        this.figures = new Figure[]{
                new House(180, 230, 80), // house
                new Sun(80, 330, 50), // sun
                new Person(50, 80, 330, 200, Color.BLUE) // person
        };
        this.canvas = CanvasFrame.getCanvas();
    }

    /**
     * Displays the picture in a window, and animate it
     *
     * @param args NONE
     */
    public static void main(String[] args)
    {
        SimplePicture picture = new SimplePicture();
        picture.draw();
        picture.animate();
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        for (Figure figure : this.figures) {
            figure.draw();
        }
        this.canvas.redraw();
    }

    /**
     * Animate this picture.
     */
    public void animate()
    {
        for (int i = 0; i < 30; i++) {
            this.canvas.wait(500);
            for (Figure figure : this.figures) {
                figure.move();
            }
            this.canvas.redraw();
        }
    }
}
