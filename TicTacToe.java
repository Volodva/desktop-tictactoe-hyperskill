package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TicTacToe extends JFrame {

    private final ArrayList<JButton> buttonsArray = new ArrayList<>();
    private final String[] CellNames = {
            "A3", "B3", "C3",
            "A2", "B2", "C2",
            "A1", "B1", "C1"};
    private JLabel labelStatus;
    private JButton buttonPlayer1;
    private JButton ButtonStartReset;
    private JButton buttonPlayer2;
    private JPanel board;

    private JMenuItem menuHumanHuman;
    private JMenuItem menuHumanRobot;
    private JMenuItem menuRobotHuman;
    private JMenuItem menuRobotRobot;
    private JMenuItem menuExit;


    Player player1 = new Player("Human", "X");
    Player player2 = new Player("Human", "O");

    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 450);

        createMenuBar();

        createBoard();

        setVisible(true);
    }


    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        menuGame.setName("MenuGame");
        menuGame.setMnemonic(KeyEvent.VK_F);


        menuHumanHuman = new JMenuItem("Human vs Human");
        menuHumanHuman.setName("MenuHumanHuman");
        menuHumanRobot = new JMenuItem("Human vs Robot");
        menuHumanRobot.setName("MenuHumanRobot");
        menuRobotHuman = new JMenuItem("Robot vs Human");
        menuRobotHuman.setName("MenuRobotHuman");
        menuRobotRobot = new JMenuItem("Robot vs Robot");
        menuRobotRobot.setName("MenuRobotRobot");
        menuExit = new JMenuItem("Exit");
        menuExit.setName("MenuExit");


        menuGame.add(menuHumanHuman);
        menuGame.add(menuHumanRobot);
        menuGame.add(menuRobotHuman);
        menuGame.add(menuRobotRobot);

        menuGame.addSeparator();
        menuGame.add(menuExit);

        menuBar.add(menuGame);
        setJMenuBar(menuBar);
    }

    private void createMenuButtons() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 3));

        buttonPlayer1 = new JButton();
        buttonPlayer1.setName("ButtonPlayer1");
        buttonPlayer1.setText("Human");
        buttonPlayer1.setFocusPainted(false);
        menuPanel.add(buttonPlayer1);

        ButtonStartReset = new JButton();
        ButtonStartReset.setName("ButtonStartReset");
        ButtonStartReset.setText("Start");
        ButtonStartReset.setFocusPainted(false);
        menuPanel.add(ButtonStartReset);


        buttonPlayer2 = new JButton();
        buttonPlayer2.setName("ButtonPlayer2");
        buttonPlayer2.setText("Human");
        buttonPlayer2.setFocusPainted(false);
        menuPanel.add(buttonPlayer2);

        board.add(menuPanel, BorderLayout.NORTH);

    }

    private void createBoard() {
        board = new JPanel();
        board.setLayout(new BorderLayout());
        createMenuButtons();
        createCell();
        createStatusBar();
        add(board);
    }

    private void createCell() {

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(3, 3));

        for (String name : CellNames) {
            JButton cell = button(name);
            buttonsArray.add(cell);
            fieldPanel.add(cell);
        }
        board.add(fieldPanel, BorderLayout.CENTER);
    }

    private void createStatusBar() {

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());

        labelStatus = new JLabel();
        labelStatus.setText(Status.GAME_IS_NOT_STARTED.getName());
        labelStatus.setName("LabelStatus");
        labelStatus.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 0));
        statusPanel.add(labelStatus, BorderLayout.WEST);

        board.add(statusPanel, BorderLayout.SOUTH);
    }

    private JButton button(String name) {
        JButton button = new JButton();
        button.setName("Button" + name);
        button.setText(Status.CELL_NAME_NULL.getName());
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setEnabled(false);

        return button;
    }

    public ArrayList<JButton> getButtonsArray() {
        return buttonsArray;
    }

    public String getButtonsArrayText(int i) {
        return buttonsArray.get(i).getText();
    }

    public JLabel getLabelStatus() {
        return labelStatus;
    }

    public JButton getButtonPlayer1() {
        return buttonPlayer1;
    }

    public JButton getButtonStartReset() {
        return ButtonStartReset;
    }

    public JButton getButtonPlayer2() {
        return buttonPlayer2;
    }

    public JMenuItem getMenuHumanHuman() {
        return menuHumanHuman;
    }

    public JMenuItem getMenuHumanRobot() {
        return menuHumanRobot;
    }

    public JMenuItem getMenuRobotHuman() {
        return menuRobotHuman;
    }

    public JMenuItem getMenuRobotRobot() {
        return menuRobotRobot;
    }

    public JMenuItem getMenuExit() {
        return menuExit;
    }
}


