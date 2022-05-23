package data;

import adding.Tuple2;

/**
 * Interface de la classe Grid de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGrid {

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param coords couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    public boolean isPosAWall(Tuple2<Integer, Integer> coords);
}