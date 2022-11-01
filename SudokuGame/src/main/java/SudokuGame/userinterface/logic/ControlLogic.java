package SudokuGame.userinterface.logic;

import SudokuGame.computationlogic.GameLogic;
import SudokuGame.constants.GameState;
import SudokuGame.constants.Messages;
import SudokuGame.problemdomain.IStorage;
import SudokuGame.problemdomain.SudokuGame;
import SudokuGame.userinterface.IUserInterfaceContract;

import java.io.IOException;

// this is a single screen application, just one class for the logic of the user interface is required.

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;

    //implements the same interface
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    /**
     * @param x X coordinate of the selected input
     * @param y Y ...
     * @param input Which key was entered, One of numbers 0-9
     */
    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();

            //immutable object, creates a new one from the old one
            int[][] newGridState = gameData.getCopyOfGridState();    //retrieves current "state" of the data from IStorage
            newGridState[x][y] = input;    //updates it according to the input

            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );

            storage.updateGameData(gameData);     //stores the result to IStorage

            //either way, update the view
            view.updateSquare(x, y, input);

            //if game is complete, show dialog
            if (gameData.getGameState() == GameState.COMPLETE) view.showDialog(Messages.GAME_COMPLETE);
        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    //generates a new game
    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}
