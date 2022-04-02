package logic;

/**
 * Interface de la classe Game de la couche Logic.
 * Couche Logic : donner l’état du jeu en fonction d’une direction.
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

    /**
     * Donne le nombre de points gagné dans la partie.
     * @return nombre de points
     */
    public int getPoints();

    /**
     * Modifie le nombre de points gagné dans la partie.
     * @param points nouveau nombre de points
     */
    public void setPoints(int points);

    /**
     * Ajoute un nombre de points au total déjà gagné dans la partie.
     * @param points nombre de points à ajouter
     */
    public void addPoints(int points);
}