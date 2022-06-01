package logic;

/**
 * Classe Game de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Game implements IGame {

    private data.Game dataGame;
    Pacman pacman;


    private int points;
    private int level;

    /**
     * Constructeur de la classe.
     */
    public Game(data.Game dataGame) {
        points = 0;
        level = 1;
        this.dataGame = dataGame;
        this.pacman = new Pacman(dataGame.getGrid().getPacman());


    }

    @Override
    public void endLevel(){ 
        level = 1;
    }

    @Override
    public void levelUp(){ 
        level++;
    }

    @Override
    public int getPoints(){
        return points;
    }

    @Override
    public void setPoints(int points){
        this.points = points;
    }

    @Override
    public void addPoints(int points){
        this.points += points;
    }
}