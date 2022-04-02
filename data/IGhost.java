package data;

import adding.Tuple2;
import logic.Grid;

/**
 * Interface de la classe Ghost de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGhost {

    /**
     * Retourne la grille de jeu lié au fantôme.
     * @return la grille de jeu.
     */
    public Grid getGrid();

    /**
     * Donne la position du fantôme sur la grille de jeu.
     * @return position du fantôme
     */
    public Tuple2<Integer, Integer> getPos();

    /**
     * Donne la valeur en points du fantôme.
     * Utilisé quand il est mangé par le pacman.
     * @return points du fantôme
     */
    public int getPoints();

    /**
     * Donne la couleur du fantôme.
     * @return couleur du fantôme
     */
    public String getColor();

    /**
     * Retourne la forme du fantôme.
     * @return forme du fantôme
     */
    public String getShape();

    /**
     * Retourne le comportement du fantôme.
     * @return comportement du fantôme
     */
    public String getBehaviour();
}