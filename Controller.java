package tictactoe;

import javax.swing.*;

public class Controller {
    private final TicTacToe view;

    private boolean gameProgress;

    private Player selectedPlayer;

    public Controller(TicTacToe view) {
        this.view = view;
    }

    public void initController() {

        for (JButton button : view.getButtonsArray()) {
            button.addActionListener(e -> {
                String action = e.getActionCommand();

                if (isGameProgress()) {
                    if (action.equals(Status.CELL_NAME_NULL.getName())) {
                        button.setText(getSelectedPlayer().getSym());
                        checkWinner();
                    }
                }
            });
        }

        view.getButtonStartReset().addActionListener(e -> {
            if (view.getButtonStartReset().getText().equals("Start")) {
                startGame();
            } else {
                restartGame();
            }
        });

        view.getButtonPlayer1().addActionListener(e -> {
            view.getButtonPlayer1().setText(view.getButtonPlayer1().getText().equals("Human") ? "Robot" : "Human");
            view.player1.setName(view.player1.getName().equals("Human") ? "Robot" : "Human");

        });
        view.getButtonPlayer2().addActionListener(e -> {
            view.getButtonPlayer2().setText(view.getButtonPlayer2().getText().equals("Human") ? "Robot" : "Human");
            view.player2.setName(view.player2.getName().equals("Human") ? "Robot" : "Human");
        });

    }

    public void initMenuController() {
        view.getMenuHumanHuman().addActionListener(e -> set("Human", "Human"));

        view.getMenuHumanRobot().addActionListener(e -> set("Human", "Robot"));

        view.getMenuRobotHuman().addActionListener(e -> set("Robot", "Human"));

        view.getMenuRobotRobot().addActionListener(e -> set("Robot", "Robot"));

        view.getMenuExit().addActionListener(e -> System.exit(0));
    }

    private void set(String text, String name) {

        if (!view.getButtonStartReset().getText().equals("Start")) {
            restartGame();

        }
        view.getButtonPlayer1().setText(text);
        view.player1.setName(text);
        view.getButtonPlayer2().setText(name);
        view.player2.setName(name);
        startGame();
    }

    private void checkWinner() {
        if (butt(0).equals(butt(1)) && butt(1).equals(butt(2)) && !butt(0).equals(" ") ||
                butt(3).equals(butt(4)) && butt(4).equals(butt(5)) && !butt(3).equals(" ") ||
                butt(6).equals(butt(7)) && butt(7).equals(butt(8)) && !butt(6).equals(" ") ||
                butt(0).equals(butt(3)) && butt(3).equals(butt(6)) && !butt(0).equals(" ") ||
                butt(1).equals(butt(4)) && butt(4).equals(butt(7)) && !butt(1).equals(" ") ||
                butt(2).equals(butt(5)) && butt(5).equals(butt(8)) && !butt(2).equals(" ") ||
                butt(0).equals(butt(4)) && butt(4).equals(butt(8)) && !butt(0).equals(" ") ||
                butt(2).equals(butt(4)) && butt(4).equals(butt(6)) && !butt(2).equals(" ")) {

            view.getLabelStatus().setText(getSelectedPlayerName() + " Player (" + getSelectedPlayerSym() + ") wins");
            for (JButton button : view.getButtonsArray()) {
                button.setEnabled(false);
            }
        } else if (view.getButtonsArray().stream().noneMatch(e -> e.getText().equals(" "))) {
            view.getLabelStatus().setText(Status.DRAW.getName());
        } else {
            switchSelectedPlayer();
            view.getLabelStatus().setText("The turn of " + getSelectedPlayerName() + " Player (" + getSelectedPlayerSym() + ")");
        }
    }

    private void restartGame() {
        for (JButton button : view.getButtonsArray()) {
            button.setText(" ");
            button.setEnabled(false);
        }
        view.getLabelStatus().setText(Status.GAME_IS_NOT_STARTED.getName());
        view.getButtonPlayer1().setEnabled(true);
        view.getButtonPlayer2().setEnabled(true);
        view.getButtonPlayer1().setText("Human");
        view.getButtonPlayer2().setText("Human");
        view.player1.setName("Human");
        view.player2.setName("Human");
        view.getButtonStartReset().setText(view.getButtonStartReset().getText().equals("Start") ? "Reset" : "Start");
    }

    private void startGame() {
        setSelectedPlayer(view.player1);
        setGameProgress(true);
        for (JButton button : view.getButtonsArray()) {
            button.setEnabled(true);
        }
        view.getButtonPlayer1().setEnabled(false);
        view.getButtonPlayer2().setEnabled(false);
        view.getLabelStatus().setText("The turn of " + getSelectedPlayerName() + " Player (" + getSelectedPlayerSym() + ")");
        view.getButtonStartReset().setText(view.getButtonStartReset().getText().equals("Start") ? "Reset" : "Start");
    }

    private String butt(int i) {
        return view.getButtonsArrayText(i);
    }

    private boolean isGameProgress() {
        return gameProgress;
    }

    private void setGameProgress(boolean gameProgress) {
        this.gameProgress = gameProgress;
    }

    private Player getSelectedPlayer() {
        return selectedPlayer;
    }

    private String getSelectedPlayerName() {
        return selectedPlayer.getName();
    }

    private String getSelectedPlayerSym() {
        return selectedPlayer.getSym();
    }

    private void setSelectedPlayer(Player player) {
        this.selectedPlayer = player;
    }

    private void switchSelectedPlayer() {
        setSelectedPlayer(getSelectedPlayer().equals(view.player1) ? view.player2 : view.player1);
    }
}
