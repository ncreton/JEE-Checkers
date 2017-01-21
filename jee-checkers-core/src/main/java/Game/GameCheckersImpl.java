package Game;

import Exception.GameException;
import Model.Board;
import Model.Cell;
import Model.Color;
import Model.PawnType;
import Player.Player;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class GameCheckersImpl implements GameCheckers {

    private Board board;

    public GameCheckersImpl() {
        this(10, 10, "Player 1", "Player 2");
    }

    public GameCheckersImpl(int rows, int columns, String playerName1, String playerName2) {
        try {
            this.board = new Board(rows, columns, playerName1, playerName2);
        } catch (GameException g) {

        }
    }

    public Board getBoard() {
        return this.board;
    }

    @Override
    public void play(int originRow, int originCol, int destRow, int destCol) throws GameException {
        if(board.getLastPlayer() != board.getCurrentPlayer()) {
            try{
                movePawn(originRow, originCol, destRow, destCol);
                board.switchPlayer();
            } catch (GameException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to move the pawn based on the origin cell and the destination cell
     *
     * @param originRow
     * @param originCol
     * @param destRow
     * @param destCol
     * @throws GameException
     */
    public void movePawn(int originRow, int originCol, int destRow, int destCol) throws GameException {
        Cell originCell = null;
        Cell destCell = null;

        //Check if the pawn is not outside the board
        if (board.isCoordinateInTheBoard(originRow, originCol) && board.isCoordinateInTheBoard(destRow, destCol)){
            originCell = board.getCell(originRow, originCol);
            destCell = board.getCell(destRow, destCol);
        }else {
            throw new GameException("Coordinate are out of the board");
        }

        //Check if the selected cell contains pawn and try to move
        if (originCell.hasPawn() && !destCell.hasPawn()) {
            if (originCell.getPawn().getPawnType() == PawnType.NORMAL) {
                try{
                    Move normalMove = new NormalMove(board);
                    normalMove.move(board.getOpponentPlayer(), originCell, destCell);
                } catch (GameException e) {
                    e.printStackTrace();
                }
            } else if (originCell.getPawn().getPawnType() == PawnType.QUEEN) {
                try {
                    Move queenMove = new QueenMove(board);
                    queenMove.move(board.getOpponentPlayer(), originCell, destCell);
                } catch (GameException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new GameException("Cell does not contains pawn");
        }
    }
}
