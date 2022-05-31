package data;

import adding.Tuple2;

public class Pacman implements IPacman {

    /** Constantes */
    private static final boolean DEFAULT_SUPERPOWER = false;

    /** Attributs */
    private int x; // Position en x dans le CSV
    private int y; // Position en y dans le CSV
    private int lives; // Nombre de vies pour la partie
    private int points; // Nombre de points pour la partie
    private boolean superpower; // Si pacman a mangé un superfruit

    /**
     * Constructeur de la classe.
     */
    public Pacman(int x, int y, int nbLives, int nbPoints) {
        this.x = x;
        this.y = y;
        this.lives = nbLives;
        this.points = nbPoints;
        this.superpower = DEFAULT_SUPERPOWER;
    }

    /**
     * Donne la position du pacman sur la grille de jeu.
     * @return position du pacman
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return new Tuple2<Integer, Integer>(this.x, this.y);
    }

    /**
     * Donne le nombre de vie restant pour le pacman.
     * @return nombre de vie
     */
    @Override
    public int getLives() {
        return this.lives;
    }

    /**
     * Donne le nombre de points accumulé par le pacman.
     * @return nombre de points
     */
    @Override
    public int getPoints() {
        return this.points;
    }
}