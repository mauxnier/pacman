package data;

import adding.Tuple2;
import adding.CSV;
import java.util.List;

public class Grid implements IGrid {
    /** Constantes pour le jeu */
    private static final int GAME_SPEED = 1;
    private static final int PACMAN_LIVES = 3;
    private static final int PACMAN_POINTS = 0;

    /** Attributs de la grille */
    private int level;
    private int speed;
    private Pacman pacman;
    private List<Wall> listeWall;
    private List<Fruit> listeFruit;
    private List<Ghost> listeGhost;

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
        String folderName = "data/src/";
        String fileName = folderName + "level_" + level + ".csv";
        List<List<String>> data = CSV.getCSV(fileName);

        /** Parcours de la liste de données */
        for (int i = 0; i < data.size(); i++) {
            List<String> line = data.get(i);
            for (int j = 0; j < line.size(); j++) {
                String block = line.get(j);
                int x = j;
                int y = i;

                switch (block) {
                    case "wall":
                        this.listeWall.add(new Wall(x, y));
                        break;
                    case "fruit":
                        this.listeFruit.add(new Fruit(x, y));
                        break;
                    case "superfruit":
                        break;
                    case "ghost":
                        break;
                    case "pacman":
                        break
                    default:
                        break;
                }
            }
        }
        System.out.println(data);
        return true;
    }
}