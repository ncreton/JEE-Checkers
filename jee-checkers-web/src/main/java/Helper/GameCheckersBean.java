package Helper;

import Game.GameCheckersImpl;
import jpa.GameCheckersAdapter;
import jpa.GameCheckersDAO;
import Exception.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by nicolas on 30/01/2017.
 */
@Named("gameCheckersJPA")
@RequestScoped
public class GameCheckersBean implements Serializable{

    GameCheckersAdapter checkersAdapter;

    @Inject
    GameCheckersDAO checkersDAO;

    public void play(int originRow, int originCol, int destRow, int destCol) throws GameException {
        checkersAdapter.play(originRow, originCol, destRow, destCol);
    }

    public GameCheckersAdapter getCheckersAdapter() {
        return checkersAdapter;
    }

    public void createNewGame() throws GameException {
        checkersAdapter = checkersDAO.createNewGame();
    }

    public void createNewGame(int row, int col, String player1, String player2) throws GameException {
        checkersAdapter = checkersDAO.createNewGame(row, col, player1, player2);
    }

    public String getToken(){
        return checkersAdapter.getToken();
    }

    public void loadFromToken(String token) throws GameException {
        checkersAdapter = checkersDAO.loadFromToken(token);
    }

    public GameCheckersImpl getGameChecker(){
        return checkersAdapter.getGameCheckersCore();
    }
}
