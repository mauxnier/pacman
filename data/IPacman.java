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
    public Tuple2<Integer, Integer> getPosition();

    /**
     * Donne le nombre de vie restant pour le pacman.
     * @return nombre de vie
     */
    public int getNbLives();

    /**
     * Retourne si le pacman est en train de bouger.
     * @return pacman bouge
     */
    public boolean isMoving();
}