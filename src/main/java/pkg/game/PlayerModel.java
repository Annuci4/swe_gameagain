package pkg.game;

public class PlayerModel {

    boolean turn;
    boolean win;
    boolean whiteKing;
    boolean blackKing;
    boolean delete_turn;
    String name = null;
    int first;
    int second;

    /**
     * Contains players attributes.
     * @param b  {@code true}, if the actual player has the turn
     * @param b0 {@code true}, if the actual player has the delete turn
     * @param b1 {@code true}, if the actual player win
     * @param b2 {@code true}, if the actual player has the white king
     * @param b3 {@code true}, if the actual player has the black king
     */
    public PlayerModel(boolean b, boolean b0, boolean b1, boolean b2, boolean b3, int b4, int b5) {
        this.turn = b;
        this.delete_turn =b0;
        this.win = b1;
        this.whiteKing = b2;
        this.blackKing = b3;
        this.first=b4;
        this.second=b5;
    }
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean isWin() {
        return win;
    }

    void setWin(boolean win) {
        this.win = win;
    }

}