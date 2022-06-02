package logic;

import adding.Tuple2;

/**
 * Classe Pacman de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Pacman extends Block implements IPacman {

    private int lives; // Nombre de vies pour la partie
    private int points; // Nombre de points pour la partie
    private boolean isSuperpowered; // Si pacman a mangé un superfruit

    /**
     * Constructeur de la classe.
     * @param dataPacman données de base
     * @param grid Grille de jeu
     */
    public Pacman(data.Pacman dataPacman, Grid grid) {
        super(dataPacman, grid);
        this.lives = dataPacman.getLives();
        this.points = dataPacman.getPoints();
        this.isSuperpowered = dataPacman.getIsSuperpowered();
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

    /**
     * Retourne un nombre de points.
     * @return points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Définie un nombre de points.
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Ajoute des points.
     * @param points
     */
    public void addPoints(int points){
        this.points += points;
    }
}