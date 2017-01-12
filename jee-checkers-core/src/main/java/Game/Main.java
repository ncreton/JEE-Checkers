package Game;

/**
 * Created by baptiste on 12/01/2017.
 */
public class Main {

    public static void main (String[] args) throws Exception {
        GameCheckersImpl gameCheckers =  new GameCheckersImpl();

        //Init game
        System.out.println(gameCheckers.getBoard());

        //Simple moves
        gameCheckers.movePawn(3,0,4,1);
        gameCheckers.movePawn(6,1,5,2);
        System.out.println(gameCheckers.getBoard());

        //Take a pawn
        //IMPOSSIBLE gameCheckers.movePawn(gameCheckers.getBoard(),3,2,5,0);
        gameCheckers.movePawn(5,2,3,0);
        System.out.println(gameCheckers.getBoard());

    }
}
