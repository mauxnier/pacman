import adding.Pos;

public class Game {
    public static void main(String[] args) {
        data.Game game = new data.Game(1);
        String bloc = game.getGrid().getBlock(new Pos(7, 13));
        System.out.println(bloc);
    }
}