package data;

import adding.Tuple2;

/**
 * Interface de la classe Pacman de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IPacman {

    /**
     * Donne la position du pacman sur la grille de jeu.
     * @return position du pacman
     */
    public Tuple2<Integer, Integer> getPos();

    /**
     * Donne le nombre de vie restant pour le pacman.
     * @return nombre de vie
     */
    public int getLives();

    /**
     * Donne le nombre de points accumulé par le pacman.
     * @return nombre de points
     */
    public int getPoints();
}