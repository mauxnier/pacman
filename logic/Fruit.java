package logic;

/**
 * Classe Fruit de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Fruit extends Block implements IFruit {

    private boolean isEaten; // Si le fruit a été mangé
    private data.Fruit dataFruit;

    /**
     * Constructeur de la classe.
     * @param dataFruit Données de base
     * @param grid Grille de jeu
     */
    public Fruit(data.Fruit dataFruit, Grid grid) {
        super(dataFruit, grid);
        this.dataFruit = dataFruit;
    }

    /**
     * Retourne les données de base.
     * @return data
     */
    public data.Fruit getDataBlock() {
        return this.dataFruit;
    }

    @Override
    public boolean isEaten() {
        return isEaten;
    }

    @Override
    public void disappear() {
        isEaten = true;
    }
}