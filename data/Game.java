package data;

public class Game implements IGame { // TODO reprendre les fonctions du game de logic (end level et levelup) celle de logic appeleront celle de data

    private int level; // Niveau de jeu
    private Grid grid; // Grille du jeu

    /**
     * Constructeur de la classe.
     */
    public Game(int level) {
        this.level = level;
        this.grid = createLevel(level);
    }

    /**
     * Lance le jeu.
     */
    @Override
    public void start() {

    }

    /**
     * Stop le jeu.
     */
    @Override
    public void over() {

    }

    /**
     * Créer le niveau de jeu.
     */
    @Override
    public Grid createLevel(int level) {
        return new Grid(level);
    }

    /**
     * Donne le niveau du jeu.
     * @return niveau de jeu
     */
    @Override
    public int getLevel() {
        return 0;
    }

    /**
     * Donne la vitesse du niveau de jeu.
     * @return vitesse du jeu
     */
    @Override
    public int getSpeed() {
        return 0;
    }

    /**
     * Retourne la grille du jeu.
     * @return grille du jeu
     */
    @Override
    public Grid getGrid() {
        return null;
    }

    /**
     * Retourne le pacman du jeu.
     * @return pacman
     */
    @Override
    public Pacman getPacman() {
        return null;
    }

    /**
     * Retourne les fantômes du jeu.
     * @return fantômes
     */
    @Override
    public Ghost[] getGhosts() {
        return new Ghost[0];
    }

    /**
     * Retourne les fruits du jeu.
     * @return fruits
     */
    @Override
    public Fruit[] getFruits() {
        return new Fruit[0];
    }
}