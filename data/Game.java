package data;

/**
 * Classe Game de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Game implements IGame {

    private int level; // Niveau de jeu
    private Grid grid; // Grille du jeu

    /**
     * Constructeur de la classe.
     */
    public Game(int level) {
        this.level = level;
        createLevel();
    }

    /**
     * Stop le jeu.
     */
    @Override
    public void over() {

    }

    /**
     * Monte d'un niveau supérieur la grille liée au jeu.
     */
    public void levelUp() {
        this.level += 1;
        this.createLevel();
    }

    /**
     * Créer une grille de jeu en fonction d'un niveau.
     */
    private void createLevel() {
        this.grid = new Grid(this);
    }

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    @Override
    public int getLevel() {
        return this.level;
    }

    /**
     * Retourne la grille du jeu.
     * @return grille du jeu
     */
    @Override
    public Grid getGrid() {
        return this.grid;
    }
}