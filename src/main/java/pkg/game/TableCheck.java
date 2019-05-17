package pkg.game;

import static java.lang.Math.abs;

/**
 * Tests to check to given coordinates in the game.
 */
public class TableCheck {
    /**
     * TableCheck for check the current move is valid or not.
     * Check if the field is empty or not, if its empty,
     * check how much is tha absolute value of the difference
     * between kings coordinates and the given coordinates.
     * @param x first coordinate of the field tested
     * @param y second coordinate of the field tested
     * @param current current tested board
     * @param player which player wants to take the move
     * @return {@code valid} true, if the test accept the coordinates
     */
    public static boolean preCheck(int x, int y, Table current, PlayerModel player){
       boolean valid = false;
       int where1=10,where2=10;

        if (player.whiteKing) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 9; j++) {
                    if (current.table[i][j].kingWhite) {
                        where1 = i;
                        where2 = j;
                    }
                }
            }
        }else if(player.blackKing){
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 9; j++) {
                    if (current.table[i][j].kingBlack) {
                        where1 = i;
                        where2 = j;
                    }
                }
            }
        }
       if(current.table[x][y].empty && abs(where1-x)<=1 && abs(where2-y)<=1){
           valid=true;
       }
       return valid;
    }
    /**
     * TableCheck which checks that in the current Table
     * the player can delete the defined field or not .
     * @param x first coordinate of the field what the player wants to delete
     * @param y second coordinate of the field what the player wants to delete
     * @param current tested board
     * @return {@code valid} true, if the player can delete the field (The field is empty and not deleted yet.)
     */
    public static boolean deleteCheck(int x, int y, Table current){
        boolean valid = false;
        if(current.table[x][y].empty && !current.table[x][y].deleted){
            valid = true;
        }
        return valid;
    }

    /**
     * TableCheck which check the win.
     * @param row the first coordinate of the king who had the turn
     * @param col the second coordinate of the king who has the turn
     * @return {@code true} if someone won
     */
    public static boolean winCheck(int row, int col, Table current){

        boolean win=false;
        int db = 0;
        if(row>0 && row<7 && col>0 && col<9) {
            for (int i = row - 1; i <=row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (current.table[i][j].empty)
                        db++;
                }
            }
        }
       if (db==0)
           win=true;
       return win;
    }
}