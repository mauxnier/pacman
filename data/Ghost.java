package data;

import adding.Tuple2;

import java.awt.*;
import java.util.Random;

public class Ghost implements IGhost {

    /** Constantes */
    private static final int GHOST_POINTS = 200; //TODO *2 pour chaque ghost mangé en plus
    private static final String GHOST_NORMAL_BEHAVIOUR = "normal";
    private static final String GHOST_CREEP_BEHAVIOUR = "creep";

    /** Attributs */
    private int x;
    private int y;
    private Color color;
    private int points = GHOST_POINTS;
    private String behaviour = GHOST_NORMAL_BEHAVIOUR;

    /**
     * Constructeur de la classe.
     */
    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = getRandomColor();
    }

    /**
     * Donne la position du fantôme sur la grille de jeu.
     * @return position du fantôme
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return new Tuple2<Integer, Integer>(this.x, this.y);
    }

    /**
     * Donne la valeur en points du fantôme.
     * Utilisé quand il est mangé par le pacman.
     * @return points du fantôme
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * Donne la couleur du fantôme.
     * @return couleur du fantôme
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Retourne le comportement du fantôme.
     * @return comportement du fantôme
     */
    @Override
    public String getBehaviour() {
        return this.behaviour;
    }

    /**
     * Change le comportement du fantôme en normal.
     * @return void
     */
    public void setNormal() {
        this.behaviour = GHOST_NORMAL_BEHAVIOUR;
    }

    /**
     * Change le comportement du fantôme en creep.
     * @return void
     */
    public void setCreep() {
        this.behaviour = GHOST_CREEP_BEHAVIOUR;
    }

    /**
     * Retourne une couleur aléatoire
     * @return une couleur
     */
    private Color getRandomColor() {
        Random rand = new Random();
        Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        return randomColor.brighter();
    }
}