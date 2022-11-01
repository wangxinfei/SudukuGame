package SudokuGame.problemdomain;

import SudokuGame.computationlogic.SudokuUtilities;
import SudokuGame.constants.GameState;

import java.io.Serializable;

//a sudoku game is a board, which contain 81 squares.
public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;

    //the first index position is 0 instead of 1
    //grid coordinates will be represented with x and y index values ranging from 0 to 8
    public static final int GRID_BOUNDARY = 9;

    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }

}
