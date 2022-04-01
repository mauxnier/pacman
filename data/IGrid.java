package data;

/**
 * Interface de la classe Grid de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGrid {

    /**
     * Donne la position des murs sur la grille de jeu.
     * @param level le niveau de jeu
     * @return la position des murs
     */
    public int[][] getWallsPos(int level);

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isPosAWall(int x, int y);

    /**
     * Donne le nombre de fruits restants pour le jeu.
     * @return le nombre de fruits restants
     */
    public int getNbFruitsLeft();
}