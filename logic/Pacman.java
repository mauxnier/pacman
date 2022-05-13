package logic;


import adding.Tuple2;

public class Pacman implements IPacman {

    Game game;
    data.Pacman dataPacman;
    int nbLives;
    boolean isSuperpowered;

    /**
     * Constructeur de la classe.
     */
    public Pacman(Game game, data.Pacman dataPacman) {
        this.game = game;
        this.nbLives = dataPacman.getLives();
        isSuperpowered = false;

    }

    @Override
    public void move(){

    }

    @Override
    public void eatFruit(Fruit eatedFruit){
        eatedFruit.disappear();
        int fruitValue = eatedFruit.dataFruit.getPoints();
        game.addPoints(fruitValue);

    }

    @Override
    public void eatGhost(Ghost eatedGhost){
        eatedGhost.die();
        int ghostValue = eatedGhost.dataGhost.getPoints();
        game.addPoints(ghostValue);

    }

    @Override
    public void superpower(){
        isSuperpowered = true;

    }

    @Override
    public void hurt(){
        nbLives--;
    }

    @Override
    public void die(){
        game.endLevel();
    }

    @Override
    public boolean isOnGhost(){
        boolean isOnGhost = false;
        return isOnGhost;

    }

    @Override
    public boolean isOnFruit(){
        boolean isOnFruit = false;
        return isOnFruit;

    }
}