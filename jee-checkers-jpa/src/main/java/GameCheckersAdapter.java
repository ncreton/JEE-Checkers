import Game.GameCheckers;
import Exception.*;
import Game.GameCheckersImpl;

/**
 * Created by nicolas on 23/01/2017.
 */

public class GameCheckersAdapter implements GameCheckers {

    private GameCheckersJPA gameCheckersJPA;
    private GameCheckersImpl gameCheckersCore;
    private GameCheckersDAO checkersDAO;

    public GameCheckersAdapter(GameCheckersDAO checkersDAO, GameCheckersJPA gameCheckersJPA) throws GameException {
        this.gameCheckersJPA = gameCheckersJPA;
        this.checkersDAO = checkersDAO;
        this.gameCheckersCore = new GameCheckersImpl();
    }

    @Override
    public void play(int originRow, int originCol, int destRow, int destCol) throws GameException {

    }

    public String getToken(){
        return gameCheckersJPA.getToken();
    }
}
