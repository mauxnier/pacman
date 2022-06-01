package logic;

/**
 * Interface de la classe Grid de la couche Logic.
 * Couche Logic : donner l'état du jeu en fonction d'une direction.
 */
public interface IGrid {

    /**
     * Donne le nombre de fruits restants pour le niveau de jeu.
     * @return le nombre de fruits restants
     */
    public int getNbFruitsLeft();
}