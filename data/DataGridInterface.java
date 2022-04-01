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
     * Donne la position des fruits sur la grille de jeu.
     * @param level le niveau de jeu
     * @return la position des fruits
     */
    public int[][] getFruitsPos(int level);

    /**
     * Donne le nombre de fruits restants pour le niveau de jeu.
     * @param level le niveau de jeu
     * @return le nombre de fruits restants
     */
    public int getNbFruits(int level);
}