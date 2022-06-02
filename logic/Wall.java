package logic;

/**
 * Classe Wall de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Wall extends Block {

    /**
     * Constructeur de la classe.
     * @param dataWall données de base
     * @param grid Grille de jeu
     */
    public Wall(data.Wall dataWall, Grid grid) {
        super(dataWall, grid);
    }
}