package logic;

/**
 * Classe Fruit de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Fruit extends Block implements IFruit {

    private data.Fruit dataFruit; // Données de base
    private boolean isEaten; // Si le fruit a été mangé

    /**
     * Constructeur de la classe.
     * @param dataFruit Données de base
     */
    public Fruit(data.Fruit dataFruit) {
        super(dataFruit);
        this.dataFruit = dataFruit;
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