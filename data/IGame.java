package data;

import logic.Fruit;
import logic.Ghost;
import logic.Grid;
import logic.Pacman;

/**
 * Interface de la classe Game de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGame {
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
    public Grid getGrid();

    /**
     * Retourne le pacman du jeu.
     * @return pacman
     */
    public Pacman getPacman();

    /**
     * Retourne les fantômes du jeu.
     * @return fantômes
     */
    public Ghost[] getGhosts();

    /**
     * Retourne les fruits du jeu.
     * @return fruits
     */
    public Fruit[] getFruits();

    /**
     * Donne le nombre de points gagné dans la partie.
     * @return nombre de points
     */
    public int getPoints();

    /**
     * Modifie le nombre de points gagné dans la partie.
     * @param points nouveau nombre de points
     */
    public void setPoints(int points);

    /**
     * Ajoute un nombre de points au total déjà gagné dans la partie.
     * @param points nombre de points à ajouter
     */
    public void addPoints(int points);
}