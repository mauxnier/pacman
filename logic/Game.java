package logic;

public class Game implements IGame {

    data.Game dataGame;
    int points;
    int level;

    /**
     * Constructeur de la classe.
     */
    public Game(data.Game dataGame) {
        points = 0;
        level = 1;
        this.dataGame = dataGame;
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