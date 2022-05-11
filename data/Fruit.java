package data;

import adding.Tuple2;

public class Fruit implements IFruit {
    /**
     * Retourne la grille de jeu lié au fruit.
     * @return la grille de jeu.
     */
    @Override
    public Grid getGrid() {
        return null;
    }

    /**
     * Donne la position du fruit sur la grille de jeu.
     * @return position du fruit
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return null;
    }

    /**
     * Donne le type du fruit.
     * Fruit / super-fruit etc...
     * @return type du fruit
     */
    @Override
    public String getType() {
        return null;
    }

    /**
     * Donne la valeur en points correspondent au type du fruit.
     * @return nombre de points
     */
    @Override
    public int getPoints() {
        return 0;
    }
}