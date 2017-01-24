package Model;

import Exception.GameException;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 09/01/2017.
 */
public class Board {

    private int nbRows;
    private int nbCols;
    private List<List<Cell>> cells;

    private Player playerWhite;
    private Player playerBlack;
    private Player currentPlayer;
    private Player lastPlayer;

    public Board() throws GameException {
        //Default board if no size and pawns are given (international board by default)
        this(10, 10, "Player1", "Player2");
    }

    public Board(int nbRows, int nbCols, String playerName1, String playerName2) throws GameException {
        if (nbRows == nbCols && nbRows % 2 == 0) {
            this.nbRows = nbRows;
            this.nbCols = nbCols;
            this.cells = initCells();
            int nbPawnsPerPlayer = this.computeNbPawnsPerPlayer();
            this.playerWhite = new Player(playerName1, Color.WHITE, nbPawnsPerPlayer);
            this.playerBlack = new Player(playerName2, Color.BLACK, nbPawnsPerPlayer);
            this.currentPlayer = playerWhite;
            this.lastPlayer = null;
            initPawns();
        } else {
            throw new GameException("Board must be square and even size");
        }

    }

    private List<List<Cell>> initCells() {
        List<List<Cell>> cells = new ArrayList<>(nbRows);
        for (int row = 0; row < nbRows; row++) {
            List<Cell> colsCells = new ArrayList<Cell>(nbCols);
            for (int col = 0; col < nbCols; col++) {
                colsCells.add(new Cell(row, col));
            }
            cells.add(colsCells);
        }
        return cells;
    }

    private void initPawns() {
        //Put black pawns on white cells on the fourth first line
        initBlackPawns();
        //Put white pawns on black cells on the fourth last lines
        initWhitePawns();
    }

    private void initWhitePawns() {
        for (int row = nbRows - 1; row >= nbRows - ((nbRows / 2) - 1); row--) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = getCell(row, col);
                if (currentCell.getCellColor() == Color.BLACK) {
                    currentCell.setPawn(new Pawn(Color.WHITE, PawnType.NORMAL));
                }
            }
        }
    }

    private void initBlackPawns() {
        for (int row = 0; row <= (nbRows / 2) - 2; row++) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = getCell(row, col);
                if (currentCell.getCellColor() == Color.BLACK) {
                    currentCell.setPawn(new Pawn(Color.BLACK, PawnType.NORMAL));
                }
            }
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public Cell getCell(int row, int col){
        return this.cells.get(row).get(col);
    }

    public boolean isCoordinateInTheBoard(int row, int col){
        return row < nbRows || col < nbCols;
    }

    public void swapPawn(Cell originCell, Cell destCell) {
        Pawn currentPawn = originCell.getPawn();
        originCell.setPawn(null);
        destCell.setPawn(currentPawn);
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getNbCols() {
        return nbCols;
    }

    public int computeNbPawnsPerPlayer() {
        return ((nbRows * nbCols - 2 * nbCols) / 4);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int row = 0; row < getNbRows(); row++){
            sb.append("|");

            for(int col = 0; col < getNbCols(); col++){
                boolean hasPawn = getCell(row, col).hasPawn();
                if(hasPawn && getCell(row, col).getPawn().getPawnType() == PawnType.QUEEN){
                    sb.append("Q");
                }
                else if(hasPawn && getCell(row, col).getPawn().getPawnColor() == Color.BLACK) {
                    sb.append("X");
                }
                else if(hasPawn && getCell(row, col).getPawn().getPawnColor() == Color.WHITE) {
                    sb.append("O");
                }
                else{
                    sb.append(" ");
                }
                sb.append("|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void switchPlayer() {
        this.lastPlayer = this.currentPlayer;
        if(this.currentPlayer.getNbPawns() != 0){
            this.currentPlayer = (this.currentPlayer == this.playerWhite) ? this.playerBlack : this.playerWhite;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public Player getOpponentPlayer() {
        if(currentPlayer.getColorPlayer() == Color.BLACK) {
            return getPlayerWhite();
        }
        if(currentPlayer.getColorPlayer() == Color.WHITE) {
            return getPlayerBlack();
        }
        return null;
    }
}
