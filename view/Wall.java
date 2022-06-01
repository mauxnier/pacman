package view;

import view.src.Square;

import java.awt.*;


/**
 *
 */
public class Wall extends Square {

    /**
     * Constructeur du mur.
     * @param size la taille du mur
     * @param x position absolue x
     * @param y position absolue y
     * @param color couleur du mur
     */
    public Wall(int size, int x, int y, Color color) {
        super(size, x, y, color);
    }
}
