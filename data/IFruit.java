package data;

import adding.Tuple2;

/**
 * Interface de la classe Fruit de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IFruit {

    /**
     * Donne la position du fruit sur la grille de jeu.
     * @return position du fruit
     */
    public Tuple2<Integer, Integer> getPos();

    /**
     * Donne le type du fruit.
     * Fruit / super-fruit etc...
     * @return type du fruit
     */
    public String getType();

    /**
     * Donne la valeur en points correspondent au type du fruit.
     * @return nombre de points
     */
    public int getPoints();
}