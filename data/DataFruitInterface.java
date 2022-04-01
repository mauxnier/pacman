package data;

public interface DataFruitInterface {

    /**
    *Return */
    public int[2] getFruitsPos();

    public int getFruitValue(String fruitType);

    public int getNbFruits(); //num of fruits left
}