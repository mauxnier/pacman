package view;

import view.src.Circle;
import view.src.Figure;

import java.awt.*;

/**
 * Classe Fruit de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Fruit extends Circle {

    /** Constantes */
    private static final Color FRUIT_COLOR = Color.WHITE;
    private static final Color FLOOR_COLOR = Color.BLACK;

    /** Attributs */
    private boolean isSuperfruit;

    /**
     * Calcul et renvoie la taille d'un fruit.
     * @param isSuperfruit
     * @param sizeBlock
     * @return la taille d'un fruit
     */
    private static int getSize(boolean isSuperfruit, int sizeBlock) {
        int sizeFruit;
        if (isSuperfruit) {
            sizeFruit = sizeBlock/2;
        } else {
            sizeFruit = sizeBlock/5;
        }
        return sizeFruit;
    }

    /**
     * Retourne la position x du centre du fruit.
     * @param isSuperfruit
     * @param x
     * @param sizeBlock
     * @return la position x
     */
    private static int getXcentre(boolean isSuperfruit, int x, int sizeBlock) {
        int sizeFruit = getSize(isSuperfruit, sizeBlock);
        int xg = x + (sizeBlock/2) - (sizeFruit/2);
        return xg;
    }

    /**
     * Retourne la position y du centre du fruit.
     * @param isSuperfruit
     * @param y
     * @param sizeBlock
     * @return la position y
     */
    private static int getYcentre(boolean isSuperfruit, int y, int sizeBlock) {
        int sizeFruit = getSize(isSuperfruit, sizeBlock);
        int yg = y + (sizeBlock/2) - (sizeFruit/2);
        return yg;
    }

    /**
     * Constructeur d'un fruit.
     * @param sizeBlock la taille du bloc
     * @param x la position absolue x
     * @param y la position absolue y
     * @param isSuperfruit si le fruit est un superfruit
     */
    public Fruit(int sizeBlock, int x, int y, boolean isSuperfruit) {
        super(getSize(isSuperfruit, sizeBlock), getXcentre(isSuperfruit, x, sizeBlock), getYcentre(isSuperfruit, y, sizeBlock), FRUIT_COLOR);
    }

    public boolean getSupra() {
        return this.supra;
    }

    /**
     * dessine l'objet case Gomme
     * Square (fond)
     * Circle (gomme si exist)
     */
    public void draw () {
        for (Figure f : this.figures) {
            if (f!=null) {
                f.draw();
            }
        }
    }

}
