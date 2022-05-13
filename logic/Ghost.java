package logic;

public class Ghost implements IGhost {

    Game game;
    boolean alive;
    data.Ghost dataGhost;

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

    }

    @Override
    public void eatPacman(Pacman eatedPacman){
        if (eatedPacman.isSuperpowered){
            die();
        }
        else {
            if (eatedPacman.nbLives > 1){
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