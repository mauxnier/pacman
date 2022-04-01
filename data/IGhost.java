package data;

/**
 * Interface de la classe Ghost de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGhost {
    /**
     * Donne la position du fantôme sur la grille de jeu.
     * @return position du fantôme
     */
    public int[][] getPosition();

    /**
     * Donne la couleur du fantôme.
     * @return couleur du fantôme
     */
    public String getColor();
}