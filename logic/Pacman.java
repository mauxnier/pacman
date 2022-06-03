package logic;

import adding.Pos;

import static logic.Grid.PACMAN;
import static logic.Grid.GHOST;
import static logic.Grid.WALL;
import static logic.Grid.FRUIT;
import static logic.Grid.SUPERFRUIT;

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
    private data.Pacman dataPacman;

    /**
     * Constructeur de la classe.
     * @param dataPacman données de base
     * @param grid Grille de jeu
     */
    public Pacman(data.Pacman dataPacman, Grid grid) {
        super(dataPacman, grid);
        this.dataPacman = dataPacman;
        this.lives = dataPacman.getLives();
        this.points = dataPacman.getPoints();
        this.isSuperpowered = dataPacman.getIsSuperpowered();
    }

    /**
     * Retourne les données de base.
     * @return data
     */
    public data.Pacman getDataBlock() {
        return this.dataPacman;
    }

    /**
     * Déplace le pacman.
     * @param direction
     */
    @Override
    public void move(String direction) {
        int actualPosX = this.getPos().getX();
        int actualPosY = this.getPos().getY();
        int newPosX;
        int newPosY;

        switch (direction) {
            case "UP": 
                newPosX = actualPosX;
                newPosY = actualPosY - 1;
                this.canMove(newPosX, newPosY);
                break;
        
            case "DOWN":
                newPosX = actualPosX;
                newPosY = actualPosY + 1;
                this.canMove(newPosX, newPosY);
                break;
        
            case "RIGHT":
                newPosX = actualPosX + 1;
                newPosY = actualPosY;
                this.canMove(newPosX, newPosY);
                break;

            case "LEFT":
                newPosX = actualPosX - 1;
                newPosY = actualPosY;
                this.canMove(newPosX, newPosY);
                break;
            default:
                System.out.println("Direction incorrecte");
                break;
        }
        if (!grid.dataGrid.isPosAWall(newPos) && isCorrectDirection){
            dataPacman.setDirection(direction);
        }
    }

    @Override
    public void eatFruit(Fruit eatedFruit){
        eatedFruit.disappear();
        int fruitValue = eatedFruit.getDataBlock().getPoints();
        this.addPoints(fruitValue);
    }

    @Override
    public void eatGhost(Ghost eatedGhost){
        eatedGhost.die();
        int ghostValue = eatedGhost.getDataBlock().getPoints();
        this.addPoints(ghostValue);
    }

    @Override
    public void superpower() {
        this.isSuperpowered = true;
    }

    @Override
    public void hurt() {
        this.lives--;
    }

    @Override
    public void die() {
        this.getGrid()..endLevel();
    }

    @Override
    public boolean isOnGhost(){
        boolean isOnGhost = false;
        return isOnGhost;
    }

    @Override
    public boolean isOnFruit() {
        boolean isOnFruit = false;
        return isOnFruit;
    }

    public boolean isSuperpowered() {
        return this.isSuperpowered;
    }

    public int getLives(){
        return this.lives;
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

    /**
     * Permet de savoir comment bouge le pacman.
     * @param newPosX position sur la grille
     * @param newPosY position sur la grille
     * @return
     */
    private boolean canMove(int newPosX, int newPosY) {
        boolean canMove = false;
        String block = this.getGrid().getBlock(new Pos(newPosX, newPosY));

        switch (block) {
            case WALL:
            case PACMAN:
                /** Bloqué */
                canMove = false;
                break;
            case FRUIT:
            case SUPERFRUIT:
                /** Peut bouger et manger */
                canMove = true;
                eatFruit(get);
                break;
            case GHOST:
                /** Peut bouger et manger ou se fait manger */
                break;
            default:
                /** Peut bouger */
                canMove = true;
                break;
        }
        return canMove;
    }
}