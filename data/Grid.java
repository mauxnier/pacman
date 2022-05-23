package data;

import adding.Tuple2;

import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Grid implements IGrid {
    /** Constantes pour le jeu */
    static final int GAME_SPEED = 1;
    static final int PACMAN_LIVES = 3;
    static final int PACMAN_POINTS = 0;

    private int level;
    private int speed;
    private Pacman pacman;
    private Fruit[] listeFruit;
    private Ghost[] listeGhost;

    /**
     * Constructeur de la classe.
     * @param level
     */
    public Grid(int level) {
        this.level = level;
        this.speed = GAME_SPEED;
        loadLevel(level);
        // this.pacman = new Pacman(x_pos, y_pos, PACMAN_LIVES, PACMAN_POINTS);

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

    /**
     * Charge le niveau du jeu avec un des CSV du dossier src/
     * @param level
     * @return si le niveau est bien chargé
     */
    private boolean loadLevel(int level) {
        try (CSVReader reader = new CSVReader(new FileReader("file.csv"))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }
        return true;
    }
}