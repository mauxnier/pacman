package logic;

import adding.Pos;

/**
 * Interface de la classe Grid de la couche Logic.
 * Couche Logic : donner l'état du jeu en fonction d'une direction.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public interface IGrid {

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    public boolean isPosAWall(Pos pos);

    /**
     * Donne le nombre de fruits restants pour le niveau de jeu.
     * @return le nombre de fruits restants
     */
    public int getNbFruitsLeft();
}