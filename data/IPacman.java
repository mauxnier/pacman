package data;

import adding.Tuple2;
import logic.Grid;

/**
 * Interface de la classe Pacman de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IPacman {

    /**
     * Retourne la grille de jeu lié au pacman.
     * @return la grille de jeu.
     */
    public Grid getGrid();

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
}