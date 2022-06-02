package data;

import java.util.List;

/**
 * Interface de la classe Grid de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public interface IGrid {

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    public int getLevel();

    /**
     * Donne la vitesse du niveau de jeu.
     * @return vitesse du jeu
     */
    public int getSpeed();

    /**
     * Retourne le pacman du jeu.
     * @return pacman
     */
    public Pacman getPacman();

    /**
     * Retourne les fantômes du jeu.
     * @return fantômes
     */
    public List<Ghost> getGhosts();

    /**
     * Retourne les fruits du jeu.
     * @return fruits
     */
    public List<Fruit> getFruits();

    /**
     * Retourne les murs du jeu.
     * @return murs
     */
    public List<Wall> getWalls();
}