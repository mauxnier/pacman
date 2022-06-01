package data;

/**
 * Interface de la classe Game de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public interface IGame {

    /**
     * Stop le jeu.
     */
    public void over();

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    public int getLevel();

    /**
     * Retourne la grille du jeu.
     * @return grille du jeu
     */
    public Grid getGrid();
}