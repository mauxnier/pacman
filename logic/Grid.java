package logic;

/**
 * Classe Grid de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Grid implements IGrid {

    Game game;
    private int nbFruitsLeft;
    data.Grid dataGrid;

    /**
     * Constructeur de la classe.
     */
    public Grid(Game game, data.Grid dataGrid, int nbFruits) {
        this.game = game;
        nbFruitsLeft = nbFruits;
        this.dataGrid = dataGrid;
    }

    @Override
    public int getNbFruitsLeft(){
        return nbFruitsLeft;
        
    }
}