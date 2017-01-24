package Game;

import Exception.GameException;
import Model.Board;
import Model.Cell;
import Model.Color;
import Player.Player;

/**
 * Created by nicolas on 13/01/2017.
 */
public class NormalMove extends Move {

    public NormalMove(Board board) {
        super(board);
    }

    /**
     * Method to move the normal pawn
     *
     * @param originCell
     * @param destCell
     * @throws GameException
     */
    public void move(Player opponentPlayer, Cell originCell, Cell destCell) throws GameException {
        if (isMoveAuthorized(originCell, destCell)) {
            takePawnDuringMove(originCell, destCell);
            board.swapPawn(originCell, destCell);
            board.switchPlayer();
            changePawnToQueen(destCell.getRowIndex(), destCell.getColIndex());
        } else {
            throw new GameException("Movement not authorized");
        }
    }

    /**
     * Check if the normal pawn's move is authorized
     * Only in a square of +-1 or +-2
     * In the right direction for the black or white pawns
     *
     * @param originCell
     * @param destCell
     * @throws GameException
     */
    @Override
    public boolean isMoveAuthorized(Cell originCell, Cell destCell) throws GameException {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();
        Color color = originCell.getPawn().getPawnColor();

        if (color == Color.BLACK && board.getCurrentPlayer().getColorPlayer() == Color.BLACK) {
            if (destRow == originRow + 1 && Math.abs(destCol - originCol) == 1 || destRow == originRow + 2 && Math.abs(destCol - originCol) == 2) {
                return true;
            } else {
                throw new GameException("Black pawn can only go down in a +-2 square");
            }
        } else if (color == Color.WHITE && board.getCurrentPlayer().getColorPlayer() == Color.WHITE) {
            if (destRow == originRow - 1 && Math.abs(destCol - originCol) == 1 || destRow == originRow - 2 && Math.abs(destCol - originCol) == 2) {
                return true;
            } else {
                throw new GameException("White pawn can only go up in a +-2 square");
            }
        } else {
            throw new GameException("Movement not authorized for this normal pawn");
        }
    }
}
