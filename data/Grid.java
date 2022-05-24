package data;

import adding.Tuple2;
import adding.CSV;

import java.util.ArrayList;
import java.util.List;

public class Grid implements IGrid {

    /** Constantes pour le jeu */
    private static final int GAME_SPEED = 1; // Vitesse du jeu
    private static final int PACMAN_LIVES = 3; // Vies de base du pacman
    private static final int PACMAN_POINTS = 0; // Points de base du pacman
    private static final int PACMAN_POWER_DURATION = 10; // Durée du pouvoir de pacman en seconde après avoir mangé le superfruit
    //TODO pour les niveaux supérieurs le temps doit s'écourter
    private static final String WALL = "wall";
    private static final String FRUIT = "fruit";
    private static final String SUPERFRUIT = "superfruit";
    private static final String GHOST = "ghost";
    private static final String PACMAN = "pacman";

    /** Attributs de la grille */
    private int level;
    private int speed;
    private List<List<String>> data;
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
        loadLevel(level);
    }

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param coords couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    @Override
    public boolean isPosAWall(Tuple2<Integer, Integer> coords) {
        return false;
    }

    //TODO getBlock(int x, int y)
    //TODO isPosAFruit
    //TODO isPosAGhost
    //TODO isPosAPacman


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

    /**
     * Charge le niveau du jeu avec un des CSV du dossier src/
     * @param level
     * @return si le niveau est bien chargé
     */
    private boolean loadLevel(int level) {
        String folderName = "data/src/";
        String fileName = folderName + "level_" + level + ".csv";
        List<List<String>> data = CSV.getCSV(fileName);
        this.data = data;

        /** Parcours de la liste de données */
        for (int i = 0; i < data.size(); i++) {
            List<String> line = data.get(i);
            for (int j = 0; j < line.size(); j++) {
                String block = line.get(j);
                int x = j;
                int y = i;

                switch (block) {
                    case WALL:
                        this.listeWall.add(new Wall(x, y));
                        break;
                    case FRUIT:
                    case SUPERFRUIT:
                        this.listeFruit.add(new Fruit(x, y, block));
                        break;
                    case GHOST:
                        this.listeGhost.add(new Ghost(x, y));
                        break;
                    case PACMAN:
                        this.pacman = new Pacman(x, y, PACMAN_LIVES, PACMAN_POINTS);
                        break;
                    default:
                        System.out.println("Block inconnu : " + block);
                        break;
                }
            }
        }
        System.out.println(data);
        return true;
    }
}