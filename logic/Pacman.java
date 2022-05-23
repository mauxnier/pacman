package logic;


import adding.Tuple2;

public class Pacman implements IPacman {

    private Grid grid;
    private Game game;
    data.Pacman dataPacman;
    private int nbLives;
    private boolean isSuperpowered;

    /**
     * Constructeur de la classe.
     */
    public Pacman(Grid grid, data.Pacman dataPacman) {
        this.grid = grid;
        this.nbLives = dataPacman.getLives();
        isSuperpowered = false;
        game = grid.game;

    }

    @Override
    public void move(String direction){
        boolean isCorrectDirection = true;
        Tuple2<Integer, Integer> newPos;
        int actualPosX = dataPacman.getPos().getFirst();
        int actualPosY = dataPacman.getPos().getSecond();
        switch(direction){
            case "UP": 
                newPos = new Tuple2<Integer,Integer>(actualPosX+1, actualPosY);
                break;
        
            case "DOWN":
                newPos = new Tuple2<Integer,Integer>(actualPosX-1, actualPosY);
                break;
        
            case "RIGHT":
                newPos = new Tuple2<Integer,Integer>(actualPosX, actualPosY+1);
                break;

            case "LEFT":
                newPos = new Tuple2<Integer,Integer>(actualPosX, actualPosY-1);
                break;
            default:
                System.out.println("Direction incorrecte");
                isCorrectDirection = false;
                break;
        }
        if (!grid.dataGrid.isPosAWall(newPos) && isCorrectDirection){
            dataPacman.setDirection(direction);
        }
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

    public boolean isSuperpowered(){
        return isSuperpowered;
    }

    public int getNbLives(){
        return nbLives;
    }
}