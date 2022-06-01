package data;

import adding.Tuple2;

import java.awt.*;
import java.util.Random;

public class Ghost extends Block implements IGhost {

    /** Constantes */
    private static final int GHOST_POINTS = 200; //TODO x2 pour chaque ghost mangé en plus
    private static final String GHOST_NORMAL_BEHAVIOUR = "normal";
    private static final String GHOST_CREEP_BEHAVIOUR = "creep";

    /** Attributs */
    private Color color; // Couleur du fantôme
    private int points; // Points que vaut le fantôme quand mangé par pacman
    private String behaviour; // Comportement du fantôme en fonction de si pacman a mangé un superfruit

    /**
     * Constructeur de la classe.
     * @param name nom du bloc fantôme dans le CSV
     * @param x position dans le CSV
     * @param y position dans le CSV
     */
    public Ghost(String name, int x, int y) {
        super(name, x, y);
        this.color = getRandomColor();
        this.points = GHOST_POINTS;
        this.behaviour = GHOST_NORMAL_BEHAVIOUR;
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
     */
    public void setNormal() {
        this.behaviour = GHOST_NORMAL_BEHAVIOUR;
    }

    /**
     * Change le comportement du fantôme en creep.
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