package data;

/**
 * Interface de la classe Grid de la couche Data.
 */
public interface DataGridInterface {

    /**
     * Donne la position des murs sur la grille de jeu.
     * @param level le niveau de jeu
     * @return la position des murs
     */
    public int[][] getWallsPos(int level);

    /**
     * Donne le nombre de fruits restants pour le jeu.
     * @return le nombre de fruits restants
     */
    public int getNbFruitsLeft();
}