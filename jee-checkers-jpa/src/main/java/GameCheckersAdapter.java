/**
 * Created by nicolas on 23/01/2017.
 */

import Game.GameCheckers;
import Exception.GameException;
import Game.GameCheckersImpl;


public class GameCheckersAdapter implements GameCheckers {

    private GameCheckers gameCheckers;
    private GameCheckersJPA gameCheckersJPA;
    private GameCheckersDAO gameCheckersDAO;

    public GameCheckersAdapter(GameCheckersJPA gameCheckersJPA, GameCheckersDAO gameCheckersDAO) throws GameException {
        this.gameCheckersJPA = gameCheckersJPA;
        this.gameCheckersDAO = gameCheckersDAO;
        this.gameCheckers = new GameCheckersImpl(10, 10, "Player1", "Player2");
    }

    @Override
    public void play(int originRow, int originCol, int destRow, int destCol) throws GameException {

    }
}
