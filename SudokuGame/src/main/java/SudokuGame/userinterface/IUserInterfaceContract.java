package SudokuGame.userinterface;

import SudokuGame.problemdomain.SudokuGame;

public interface IUserInterfaceContract {

    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    interface View {    // users' view
        void setListener(IUserInterfaceContract.EventListener listener);
        //updates a single square after user input
        void updateSquare(int x, int y, int input);

        //updates the entire board, such as after game completion or initial execution of the program
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
