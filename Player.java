package tictactoe;

public class Player {

    private String name;
    private final String sym;

    public Player(String name, String sym) {
        this.name = name;
        this.sym = sym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSym() {
        return sym;
    }
}
