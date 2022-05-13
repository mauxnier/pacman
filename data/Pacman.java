package data;

import adding.Tuple2;

public class Pacman implements IPacman {

    private Tuple2<Integer, Integer> pos; // Position sur la grille
    private int lives; // Nombre de vies pour la partie
    private int points; // Nombre de points pour la partie

    /**
     * Constructeur de la classe.
     */
    public Pacman(int x, int y, int nbLives, int nbPoints) {
        this.pos.setFirst(x);
        this.pos.setSecond(y);
        this.lives = nbLives;
        this.points = nbPoints;
    }

    /**
     * Donne la position du pacman sur la grille de jeu.
     * @return position du pacman
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return null;
    }

    /**
     * Donne le nombre de vie restant pour le pacman.
     * @return nombre de vie
     */
    @Override
    public int getLives() {
        return 0;
    }

    /**
     * Donne le nombre de points accumulé par le pacman.
     *
     * @return nombre de points
     */
    @Override
    public int getPoints() {
        return 0;
    }
}