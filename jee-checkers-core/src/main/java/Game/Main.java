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
        //gameCheckers.movePawn(3,0,4,1);
        //gameCheckers.movePawn(6,1,5,2);
        //System.out.println(gameCheckers.getBoard());

        //Take a pawn
        //IMPOSSIBLE gameCheckers.movePawn(gameCheckers.getBoard(),3,2,5,0);
        //gameCheckers.movePawn(5,2,3,0);
        //System.out.println(gameCheckers.getBoard());

        //Scenario to get a queen (O -> Q)
        gameCheckers.movePawn(6,1,5,0);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(3,2,4,3);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(5,0,4,1);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(2,3,3,2);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(4,1,2,3);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(2,1,3,2);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(1,0,2,1);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(0,1,1,0);
        System.out.println(gameCheckers.getBoard());

        gameCheckers.movePawn(2,3,0,1);
        System.out.println(gameCheckers.getBoard());

        //Queen Move
        //Good move
        gameCheckers.movePawn(0,1,5,6);
        System.out.println(gameCheckers.getBoard());

        //Bad move (TODO: Exception for moves)
        //gameCheckers.movePawn(0,1,6,7);
        //System.out.println(gameCheckers.getBoard());
    }
}
