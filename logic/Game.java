package logic;

/**
 * Classe Game de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Game implements IGame {

    private data.Game dataGame;
    private int points;
    private int level;

    /**
     * Constructeur de la classe.
     * @param dataGame
     */
    public Game(data.Game dataGame) {
        points = 0;
        level = 1;
        this.dataGame = dataGame;
    }

    /**
     * Retourne l'objet data.Game
     * @return dataGame
     */
    public data.Game getDataGame() {
        return this.dataGame;
    }

    @Override
    public void endLevel() {
        // this.dataGame.endLevel();
    }

    @Override
    public void levelUp() {
        this.dataGame.levelUp();
    }

    @Override
    public int getPoints() {
        return this.dataGame.getGrid().getPacman().getPoints();
    }

    @Override
    public void setPoints(int points) {
        this.dataGame.getGrid().getPacman().setPoints() = points;
    }

    @Override
    public void addPoints(int points){
        this.points += points;
    }
}