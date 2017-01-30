package jpa;

import Game.GameCheckers;
import Exception.*;
import Game.GameCheckersImpl;
import Model.Board;

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

        for (Turn turn : gameCheckersJPA.getTurns()){
            gameCheckersCore.play(turn.getOriginRow(), turn.getOriginCol(), turn.getDestRow(), turn.getDestCol());
        }
    }

    public GameCheckersAdapter(GameCheckersDAO checkersDAO, GameCheckersJPA gameCheckersJPA) throws GameException {
        this(checkersDAO, gameCheckersJPA, 10, 10, "Player 1", "Player 2");
    }

    @Override
    public void play(int originRow, int originCol, int destRow, int destCol) throws GameException {
        gameCheckersCore.play(originRow, originCol, destRow, destCol);

        gameCheckersJPA.getTurns().add(new Turn(this.gameCheckersJPA, originRow, originCol, destRow, destCol));

        checkersDAO.saveGame(gameCheckersJPA);
    }

    public String getToken(){
        return gameCheckersJPA.getToken();
    }

    @Override
    public Board getBoard(){
        return gameCheckersCore.getBoard();
    }

    public void delete(){
        checkersDAO.deleteGame(this.gameCheckersJPA);
    }

    public GameCheckersImpl getGameCheckersCore() {
        return gameCheckersCore;
    }
}
