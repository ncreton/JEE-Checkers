package Game;

import Exception.GameException;
import Model.Board;
import Model.Cell;
import Model.Pawn;
import Model.PawnType;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class GameCheckersImpl implements GameCheckers {

    private Board board;

    public GameCheckersImpl() {
        this.board = new Board();
    }

    public GameCheckersImpl(int rows, int columns) {
        this.board = new Board(rows, columns);
    }

    public Board getBoard() {
        return this.board;
    }

    @Override
    public void play(Pawn pawn, int row, int col){

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
                Move normalMove = new NormalMove(board);
                normalMove.move(originCell, destCell);
            } else if (originCell.getPawn().getPawnType() == PawnType.QUEEN) {
                Move queenMove = new QueenMove(board);
                queenMove.move(originCell, destCell);
            }
        } else {
            throw new GameException("Cell does not contains pawn");
        }
    }
}
