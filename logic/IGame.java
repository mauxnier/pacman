package logic;

/**
 * Interface de la classe Game de la couche Logic.
 * Couche Logic : donner l'état du jeu en fonction d'une direction.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public interface IGame {

    /**
     * Termine le niveau du jeu.
     */
    public void endLevel();

    /**
     * Change de niveau de jeu.
     */
    public void levelUp();
}