import Model.Board;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class BoardTest {

    private int nbRows = 10;
    private int nbCols = 10;

    private Board board;

    @Before
    public void doBefore() throws Exception {
        board = new Board(nbRows, nbCols);
    }

    @Test
    public void boardSizeTest() throws Exception {
        assertThat(board.getCells()).isNotNull();
    }

}
