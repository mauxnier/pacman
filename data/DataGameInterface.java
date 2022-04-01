package data;

/**
 * Interface de la classe Game de la couche Data.
 */
public interface DataGameInterface {

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    public int getLevel();

    /**
     * Donne la vitesse du niveau de jeu.
     * @param level niveau de jeu
     * @return vitesse du jeu
     */
    public int getSpeed(int level);

    /**
     * Retourne la grille du jeu.
     * @return grille du jeu
     */
    public DataGrid getGrid();

    /**
     * Retourne le pacman du jeu.
     * @return pacman
     */
    public DataPacman getPacman();

    /**
     * Retourne les fantômes du jeu.
     * @return fantômes
     */
    public DataGhost[] getGhosts();

    /**
     * Retourne les fruits du jeu.
     * @return fruits
     */
    public DataFruit[] getFruits();

    /**
     * Retourne si le fruit a été mangé.
     * @return fruit est mangé
     */
    public boolean isStarted();
}