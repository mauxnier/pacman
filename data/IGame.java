package data;

/**
 * Interface de la classe Game de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGame {

    /**
     * Lance le jeu.
     */
    public void start();

    /**
     * Stop le jeu.
     */
    public void over();

    /**
     * Créer le niveau de jeu.
     */
    public Grid createLevel(int level);

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