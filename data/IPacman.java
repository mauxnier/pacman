package data;

/**
 * Interface de la classe Pacman de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public interface IPacman {

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