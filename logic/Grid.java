package logic;

import adding.Pos;
import data.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Grid de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Grid implements IGrid {

    /** Constantes pour le jeu */
    public static final String WALL = data.Grid.WALL;
    public static final String FRUIT = data.Grid.FRUIT;
    public static final String SUPERFRUIT = data.Grid.SUPERFRUIT;
    public static final String GHOST = data.Grid.GHOST;
    public static final String PACMAN = data.Grid.PACMAN;
    public static final int GAME_SPEED = 1; // Vitesse du jeu

    /** Attributs */
    private data.Grid dataGrid;
    private int level; // Niveau du jeu
    private int speed; // Rapidité du jeu
    private int width; // Largeur de la grille
    private int height; // Hauteur de la grille
    private int nbFruitsLeft; // Nombre de fruits restants à manger
    private List<List<String>> board; // Position des blocs dans le jeu
    private Pacman pacman;
    private List<Wall> listeWall = new ArrayList<Wall>();
    private List<Fruit> listeFruit = new ArrayList<Fruit>();
    private List<Ghost> listeGhost = new ArrayList<Ghost>();

    /**
     * Constructeur de la classe.
     * @param dataGrid Données de base
     */
    public Grid(data.Grid dataGrid) {
        this.dataGrid = dataGrid;
        this.width = this.dataGrid.getWidth();
        this.height = this.dataGrid.getHeight();
        this.level = this.dataGrid.getLevel();
        this.speed = this.dataGrid.getSpeed();

        /** Création du Pacman */
        this.pacman = new Pacman(this.dataGrid.getPacman(), this);

        /** Création des murs */
        for (data.Wall dataWall : this.dataGrid.getWalls()) {
            listeWall.add(new Wall(dataWall, this));
        }

        /** Création des fruits */
        for (data.Fruit dataFruit : this.dataGrid.getFruits()) {
            listeFruit.add(new Fruit(dataFruit, this));
        }

        /** Création des fantômes */
        for (data.Ghost dataGhost : this.dataGrid.getGhosts()) {
            listeGhost.add(new Ghost(dataGhost, this));
        }
    }

    /**
     *
     * @param block
     */
    public void moveBlock(Block block) {
        Pos pos = block.getPos();
        switch (block) {
            case WALL:
                this.board.get(y).set(x, new data.Wall(WALL, x, y));
                break;
            case FRUIT:
            case SUPERFRUIT:
                this.board.get(y).set(x, new data.Fruit(FRUIT, x, y, block));
                break;
            case GHOST:
                this.board.get(y).set(x, new data.Ghost(GHOST, x, y));
                break;
            case PACMAN:
                this.pacman = new data.Pacman(PACMAN, x, y);
                this.board.get(y).set(x, this.pacman);
                break;
            default:
                System.out.println("Block inconnu : " + block);
                break;
        }
    }

    /**
     * Ajoute un bloc sur une position dans la grille.
     * @param block élément à placer sur la grille
     * @param pos la position dans la grille
     */
    private void setBlock(Block block, Pos pos) { //TODO passer le setblock en privé et faire une autre fonction replaceBlock
        this.board.get(pos.getY()).set(pos.getX(), block.getName());
    }

    /**
     * Retourne le bloc à une coordonnée précise sur la grille.
     * @param pos position x et y
     * @return le type de block
     */
    public String getBlock(Pos pos) {
        int x = pos.getX();
        int y = pos.getY();

        String block = null;
        if (x < this.width && y < this.height) {
            block = this.board.get(y).get(x);
        }
        return block;
    }

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    @Override
    public boolean isPosAWall(Pos pos) {
        boolean isPosAWall = false;
        String block = getBlock(pos);
        if (block == WALL) isPosAWall = true;
        return isPosAWall;
    }

    /**
     * Donne si la position donnée en paramètre correspond à un fruit.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un fruit
     */
    public boolean isPosAFruit(Pos pos) {
        boolean isPosAWall = false;
        String block = getBlock(pos);
        if (block == FRUIT) isPosAWall = true;
        return isPosAWall;
    }

    /**
     * Donne si la position donnée en paramètre correspond à un superfruit.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un superfruit
     */
    public boolean isPosASuperfruit(Pos pos) {
        boolean isPosAWall = false;
        String block = getBlock(pos);
        if (block == SUPERFRUIT) isPosAWall = true;
        return isPosAWall;
    }

    /**
     * Donne si la position donnée en paramètre correspond à un ghost.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un ghost
     */
    public boolean isPosAGhost(Pos pos) {
        boolean isPosAWall = false;
        String block = getBlock(pos);
        if (block == GHOST) isPosAWall = true;
        return isPosAWall;
    }

    /**
     * Donne si la position donnée en paramètre correspond à un pacman.
     * @param pos couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un pacman
     */
    public boolean isPosAPacman(Pos pos) {
        boolean isPosAWall = false;
        String block = getBlock(pos);
        if (block == PACMAN) isPosAWall = true;
        return isPosAWall;
    }

    /**
     * Retoure le reste de fruits à manger.
     * @return
     */
    public int updateNbFruitsLeft() {
        int nbFruits = 0;
        for (Fruit fruit : this.listeFruit) {
            nbFruits++;
        }
        return nbFruits;
    }

    @Override
    public int getNbFruitsLeft() {
        return this.nbFruitsLeft;
    }

    public data.Grid getDataGrid() {
        return this.dataGrid;
    }

    public int getLevel() {
        return this.level;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public List<List<String>> getBoard() {
        return this.board;
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public List<Wall> getWalls() {
        return this.listeWall;
    }

    public List<Fruit> getFruits() {
        return this.listeFruit;
    }

    public List<Ghost> getGhosts() {
        return this.listeGhost;
    }
}