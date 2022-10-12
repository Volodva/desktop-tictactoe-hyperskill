package tictactoe;

public enum Status {

    GAME_IS_NOT_STARTED("Game is not started"),
    DRAW("Draw"),
    CELL_NAME_NULL(" ");

    Status(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}