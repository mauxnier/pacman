package data;

import adding.Pos;
import adding.CSV;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Grid de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Grid implements IGrid {

    /** Constantes pour le jeu */
    public static final String WALL = "wall";
    public static final String FRUIT = "fruit";
    public static final String SUPERFRUIT = "superfruit";
    public static final String GHOST = "ghost";
    public static final String PACMAN = "pacman";

    private static final int GAME_SPEED = 1; // Vitesse du jeu

    /** Attributs de la grille */
    private int level; // Niveau du jeu
    private int speed; // Rapidité du jeu
    private int width; // Largeur de la grille
    private int height; // Hauteur de la grille
    private List<List<String>> data; // Données du CSV
    private Pacman pacman;
    private List<Wall> listeWall = new ArrayList<Wall>();
    private List<Fruit> listeFruit = new ArrayList<Fruit>();
    private List<Ghost> listeGhost = new ArrayList<Ghost>();

    /**
     * Constructeur de la classe.
     * @param level
     */
    public Grid(int level) {
        this.level = level;
        this.speed = GAME_SPEED;
        loadLevel();
    }

    /**
     * Ajoute un bloc sur une position dans la grille.
     * @param block élément à placer sur la grille
     */
    public void setBlock(Block block) {
        Pos pos = block.getPos();
        this.data.get(pos.getY()).set(pos.getX(), block.getName());
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
            block = this.data.get(y).get(x);
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
     * Charge le niveau du jeu avec un des CSV du dossier src/
     * @return si le niveau est bien chargé
     */
    private boolean loadLevel() {
        String folderName = "data/src/";
        String fileName = folderName + "level_" + this.level + ".csv";
        List<List<String>> data = CSV.getCSV(fileName);
        this.data = data;
        // Largeur et hauteur pour un niveau carré
        this.width = data.size();
        this.height = data.get(0).size();

        /** Parcours de la liste de données */
        for (int i = 0; i < data.size(); i++) {
            List<String> line = data.get(i);
            for (int j = 0; j < line.size(); j++) {
                String block = line.get(j);
                int x = j;
                int y = i;

                switch (block) {
                    case WALL:
                        this.listeWall.add(new Wall(WALL, x, y));
                        break;
                    case FRUIT:
                    case SUPERFRUIT:
                        this.listeFruit.add(new Fruit(FRUIT, x, y, block));
                        break;
                    case GHOST:
                        this.listeGhost.add(new Ghost(GHOST, x, y));
                        break;
                    case PACMAN:
                        this.pacman = new Pacman(PACMAN, x, y);
                        break;
                    default:
                        System.out.println("Block inconnu : " + block);
                        break;
                }
            }
        }
        // System.out.println(data);
        return true;
    }

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    @Override
    public int getLevel() {
        return this.level;
    }

    /**
     * Donne la vitesse du niveau de jeu.
     * @return vitesse du jeu
     */
    @Override
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Retourne le pacman du jeu.
     * @return pacman
     */
    @Override
    public Pacman getPacman() {
        return this.pacman;
    }

    /**
     * Retourne les fantômes du jeu.
     * @return fantômes
     */
    @Override
    public List<Ghost> getGhosts() {
        return this.listeGhost;
    }

    /**
     * Retourne les fruits du jeu.
     * @return fruits
     */
    @Override
    public List<Fruit> getFruits() {
        return this.listeFruit;
    }

    /**
     * Retourne les murs du jeu.
     * @return murs
     */
    @Override
    public List<Wall> getWalls() {
        return this.listeWall;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<List<String>> getData() {
        return data;
    }
}