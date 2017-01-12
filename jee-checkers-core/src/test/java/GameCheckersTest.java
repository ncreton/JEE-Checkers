import Model.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Exception.*;

import static junit.framework.TestCase.fail;

/**
 * Created by nicolas on 12/01/2017.
 */
public class GameCheckersTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        this.board = new Board(10,10);
    }

    @Test
    public void selectedCellInOnTheBoard() throws Exception {
        try {
            board.movePawn(100,100,100,100);
            Assert.fail("Selected cell should be on the board");
        }catch (GameException g){
        }
    }

    @Test
    public void selectedCellContainsPawn() throws Exception {
    }

    @Test
    public void moveOutsideBoardTest() throws Exception {
    }

    @Test
    public void moveNormalTest() throws Exception {
    }
}
