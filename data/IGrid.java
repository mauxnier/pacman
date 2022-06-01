package data;

import adding.Pos;
import java.util.List;

/**
 * Interface de la classe Grid de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGrid {

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    public boolean isPosAWall(Pos pos);

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