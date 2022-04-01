package data;

/**
 * Interface de la classe Ghost de la couche Data.
 */
public interface DataGhostInterface {

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