package logic;

import adding.Tuple2;

/**
 * Classe Ghost de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Ghost extends Block implements IGhost {

    private data.Ghost dataGhost;
    private boolean isAlive;


    /**
     * Constructeur de la classe.
     * @param dataGhost Données de base
     * @param grid Grille de jeu
     */
    public Ghost(data.Ghost dataGhost, Grid grid) {
        super(dataGhost, grid);
        this.dataGhost = dataGhost;
        this.isAlive = true;
    }

    /**
     * Retourne les données de base.
     * @return data
     */
    public data.Ghost getDataBlock() {
        return this.dataGhost;
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

            if (game.pacman.isSuperpowered() == true){
                distanceX *= -1;
                distanceY *= -1;
            }

            if (Math.abs(distanceX) > Math.abs(distanceY)){
                if (distanceX > 0){
                    newPos = new Tuple2<Integer,Integer>(actualPosX+1, actualPosY);
                    if(!grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("UP");
                    }
                }
                else {
                    newPos = new Tuple2<Integer,Integer>(actualPosX-1, actualPosY);
                    if(!grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("DOWN");
                    }        
                }
            }
            else {
                if (distanceY > 0){
                    newPos = new Tuple2<Integer,Integer>(actualPosX, actualPosY+1);
                    if(!grid.dataGrid.isPosAWall(newPos)){
                        dataGhost.setDirection("RIGHT");
                    }
                }
                else {
                    newPos = new Tuple2<Integer,Integer>(actualPosX, actualPosY-1);
                    if(!grid.dataGrid.isPosAWall(newPos)){
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
        if (eatedPacman.isSuperpowered()){
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