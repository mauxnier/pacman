package data;

/**
 * Interface de la classe Pacman de la couche Data.
 */
public interface DataPacmanInterface {

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
     * Donne le statut du pacman.
     * @return statut ["moving", "stopped"]
     */
    public String isMoving();
}