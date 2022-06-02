package view;

import view.src.Figure;

/**
 * Classe Grid de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Ikrame Bakkari
 * @version 01/06/2022
 */
public class Grid {

    /** Tableau à deux dimension de figure contenant toute les figures de la grille bloc par bloc */
    private Figure[][] board;
    private int width;
    private int height;

    /**
     * Constructeur de la classe.
     * @param width
     * @param height
     */
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new Figure[height][width];
    }

    public void setFigure(int i, int j, Figure f) {
        this.board[i][j] = f;
    }

    public Figure[][] getBoard() {
        return this.board;
    }

    /**
     * Dessine la grille.
     */
    public void draw() {
        for (Figure[] line : this.board) {
            for (Figure f : line) {
                if (f != null) {
                    f.draw();
                }
            }
        }
    }
}
