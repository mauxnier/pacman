package view;

import view.src.Circle;
import view.src.Figure;
import view.src.Square;

import java.awt.*;

/**
 * Classe Fruit de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Ikrame Bakkari
 * @version 01/06/2022
 */
public class Fruit extends Circle {

    /** Constantes */
    private static final Color FRUIT_COLOR = Color.PINK;
    private static final Color FLOOR_COLOR = Color.BLACK;

    /** Attributs */
    private Figure[] figures;
    private boolean isSuperfruit;

    /**
     * Calcule et renvoie la taille d'un fruit.
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
        super(sizeBlock, x, y, FLOOR_COLOR);
        this.figures = new Figure[2];
        this.isSuperfruit = isSuperfruit;

        /** Création du sol */
        this.figures[0] = new Square(sizeBlock, x, y, this.FLOOR_COLOR);

        /** Création du fruit */
        int sizeFruit = sizeBlock;
        if (this.isSuperfruit) {
            sizeFruit = sizeBlock/2;
        } else {
            sizeFruit = sizeBlock/5;
        }
        int xg = x + (sizeBlock/2) - (sizeFruit/2);
        int yg = y + (sizeBlock/2) - (sizeFruit/2);
        this.figures[1] = new Circle(sizeFruit, xg, yg, this.FRUIT_COLOR);
    }

    /**
     * Retourne si le fruit est un superfruit.
     * @return isSuperfruit
     */
    public boolean getIsSuperfruit() {
        return this.isSuperfruit;
    }

    /**
     * Dessine le bloc d'un fruit.
     * Square (fond)
     * Circle (fruit)
     */
    public void draw() {
        for (Figure f : this.figures) {
            if (f != null) {
                f.draw();
            }
        }
    }
}
