package view;

/**
 * Classe Game de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Ikrame Bakkari
 * @version 01/06/2022
 */
public class Game {

    private logic.Game logicGame;

    /** Constructeur de la classe */
    public Game(logic.Game logicGame) {
        this.logicGame = logicGame;
    }

    /**
     * Affiche la grille.
     */
    public void displayBoard() {
        data.Grid dataGrid = logicGame.getDataGame().getGrid();
        Grid grid = new Grid(dataGrid.getWidth(), dataGrid.getHeight());
        grid.draw();
    }
}