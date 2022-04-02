package logic;

import data.IGame;

public class Game implements IGame {

    /**
     * Constructeur de la classe.
     */
    public Game() {

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
    public void createLevel() {

    }

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    @Override
    public int getLevel() {
        return 0;
    }

    /**
     * Donne la vitesse du niveau de jeu.
     * @return vitesse du jeu
     */
    @Override
    public int getSpeed() {
        return 0;
    }

    /**
     * Retourne la grille du jeu.
     * @return grille du jeu
     */
    @Override
    public Grid getGrid() {
        return null;
    }

    /**
     * Retourne le pacman du jeu.
     * @return pacman
     */
    @Override
    public Pacman getPacman() {
        return null;
    }

    /**
     * Retourne les fantômes du jeu.
     * @return fantômes
     */
    @Override
    public Ghost[] getGhosts() {
        return new Ghost[0];
    }

    /**
     * Retourne les fruits du jeu.
     * @return fruits
     */
    @Override
    public Fruit[] getFruits() {
        return new Fruit[0];
    }
}