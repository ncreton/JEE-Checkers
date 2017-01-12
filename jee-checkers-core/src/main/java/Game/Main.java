package Game;

/**
 * Created by baptiste on 12/01/2017.
 */
public class Main {

    public static void main (String[] args) throws Exception {
        GameCheckersImpl gameCheckers =  new GameCheckersImpl();
        System.out.println(gameCheckers.getBoard());
        gameCheckers.movePawn(gameCheckers.getBoard(),3,0,4,1);
        gameCheckers.movePawn(gameCheckers.getBoard(),6,1,5,2);
        System.out.println(gameCheckers.getBoard());

    }
}
