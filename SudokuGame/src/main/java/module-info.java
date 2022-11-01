module com.example.sudokugame {
    requires javafx.controls;
    requires javafx.fxml;


    opens SudokuGame to javafx.fxml;
    exports SudokuGame;
    exports SudokuGame.problemdomain;
    opens SudokuGame.problemdomain to javafx.fxml;
    exports SudokuGame.constants;
    opens SudokuGame.constants to javafx.fxml;
}