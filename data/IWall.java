package data;

import adding.Tuple2;

/**
 * Interface de la classe Wall de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public interface IWall {

    /**
     * Donne la position du mur sur la grille de jeu.
     * @return position du mur
     */
    public Tuple2<Integer, Integer> getPos();
}