package data;

/**
 * Interface de la classe Pacman de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IPacman {
    /**
     * Donne la position du pacman sur la grille de jeu.
     * @return position du pacman
     */
    public int[][] getPosition();

    /**
     * Donne le nombre de vie restant pour le pacman.
     * @return nombre de vie
     */
    public int getNbLives();

    /**
     * Donne le nombre de point du pacman.
     * @return nombre de point
     */
    public int getPoints();

    /**
     * Retourne si le pacman est en train de bouger.
     * @return pacman bouge
     */
    public boolean isMoving();
}