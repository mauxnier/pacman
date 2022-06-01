package data;

public class Wall extends Block implements IWall {

    /**
     * Constructeur de la classe.
     * @param name nom du bloc mur dans le CSV
     * @param x position dans le CSV
     * @param y position dans le CSV
     */
    public Wall(String name, int x, int y) {
        super(name, x, y);
    }
}