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

    public GameCheckersAdapter(GameCheckersDAO checkersDAO, GameCheckersJPA gameCheckersJPA, int row, int col, String player1, String player2) throws GameException {
        this.gameCheckersJPA = gameCheckersJPA;
        this.checkersDAO = checkersDAO;
        this.gameCheckersCore = new GameCheckersImpl(row, col, player1, player2);
    }

    public GameCheckersAdapter(GameCheckersDAO checkersDAO, GameCheckersJPA gameCheckersJPA) throws GameException {
        this.gameCheckersJPA = gameCheckersJPA;
        this.checkersDAO = checkersDAO;
        this.gameCheckersCore = new GameCheckersImpl();
    }

    @Override
    public void play(int originRow, int originCol, int destRow, int destCol) throws GameException {
        gameCheckersCore.play(originRow, originCol, destRow, destCol);
    }

    public String getToken(){
        return gameCheckersJPA.getToken();
    }
}
