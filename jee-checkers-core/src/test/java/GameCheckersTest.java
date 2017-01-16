import Exception.GameException;
import Game.GameCheckersImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 12/01/2017.
 */
public class GameCheckersTest {

    private GameCheckersImpl game;

    @Before
    public void setUp() throws Exception {
        this.game = new GameCheckersImpl();
    }

    @Test
    /**
     * Test if the selected is on the board
     */
    public void selectedCellIsOnTheBoard() throws Exception {
        try {
            game.play(100, 100, 100, 100);
            Assert.fail("Selected cell should be on the board");
        }catch (GameException g){
        }
    }

    @Test
    /**
     * Test if the selected cell contains a pawn
     */
    public void selectedCellContainsPawn() throws Exception {
        try{
            game.play(3, 1, 2, 4);
            Assert.fail("Selected cell does not contains pawn");
        }catch (GameException g){

        }
    }

    @Test
    /**
     * Test if the played move is outside the board
     */
    public void moveOutsideBoardTest() throws Exception {
        try {
            game.play(3, 0, -1, 4);
            Assert.fail("Pawn can not be moved outside the board");
        } catch (ArrayIndexOutOfBoundsException g) {
        } catch (GameException e) {
        }
    }

/*    @Test
    public void normalMoveTest() throws Exception {
        //Normal move black pawn down
        game.movePawn(3, 0, 4, 1);
        assertThat(game.getBoard().getCell(4, 1).hasPawn());
        assertThat(game.getBoard().getCell(4, 1).getPawn().getPawnColor()).isEqualTo(Color.BLACK);

        //Normal move white pawn up
        game.movePawn(6, 1, 5, 2);
        assertThat(game.getBoard().getCell(5, 2).hasPawn());
        assertThat(game.getBoard().getCell(5, 2).getPawn().getPawnColor()).isEqualTo(Color.WHITE);
    }*/

    @Test
    /**
     * Test if a pawn can take another pawn of the opposite color
     */
    public void normalPawnCanTakeAnotherPawn() throws Exception {
        /**game.play(3, 6, 4, 5);
         game.play(6, 7, 5, 6);
         game.play(4, 5, 6, 7);**/

        //TODO add points on pawn took
    }

    /**
     * Test if a pawn can not take another pawn of the same color
     *
     * @throws Exception
     */
    @Test
    public void normalPawnCanNotTakePawnOfSameColor() throws Exception {


    }

    @Test
    /**
     * Test if a pawn can not go in inverted direction
     */
    public void normalMoveInverted() throws Exception {


    }
}
