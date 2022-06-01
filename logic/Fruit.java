package logic;

/**
 * Classe Fruit de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Fruit implements IFruit {

    private Game game;
    data.Fruit dataFruit;
    private boolean isEaten;

    /**
     * Constructeur de la classe.
     */
    public Fruit(Game game, data.Fruit dataFruit) {
        this.game = game;
        isEaten = false;
        this.dataFruit = dataFruit;
    }

    @Override
    public boolean isEaten(){
        return isEaten;
    }

    @Override
    public void disappear(){
        isEaten = true;
    }
}