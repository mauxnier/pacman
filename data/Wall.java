package data;

/**
 * Classe Wall de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
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