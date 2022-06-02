package logic;

/**
 * Interface de la classe Fruit de la couche Logic.
 * Couche Logic : donner l'état du jeu en fonction d'une direction.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public interface IFruit {

    /**
     * Retourne si le fruit a été mangé.
     * @return fruit est mangé
     */
    public boolean isEaten();

    /**
     * Fait disparaître le fruit
     */
    public void disappear();
}