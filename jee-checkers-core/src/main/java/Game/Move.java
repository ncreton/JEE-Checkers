package Game;

import Exception.GameException;
import Model.*;

/**
 * Created by nicolas on 13/01/2017.
 */
public abstract class Move {

    protected Board board;

    public Move(Board board) {
        this.board = board;
    }

    public abstract void move(Cell originCell, Cell destCell) throws GameException;

    public abstract boolean isMoveAuthorized(Cell originCell, Cell destCell) throws GameException;

    /**
     * Checks if a pawn is taken during the move
     *
     * @param originCell
     * @param destCell
     */
    protected void takePawnDuringMove(Cell originCell, Cell destCell) {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();
        Color color = originCell.getPawn().getPawnColor();

        if (color == Color.BLACK) {
            if (destRow == originRow + 2 && destCol == originCol - 2) {
                Cell intermediateCell = board.getCell(originRow + 1, originCol - 1);
                if (intermediateCell.getPawn().getPawnColor() == Color.WHITE) {
                    intermediateCell.deletePawn();
                }
            }

            if (destRow == originRow + 2 && destCol == originCol + 2) {
                Cell intermediateCell = board.getCell(originRow + 1, originCol + 1);
                if (intermediateCell.getPawn().getPawnColor() == Color.WHITE) {
                    intermediateCell.deletePawn();
                }
            }
        }

        if (color == Color.WHITE) {
            if (destRow == originRow - 2 && destCol == originCol - 2) {
                Cell intermediateCell = board.getCell(originRow - 1, originCol - 1);
                //Opponent pawn
                if (intermediateCell.getPawn().getPawnColor() == Color.BLACK) {
                    intermediateCell.deletePawn();
                }
            }

            if (destRow == originRow - 2 && destCol == originCol + 2) {
                Cell intermediateCell = board.getCell(originRow - 1, originCol + 1);
                if (intermediateCell.getPawn().getPawnColor() == Color.BLACK) {
                    intermediateCell.deletePawn();
                }
            }
        }
    }

    /**
     * Check if the pawns in the queen's direction are opponent pawns or in the same team
     *
     * @param originCell
     * @param destCell
     * @param queenDirection
     * @return
     */
    protected boolean isOtherTeamPawns(Cell originCell, Cell destCell, QueenDirection queenDirection) {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();
        Pawn pawn = originCell.getPawn();

        //Up diagonal right
        if (queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow < originRow) {
            for (int row = originRow - 1; row <= destRow; row--) {
                if (board.getCell(row, originCol - 1).hasPawn() && board.getCell(row, originCol + 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        //Down diagonal right
        if (queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow > originRow) {
            for (int row = originRow + 1; row <= destRow; row++) {
                if (board.getCell(row, originCol - 1).hasPawn() && board.getCell(row, originCol - 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        //Up diagonal left
        if (queenDirection == QueenDirection.LEFT_DIAGONAL && destRow < originRow) {
            for (int row = originRow - 1; row <= destRow; row--) {
                if (board.getCell(row, originCol - 1).hasPawn() && board.getCell(row, originCol - 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        //Down diagonal left
        if (queenDirection == QueenDirection.LEFT_DIAGONAL && destRow > originRow) {
            for (int row = originRow + 1; row <= destRow; row++) {
                if (board.getCell(row, originCol + 1).hasPawn() && board.getCell(row, originCol + 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Remove pawns between origin and queen destination so on diagonal(if only opponents pawns)
     *
     * @param originCell
     * @param destCell
     * @param queenDirection
     */
    protected void removeRangePawns(Cell originCell, Cell destCell, QueenDirection queenDirection) {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int col = originCol;

        //Up diagonal right
        if (queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow < originRow) {
            for (int row = originRow - 1; row <= destRow; row--) {
                col = col + 1;
                if (board.getCell(row, col).hasPawn()) {
                    board.getCell(row, col).deletePawn();
                }
            }
        }
        //Down diagonal right
        if (queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow > originRow) {
            for (int row = originRow + 1; row <= destRow; row++) {
                col = col - 1;
                if (board.getCell(row, col).hasPawn()) {
                    board.getCell(row, col).deletePawn();
                }
            }
        }
        //Up diagonal left
        if (queenDirection == QueenDirection.LEFT_DIAGONAL && destRow < originRow) {
            for (int row = originRow - 1; row <= destRow; row--) {
                col = col - 1;
                if (board.getCell(row, col).hasPawn()) {
                    board.getCell(row, col).deletePawn();
                }
            }
        }
        //Down diagonal left
        if (queenDirection == QueenDirection.LEFT_DIAGONAL && destRow > originRow) {
            for (int row = originRow + 1; row <= destRow; row++) {
                col = col + 1;
                if (board.getCell(row, col).hasPawn()) {
                    board.getCell(row, col).deletePawn();
                }
            }
        }
    }

    /**
     * Transform a pawn in queen
     *
     * @param row
     * @param col
     */
    protected void changePawnToQueen(int row, int col) {
        if (row == 0 || row == board.getNbRows() - 1) {
            board.getCell(row, col).getPawn().setPawnType(PawnType.QUEEN);
        }
    }

}
