package SudokuGame.constants;

/**
 * Top, Middle, and Bottom rows for each square (a square contains 3x3 "tiles", with 9 squares total in a sudoku game).
 * This enum is to provide better legibility for the logic required to check if each Square in the sudoku contains a valid value.
 * The values represent the Y coordinates of each tile.
 */

public enum Rows {
    TOP,
    MIDDLE,
    BOTTOM
}
