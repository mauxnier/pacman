package logic;

public class Grid implements IGrid {

    Game game;
    int nbFruitsLeft;
    data.Grid dataGrid;

    /**
     * Constructeur de la classe.
     */
    public Grid(Game game, data.Grid dataGrid, int nbFruits) {
        this.game = game;
        nbFruitsLeft = nbFruits;
    }

    @Override
    public int getNbFruitsLeft(){
        return nbFruitsLeft;
        
    }
}