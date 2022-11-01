package SudokuGame.userinterface;

import javafx.scene.control.TextField;

public class SudokuTextField extends TextField {
    private final int x;
    private final int y;

    public SudokuTextField(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void replaceText(int i, int i1, String s) {    //just in case input number is repeated or out of range
        if (!s.matches("[0-9]")) {    //regular expression to match string
            super.replaceText(i, i1, s);    //super keyword is to call methods from parent class
        }
    }


    @Override
    public void replaceSelection(String s) {
        if (!s.matches("[0-9]")) {
            super.replaceSelection(s);
        }
    }


}