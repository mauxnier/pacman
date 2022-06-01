package view;

/**
 * Classe Grid de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Grid {

    /** Tableau à deux dimension de figure contenant toute les figures de la map case par case */
    private Figure[][] theMap;

    public MapGenerate(int length) {
        this.theMap = new Figure[length][length];
    }

    public void setFigure (int i, int j, Figure f) {
        this.theMap[i][j] = f;
    }

    public Figure[][] getTheMap () {
        return this.theMap;
    }

    /**
     * dessine la map
     */
    public void draw () {
        for (Figure[] fl : this.theMap) {
            for (Figure f : fl) {
                if (f!=null) {
                    f.draw();
                }
            }
        }
    }
}
