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
    public static final int GAME_SPEED = 1; // Vitesse du jeu

    /** Attributs de la grille */
    private int level; // Niveau du jeu
    private int speed; // Rapidité du jeu
    private int width; // Largeur de la grille
    private int height; // Hauteur de la grille
    private List<List<String>> data; // Données du CSV
    private List<List<Block>> board = new ArrayList<List<Block>>(); // Plateau de jeu

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
     * Retourne la largeur
     * @return width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Retourne la hauteur.
     * @return height
     */
    public int getHeight() {
        return this.height;
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
     * Retourne
     * @return pacman
     */
    public List<List<Block>> getBoard() {
        return this.board;
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
}