package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example.
 *
 * @author Bruce Quig
 * @author Michael Kolling (mik)
 *
 * @version 2011.07.31
 */
public class Canvas
{
    public static final int WIDTH = 500, HEIGHT = 500;

    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    private static Canvas canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("Pac-Man by Guillaume & Maxime & Rémi", WIDTH, HEIGHT,
                    Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- instance part -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    /**
     * Create a Canvas.
     * @param title    title to appear in Canvas Frame
     * @param width    the desired width for the canvas
     * @param height   the desired height for the canvas
     * @param bgColor the desired background color of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();

        canvas.addKeyListener(new KeyboardListener());
        canvas.setFocusable(true);
    }

    /**
     * Check whether the UP key is currently pressed
     * @return true if the UP key is currently pressed
     */
    public boolean isUpPressed()
    {
        return upPressed;
    }

    /**
     * Check whether the DOWN key is currently pressed
     * @return true if the DOWN key is currently pressed
     */
    public boolean isDownPressed()
    {
        return downPressed;
    }

    /**
     * Check whether the LEFT key is currently pressed
     * @return true if the LEFT key is currently pressed
     */
    public boolean isLeftPressed()
    {
        return leftPressed;
    }

    /**
     * Check whether the RIGHT key is currently pressed
     * @return true if the RIGHT key is currently pressed
     */
    public boolean isRightPressed()
    {
        return rightPressed;
    }

    public void resetMove(){
        rightPressed = false;
        leftPressed = false;
        upPressed = false;
        downPressed = false;
    }

    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed
     * @param  x      x co-ordinate for text placement
     * @param  y      y co-ordinate for text placement
     */
    public void printString(String text, int x, int y)
    {
        graphic.setFont(new Font("Arial", Font.BOLD, 20));
        graphic.setColor(Color.WHITE);
        graphic.drawString(text, x, y);
        canvas.repaint();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false)
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     * @param  referenceObject  an object to define identity for this shape
     * @param  color            the color of the shape
     * @param  shape            the shape object to be drawn on the canvas
     */
    // Note: this is a slightly backwards way of maintaining the shape
    // objects. It is carefully designed to keep the visible shape interfaces
    // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, String color, Shape shape)
    {
        objects.remove(referenceObject);   // just in case it was already there
        objects.add(referenceObject);      // add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        //         redraw();
    }

    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased
     */
    public void erase(Object referenceObject)
    {
        objects.remove(referenceObject);   // just in case it was already there
        shapes.remove(referenceObject);
        //         redraw();
    }

    /**
     * Set the foreground color of the Canvas.
     * @param  newColor   the new color for the foreground of the Canvas
     */
    public void setForegroundColor(String colorString)
    {
        if(colorString.equals("red")) {
            graphic.setColor(new Color(235, 25, 25));
        }
        else if(colorString.equals("black")) {
            graphic.setColor(Color.black);
        }
        else if(colorString.equals("blue")) {
            graphic.setColor(new Color(0, 0, 204));
        }
        else if(colorString.equals("violet")) {
            graphic.setColor(new Color(130, 0, 140));
        }
        else if(colorString.equals("yellow")) {
            graphic.setColor(new Color(255, 230, 0));
        }
        else if(colorString.equals("green")) {
            graphic.setColor(new Color(80, 160, 60));
        }
        else if(colorString.equals("pink")) {
            graphic.setColor(new Color(255, 0, 127));
        }
        else if(colorString.equals("white")) {
            graphic.setColor(Color.white);
        }
        else if(colorString.equals("redG")) {
            graphic.setColor(new Color(239, 7, 7));
        }
        else if(colorString.equals("blueG")) {
            graphic.setColor(new Color(102, 254, 255));
        }
        else if(colorString.equals("orangeG")) {
            graphic.setColor(new Color(250, 156, 0));
        }
        else if(colorString.equals("pinkG")) {
            graphic.setColor(new Color(255, 152, 153));
        }
        else {
            graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * Redraw all shapes currently on the Canvas.
     */
    public void redraw(int score, int life, String meilleurScore)
    {
        erase();
        for(Object shape : objects) {
            shapes.get(shape).draw(graphic);
        }
        printString("Score : "+score, 10, 20);
        printString("Vie : "+life, 10, 40);
        printString("Meilleur score : "+meilleurScore, 240, 20);
        canvas.repaint();
        wait(125);
    }

    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }

    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class ShapeDescription
    {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color)
        {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic)
        {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }

    /************************************************************************
     * Inner class KeyboardListener - listens for the UP, DOWN, RIGHT, LEFT keys.
     */
    private class KeyboardListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    upPressed = true;
                    downPressed = false;
                    leftPressed = false;
                    rightPressed = false;
                    break;
                case KeyEvent.VK_DOWN:
                    upPressed = false;
                    downPressed = true;
                    leftPressed = false;
                    rightPressed = false;
                    break;
                case KeyEvent.VK_LEFT:
                    upPressed = false;
                    downPressed = false;
                    leftPressed = true;
                    rightPressed = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    upPressed = false;
                    downPressed = false;
                    leftPressed = false;
                    rightPressed = true;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent event) {

            switch (event.getKeyCode()) {
              /*
        	    case KeyEvent.VK_UP: upPressed = false; break;
        	    case KeyEvent.VK_DOWN: downPressed = false; break;
        	    case KeyEvent.VK_LEFT: leftPressed = false; break;
        	    case KeyEvent.VK_RIGHT: rightPressed = false; break;
              */
            }

        }
    }
}
