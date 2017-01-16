import Model.Board;
import Model.Cell;
import Model.Color;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class BoardTest {

    private int nbRows = 10;
    private int nbCols = 10;
    private int nbPawnsPlayer = 20;

    private Board board;

    @Before
    public void doBefore() throws Exception {
        board = new Board(nbRows, nbCols, "Player1", "Player2");
    }

    @Test
    /**
     * Test the instantiation of the board
     */
    public void boardInstantiationTest() throws Exception {
        assertThat(board).isNotNull();
    }

    @Test
    /**
     * The the size of the created board
     */
    public void boardSizeTest() throws Exception {
        assertThat(board.getCells()).isNotNull();
        assertThat(board.getCells().size()).isEqualTo(nbRows);
        for (int row = 0; row < nbRows; row++) {
            assertThat(board.getCells().get(row).size()).isEqualTo(nbCols);
        }
    }

    @Test
    /**
     * Test the cells color to check if they are well placed
     */
    public void boardColorTest() throws Exception {
        List<List<Cell>> cells = board.getCells();
        for (int row = 0; row < cells.size(); row++) {
            for (int col = 0; col < cells.get(row).size(); col++) {
                if (col % 2 == 0) {
                    if (row % 2 == 0) {
                        assertThat(cells.get(col).get(row).getCellColor()).isEqualTo(Color.WHITE);
                    } else {
                        assertThat(cells.get(col).get(row).getCellColor()).isEqualTo(Color.BLACK);
                    }
                } else {
                    if (row % 2 != 0) {
                        assertThat(cells.get(col).get(row).getCellColor()).isEqualTo(Color.WHITE);
                    } else {
                        assertThat(cells.get(col).get(row).getCellColor()).isEqualTo(Color.BLACK);
                    }
                }
            }
        }
    }

    @Test
    /**
     * Test the initial position on the board and their numbers
     */
    public void pawnInitialPositionTest() throws Exception {
        int totalPawns = 0;
        //Black pawns
        for (int row = 0; row <= (nbRows / 2) - 2; row++) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = board.getCell(row, col);
                if (currentCell.getCellColor() == Color.BLACK) {
                    assertThat(currentCell.getPawn()).isNotNull();
                    assertThat(currentCell.getPawn().getPawnColor()).isEqualTo(Color.BLACK);
                    totalPawns++;
                } else {
                    assertThat(currentCell.getPawn()).isNull();
                }
            }
        }
        //White Pawns
        for (int row = nbRows - 1; row >= nbRows - ((nbRows / 2) - 1); row--) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = board.getCell(row, col);
                if (currentCell.getCellColor() == Color.BLACK) {
                    assertThat(currentCell.getPawn()).isNotNull();
                    assertThat(currentCell.getPawn().getPawnColor()).isEqualTo(Color.WHITE);
                    totalPawns += 1;
                } else {
                    assertThat(currentCell.getPawn()).isNull();
                }
            }
        }
        assertThat(totalPawns).isEqualTo(nbPawnsPlayer * 2);
    }
}
