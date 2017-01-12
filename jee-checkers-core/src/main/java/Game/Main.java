package Game;

/**
 * Created by baptiste on 12/01/2017.
 */
public class Main {

    public static void main (String[] args){
        GameCheckersImpl gameCheckers =  new GameCheckersImpl();
        System.out.println(gameCheckers.getBoard());
    }
}
