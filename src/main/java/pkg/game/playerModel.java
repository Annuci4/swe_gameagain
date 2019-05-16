package pkg.game;

public class playerModel {

    boolean turn;
    boolean win;
    boolean whiteKing;
    boolean blackKing;
    boolean delete_turn;
    String name = null;

    /**
     * Contains the players attributes.
     * @param b  {@code true}, if the actual player has the turn
     * @param b0 {@code true}, if the actual player has the delete turn
     * @param b1 {@code true}, if the actual player win
     * @param b2 {@code true}, if the actual player has the white king
     * @param b3 {@code true}, if the actual player has the black king
     */
    public playerModel(boolean b, boolean b0, boolean b1, boolean b2, boolean b3) {
        this.turn = b;
        this.delete_turn =b0;
        this.win = b1;
        this.whiteKing = b2;
        this.blackKing = b3;
    }

}