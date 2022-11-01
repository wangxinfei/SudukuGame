package SudokuGame.buildlogic;

import SudokuGame.computationlogic.GameLogic;
import SudokuGame.persistence.LocalStorageImpl;
import SudokuGame.problemdomain.IStorage;
import SudokuGame.problemdomain.SudokuGame;
import SudokuGame.userinterface.IUserInterfaceContract;
import SudokuGame.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    /**
     * this class takes in the uiImpl object which is tightly-coupled to the JavaFX framework,
     * and binds that object to the various other objects necessary for the application to function.
     */

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            //will throw if no game data is found in local storage
            initialState = storage.getGameData();
        } catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);    //if user cannot update the game data, throw a IOException as well
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}