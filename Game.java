public class Game {
    public static void main(String[] args) {
        data.Game dataGame = new data.Game(1);
        logic.Game logicGame = new logic.Game(dataGame);
        view.Game viewGame = new view.Game(logicGame);
        viewGame.displayBoard();

        //String bloc = game.getGrid().getBlock(new Pos(7, 13));
        //System.out.println(bloc);


    }
}