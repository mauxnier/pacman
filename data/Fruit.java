package data;

public class Fruit extends Block implements IFruit {

    /** Constantes */
    private static final int FRUIT_POINTS = 10;
    private static final int SUPERFRUIT_POINTS = 50;

    /** Attributs */
    private String type; // Type du fruit (fruit, superfruit)
    private int points; // Nombre de points que rapporte le fruit quand il est mangé

    /**
     * Constructeur de la classe.
     * @param name nom du bloc fruit dans le CSV
     * @param x position dans le CSV
     * @param y position dans le CSV
     * @param type type de fruit
     */
    public Fruit(String name, int x, int y, String type) {
        super(name, x, y);
        this.type = type;
        this.points = getFruitPoints(type);
    }

    /**
     * Donne le type du fruit.
     * @return type du fruit
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Donne la valeur en points correspondent au type du fruit.
     * @return nombre de points
     */
    @Override
    public int getPoints() {
        return this.points;
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
                points = FRUIT_POINTS;
                break;
            case "superfruit":
                points = SUPERFRUIT_POINTS;
                break;
        }
        return points;
    }
}