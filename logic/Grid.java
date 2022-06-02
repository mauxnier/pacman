package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Grid de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Grid implements IGrid {

    private data.Grid dataGrid;
    private int level; // Niveau du jeu
    private int speed; // Rapidité du jeu
    private List<List<String>> board; // Position des blocs dans le jeu
    private Pacman pacman;
    private List<Wall> listeWall = new ArrayList<Wall>();
    private List<Fruit> listeFruit = new ArrayList<Fruit>();
    private List<Ghost> listeGhost = new ArrayList<Ghost>();

    /**
     * Constructeur de la classe.
     * @param dataGrid Données de base
     */
    public Grid(data.Grid dataGrid) {
        this.dataGrid = dataGrid;
        this.level = this.dataGrid.getLevel();
        this.speed = this.dataGrid.getSpeed();

        /** Création du Pacman */
        this.pacman = new Pacman(this.dataGrid.getPacman(), this);

        /** Création des murs */
        for (data.Wall dataWall : this.dataGrid.getWalls()) {
            listeWall.add(new Wall(dataWall, this));
        }

        /** Création des fruits */
        for (data.Fruit dataFruit : this.dataGrid.getFruits()) {
            listeFruit.add(new Fruit(dataFruit, this));
        }

        /** Création des fantômes */
        for (data.Ghost dataGhost : this.dataGrid.getGhosts()) {
            listeGhost.add(new Ghost(dataGhost, this));
        }
    }

    @Override
    public int getNbFruitsLeft() {
        return nbFruitsLeft; //TODO
    }
}