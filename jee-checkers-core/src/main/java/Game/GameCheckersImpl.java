package Game;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Pawn;

import java.util.List;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class GameCheckersImpl implements GameCheckers {

    public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final int NUMBER_OF_PAWNS_TO_ALIGN = 10;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    private Board board;

    public GameCheckersImpl() {
        this.board = new Board();
    }

    public GameCheckersImpl(int rows, int columns) {
        this.board = new Board(rows, columns);
    }

    @Override
    public void play(Pawn pawn, int row, int col){

    }

    @Override
    public boolean isQueenPosition(Cell cell) {
        if(cell.getRowIndex() == 0){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return new String("");
    }
}
