package logic;

public class Fruit implements IFruit {

    Game game;
    data.Fruit dataFruit;
    boolean isEaten;

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