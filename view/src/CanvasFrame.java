package view.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Class that allow for simple graphical drawing on a canvas.
 *
 * @author Pascale Launay
 */
public class CanvasFrame
{

    //-------------------------------------------------------------------------
    // Static part
    //-------------------------------------------------------------------------
    /**
     * The canvas initial default width
     */
    public static final int WIDTH = 500;

    /**
     * The canvas initial default height
     */
    public static final int HEIGHT = 500;

    /**
     * The canvas initial background color
     */
    public static final Color BACKGROUND = Color.WHITE;

    /**
     * this class unique instance (singleton)
     */
    private static CanvasFrame instance;

    /**
     * the frame that allows to display this canvas
     */
    private final JFrame frame;

    /**
     * the panel where the shapes are displayed
     */
    private final CanvasPane canvas;

    //-------------------------------------------------------------------------
    // Instance part
    //-------------------------------------------------------------------------
    /**
     * The figures to be displayed on the canvas at the next {@link
     * #redraw()} invocation.
     */
    private final Queue<SimpleFigure> figures;

    /**
     * the UP, DOWN, LEFT, RIGHT keys states: true if they are currently being
     * pressed
     */
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    /**
     * The canvas initial width
     */
    private int width;

    /**
     * The canvas initial height
     */
    private int height;

    /**
     * Create a Canvas.
     *
     * @param width  the canvas width
     * @param height the canvas height
     */
    private CanvasFrame(int width, int height)
    {
        this.figures = new ConcurrentLinkedQueue<>();

        this.canvas = new CanvasPane();
        setCanvasSize(width, height);

        this.frame = new JFrame();
        this.frame.setContentPane(this.canvas);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocation(30, 30);

        this.frame.pack();

        this.canvas.addKeyListener(new KeyboardListener());
        this.canvas.setFocusable(true);
    }

    /**
     * Factory method to get the canvas singleton object.
     *
     * @return the canvas instance
     */
    public static CanvasFrame getCanvas()
    {
        if (CanvasFrame.instance == null) {
            CanvasFrame.instance = new CanvasFrame(WIDTH, HEIGHT);
        }
        if (!CanvasFrame.instance.frame.isVisible()) {
            CanvasFrame.instance.frame.setVisible(true);
        }
        return CanvasFrame.instance;
    }

    /**
     * Factory method to get the canvas singleton object providing canvas size.
     *
     * @param width  the canvas width
     * @param height the canvas height
     * @return the canvas instance
     */
    public static CanvasFrame getCanvas(int width, int height)
    {
        if (CanvasFrame.instance == null) {
            CanvasFrame.instance = new CanvasFrame(width, height);
        } else {
            CanvasFrame.instance.setCanvasSize(width, height);
        }
        if (!CanvasFrame.instance.frame.isVisible()) {
            CanvasFrame.instance.frame.setVisible(true);
        }
        return CanvasFrame.instance;
    }

    //-------------------------------------------------------------------------
    // Setters
    //-------------------------------------------------------------------------

    /**
     * Close the frame
     */
    public void dispose()
    {
        this.frame.dispose();
    }

    //-------------------------------------------------------------------------
    // Getters
    //-------------------------------------------------------------------------

    /**
     * Give the canvas width
     *
     * @return the canvas width
     */
    public int getWidth()
    {
        int width = this.canvas.getWidth();
        if (width == 0) {
            width = this.width;
        }
        return width;
    }

    /**
     * Give the canvas height
     *
     * @return the canvas height
     */
    public int getHeight()
    {
        int height = this.canvas.getHeight();
        if (height == 0) {
            height = this.height;
        }
        return height;
    }

    //-------------------------------------------------------------------------
    // Draw
    //-------------------------------------------------------------------------

    /**
     * Redraw all shapes currently on the Canvas.
     */
    public void redraw()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                canvas.repaint();
            }
        });
    }

    /**
     * Wait for a specified number of milliseconds before finishing. This
     * provides an easy way to specify a small delay which can be used when
     * producing animations.
     *
     * @param milliseconds the delay to wait for in milliseconds
     */
    public void wait(int milliseconds)
    {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // ignoring exception at the moment
        }
    }

    /**
     * Draw a given shape onto the canvas.
     *
     * @param figure the figure to be drawn on the canvas
     */
    public void draw(SimpleFigure figure)
    {
        this.figures.remove(figure);   // just in case it was already there
        this.figures.add(figure);      // add at the end
    }

    /**
     * Erase a given shape's from the screen.
     *
     * @param figure the figure to be erased from the canvas
     */
    public void erase(SimpleFigure figure)
    {
        this.figures.remove(figure);
    }

    //-------------------------------------------------------------------------
    // Key pressed getters
    //-------------------------------------------------------------------------

    /**
     * Check whether the UP key is currently pressed
     *
     * @return true if the UP key is currently pressed
     */
    public boolean isUpPressed()
    {
        return this.upPressed;
    }

    /**
     * Check whether the DOWN key is currently pressed
     *
     * @return true if the DOWN key is currently pressed
     */
    public boolean isDownPressed()
    {
        return this.downPressed;
    }

    /**
     * Check whether the LEFT key is currently pressed
     *
     * @return true if the LEFT key is currently pressed
     */
    public boolean isLeftPressed()
    {
        return this.leftPressed;
    }

    /**
     * Check whether the RIGHT key is currently pressed
     *
     * @return true if the RIGHT key is currently pressed
     */
    public boolean isRightPressed()
    {
        return this.rightPressed;
    }

    //-------------------------------------------------------------------------
    // Private methods
    //-------------------------------------------------------------------------

    /**
     * Set the canvas width and height
     *
     * @param width  the canvas width
     * @param height the canvas height
     */
    private void setCanvasSize(int width, int height)
    {
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
    }

    //-------------------------------------------------------------------------
    // Inner classes
    //-------------------------------------------------------------------------

    /**
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the shapes drawn on it.
     */
    private class CanvasPane extends JPanel
    {

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setColor(BACKGROUND);
            g2D.fillRect(0, 0, getWidth(), getHeight());
            for (SimpleFigure figure : figures) {
                g2D.setColor(figure.getColor());
                g2D.fill(figure.makeShape());
            }
        }
    }

    /**
     * Inner class KeyboardListener - listens for the UP, DOWN, RIGHT, LEFT
     * keys.
     */
    private class KeyboardListener extends KeyAdapter
    {

        @Override
        public void keyPressed(KeyEvent event)
        {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    upPressed = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downPressed = true;
                    break;
                case KeyEvent.VK_LEFT:
                    leftPressed = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightPressed = true;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent event)
        {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    upPressed = false;
                    break;
                case KeyEvent.VK_DOWN:
                    downPressed = false;
                    break;
                case KeyEvent.VK_LEFT:
                    leftPressed = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightPressed = false;
                    break;
            }
        }
    }
}
