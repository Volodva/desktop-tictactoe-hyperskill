package tictactoe;

import java.awt.*;

public class ApplicationRunner {
    public static void main(String[] args) {
       TicTacToe ticTacToe = new TicTacToe();
        Controller controller = new Controller(ticTacToe);
        controller.initController();
        controller.initMenuController();
    }
}
