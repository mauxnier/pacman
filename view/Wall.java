package view;

import view.src.Square;

import java.awt.*;

/**
 * Classe Wall de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Ikrame Bakkari
 * @version 01/06/2022
 */
public class Wall extends Square {

    /** Constantes */
    private static final Color COLOR = Color.BLUE;

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
