package Game;

import Exception.GameException;
import Model.Board;
import Model.Cell;
import Model.Color;
import Model.QueenDirection;
import Player.Player;

import static java.lang.Math.abs;

/**
 * Created by nicolas on 13/01/2017.
 */
public class QueenMove extends Move {

    public QueenMove(Board board) {
        super(board);
    }

    /**
     * Method to move the queen
     *
     * @param originCell
     * @param destCell
     * @throws GameException
     */
    public void move(Player opponentPlayer, Cell originCell, Cell destCell) throws GameException {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();

        if (isMoveAuthorized(originCell, destCell)) {
            if (getDiagonalDirection(originRow, originCol, destRow, destCol) == QueenDirection.RIGHT_DIAGONAL) {
                if (!isSimpleQueenMove(originRow, destRow, originCol, destCol) && isOtherTeamPawns(originCell, destCell, QueenDirection.RIGHT_DIAGONAL)) {
                    //Remove opponents pawns
                    removeRangePawns(originCell, destCell, QueenDirection.RIGHT_DIAGONAL);
                }
            } else if (getDiagonalDirection(originRow, originCol, destRow, destCol) == QueenDirection.LEFT_DIAGONAL) {
                if (!isSimpleQueenMove(originRow, destRow, originCol, destCol) && isOtherTeamPawns(originCell, destCell, QueenDirection.LEFT_DIAGONAL)) {
                    //Remove opponents pawns
                    removeRangePawns(originCell, destCell, QueenDirection.LEFT_DIAGONAL);
                }
            } else {
                throw new GameException("Problem moving the queen");
            }
            board.swapPawn(originCell, destCell);
            board.switchPlayer();
        }
    }

    @Override
    public boolean isMoveAuthorized(Cell originCell, Cell destCell) throws GameException {
        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();
        Color color = originCell.getPawn().getPawnColor();

        if(( (color == Color.BLACK && board.getCurrentPlayer().getColorPlayer() == Color.BLACK) || (color == Color.WHITE && board.getCurrentPlayer().getColorPlayer() == Color.WHITE))  && abs(destRow - originRow) == abs(destCol - originCol)){
            return true;
        } else {
            throw new GameException("Movement not authorized");
        }
    }

    /**
     * Function to compute the diagonal direction of the queen
     *
     * @param originRow
     * @param originCol
     * @param destRow
     * @param destCol
     * @return
     */
    private QueenDirection getDiagonalDirection(int originRow, int originCol, int destRow, int destCol) {
        QueenDirection queenDirection = null;

        if (destRow < originRow && destCol > originCol || destRow > originRow && destCol < originCol)
            queenDirection = QueenDirection.RIGHT_DIAGONAL;

        if (destRow < originRow && destCol < originCol || destRow > originRow && destCol > originCol) {
            queenDirection = QueenDirection.LEFT_DIAGONAL;
        }
        return queenDirection;
    }

    private boolean isSimpleQueenMove(int originRow, int destRow, int originCol, int destCol) {
        if(destRow == originRow + 1 && (destCol == originCol - 1 || destCol == originCol + 1) || destRow == originRow - 1 && (destCol == originCol - 1 || destCol == originCol + 1)){
            return true;
        }
        return false;
    }
}
