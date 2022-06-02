package logic;

/**
 * Classe Game de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Game implements IGame {

    private data.Game dataGame;
    private int level; // Niveau de jeu
    private Grid grid; // Grille du jeu

    /**
     * Constructeur de la classe.
     * @param dataGame
     */
    public Game(data.Game dataGame) {
        this.dataGame = dataGame;
        this.level = this.dataGame.getLevel();
        this.grid = new Grid(this.dataGame.getGrid());
    }

    @Override
    public void endLevel() {
        // this.dataGame.endLevel();
    }

    @Override
    public void levelUp() {
        this.dataGame.levelUp();
    }

    public data.Game getDataGame() {
        return dataGame;
    }

    public int getLevel() {
        return level;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}