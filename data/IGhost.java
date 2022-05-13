package data;

import adding.Tuple2;

/**
 * Interface de la classe Ghost de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGhost {

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