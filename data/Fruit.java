package data;

import adding.Tuple2;

public class Fruit implements IFruit {

    /** Constantes */
    private static final int GAME_SPEED = 1;

    /** Attributs */
    private int x; // position en x dans le CSV
    private int y; // position en y dans le CSV
    private String type; // le type du fruit (fruit, superfruit)
    private int points; // nombre de points que rapporte le fruit quand il est mangé

    /**
     * Constructeur de la classe.
     */
    public Fruit(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.points = getFruitPoints(type);
    }

    /**
     * Donne la position du fruit sur la grille de jeu.
     * @return position du fruit
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return new Tuple2<Integer, Integer>(this.x, this.y);
    }

    /**
     * Donne le type du fruit.
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

    /**
     * Retourne la valeur en points correspondent au type du fruit.
     * @param type le type de fruit
     * @return le nombre de points
     */
    private int getFruitPoints(String type) {
        int points = 0;
        switch (type) {
            case "fruit":
                points = 10;
                break;
            case "superfruit":
                points = 50;
                break;
        }
        return points;
    }
}