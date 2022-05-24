package data;

import adding.Tuple2;

public class Wall implements IWall {

    private int x; // Position en x dans le CSV
    private int y; // Position en y dans le CSV

    /**
     * Constructeur de la classe.
     */
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Donne la position du mur sur la grille de jeu.
     * @return position du mur
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return new Tuple2<Integer, Integer>(this.x, this.y);
    }
}