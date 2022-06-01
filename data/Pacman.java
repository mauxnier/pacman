package data;

/**
 * Classe Pacman de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Pacman extends Block implements IPacman {

    /** Constantes */
    private static final boolean DEFAULT_SUPERPOWER = false; // Si pacman peut manger les fantômes
    private static final int DEFAULT_LIVES = 3; // Vies de base du pacman
    private static final int DEFAULT_POINTS = 0; // Points de base du pacman
    private static final int DEFAULT_POWER_DURATION = 10; // Durée du pouvoir de pacman en seconde après avoir mangé le superfruit //TODO pour les niveaux supérieurs le temps doit s'écourter

    /** Attributs */
    private int lives; // Nombre de vies pour la partie
    private int points; // Nombre de points pour la partie
    private boolean superpower; // Si pacman a mangé un superfruit

    /**
     * Constructeur de la classe.
     * @param name nom du bloc pacman dans le CSV
     * @param x position dans le CSV
     * @param y position dans le CSV
     */
    public Pacman(String name, int x, int y) {
        super(name, x, y);
        this.lives = DEFAULT_LIVES;
        this.points = DEFAULT_POINTS;
        this.superpower = DEFAULT_SUPERPOWER;
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