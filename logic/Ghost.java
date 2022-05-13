package logic;

import adding.Tuple2;

public class Ghost implements IGhost {

    private Game game;
    private boolean alive;
    private data.Ghost dataGhost;

    /**
     * Constructeur de la classe.
     */
    public Ghost(Game game, data.Ghost dataGhost) {
        this.game = game;
        alive = true;
        this.dataGhost = dataGhost;

    }

    @Override
    public void move(){
        Tuple2<Integer, Integer> newPos = null;
        while(alive == true){
            boolean isMoved = false;

            int pacmanPosX = game.pacman.dataPacman.getPos().getFirst();
            int pacmanPosY = game.pacman.dataPacman.getPos().getSecond();

            int actualPosX = dataGhost.getPos().getFirst();
            int actualPosY = dataGhost.getPos().getSecond();

            
            
            int distanceX = pacmanPosX - actualPosX;
            int distanceY = pacmanPosY - actualPosY;

            if (game.pacman.getIsSuperpowered() == true){
                distanceX *= -1;
                distanceY *= -1;
            }

            if (Math.abs(distanceX) > Math.abs(distanceY)){
                if (distanceX > 0){
                    newPos = new Tuple2<Integer,Integer>(actualPosX+1, actualPosY);
                    if(!Grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("UP");
                    }
                }
                else {
                    newPos = new Tuple2<Integer,Integer>(actualPosX-1, actualPosY);
                    if(!Grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("DOWN");
                    }        
                }
            }
            else {
                if (distanceY > 0){
                    newPos = new Tuple2<Integer,Integer>(actualPosX, actualPosY+1);
                    if(!Grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("RIGHT");
                    }
                }
                else {
                    newPos = new Tuple2<Integer,Integer>(actualPosX, actualPosY-1);
                    if(!Grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("LEFT");
                    }  
                }
            }
            if (newPos == null){
                switch(dataGhost.getDirection()){
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
                }
            }
            dataGhost.setPos(newPos);
        }
    }

    @Override
    public void eatPacman(Pacman eatedPacman){
        if (eatedPacman.getIsSuperpowered()){
            die();
        }
        else {
            if (eatedPacman.getNbLives() > 1){
                eatedPacman.hurt();
            }
            else {
                eatedPacman.die();
            }
        }
    }

    @Override
    public void die(){
        alive = false;
    }
}