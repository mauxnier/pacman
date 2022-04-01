package data;

/**
 * Interface de la classe Fruit de la couche Data.
 */
public interface IFruit {

    /**
     * Donne la position du fruit sur la grille de jeu.
     * @return position du fruit
     */
    public int[][] getPosition();

    /**
     * Donne le type du fruit.
     * Fruit ou super-fruit.
     * @return type du fruit
     */
    public String getType();

    /**
     * Donne le nombre de point correspondent au type du fruit.
     * @return nombre de point
     */
    public int getPoints();

    /**
     * Retourne si le fruit a été mangé.
     * @return fruit est mangé
     */
    public boolean isEaten();
}