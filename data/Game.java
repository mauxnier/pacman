package data;

import java.util.List;

public class Game implements IGame { // TODO reprendre les fonctions du game de logic (end level et levelup) celle de logic appeleront celle de data

    private int level; // Niveau de jeu
    private Grid grid; // Grille du jeu

    /**
     * Constructeur de la classe.
     */
    public Game(int level) {
        this.level = level;
        this.grid = createLevel();
    }

    /**
     * Lance le jeu.
     */
    @Override
    public void start() {

    }

    /**
     * Stop le jeu.
     */
    @Override
    public void over() {

    }

    /**
     * Créer le niveau de jeu.
     */
    @Override
    public Grid createLevel() {
        return new Grid(this.level);
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