package logic;

/**
 * Classe Wall de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Wall extends Block {

    private data.Wall dataWall;

    /**
     * Constructeur de la classe.
     * @param dataWall données de base
     */
    public Wall(data.Wall dataWall) {
        super(dataWall);
        this.dataWall = dataWall;
    }

    /**
     * Retourne les données de base du mur.
     * @return dataWall
     */
    public data.Wall getDataWall() {
        return dataWall;
    }
}