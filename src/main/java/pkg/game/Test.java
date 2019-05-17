package pkg.game;

import static java.lang.Math.abs;

/**
 * Tests to check to given coordinates in the game.
 */
public class Test {
    /**
     * Test for check the current move is valid or not.
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
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 8; j++) {
                    if (current.table[i][j].kingWhite) {
                        where1 = i;
                        where2 = j;
                    }
                }
            }
        }else if(player.blackKing){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 8; j++) {
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
     * Test which checks that in the current Table
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
     * Test which checks the correctness of the given coordinate point.
     * @param helper the given coordinate point, what we check.
     * @return {@code true}, if the coordinate is not a number.
     */
    public static boolean alphabetCheck(String helper){
        boolean fool=false;
        for (int i = 0; i < helper.length(); i++) {
            if(Character.isAlphabetic(helper.charAt(i))||!Character.isDigit(helper.charAt(i))){
                fool = true;
            }
        }
        return fool;
    }

    /**
     * Test which check the win.
     * @param row the first coordinate of the king who had the turn
     * @param col the second coordinate of the king who has the turn
     * @return {@code true} if someone won
     */
    public static boolean winCheck(int row, int col, Table current){

        boolean win=false;
        int db = 0;

        if(row>0 && row<5 && col>0 && col<7) {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (current.table[i][j].empty)
                        db++;
                }
            }
        }
        else if(row==0 && col>0 && col<7){
            for (int i = row; i <=row + 1; i++) {
                for (int j = col - 1; j <=col + 1; j++) {
                    if (current.table[i][j].empty)
                        db++;
                }
            }
        }
        else if (row==7 && col>0 && col<7){
            for (int i = row-1; i <=row; i++) {
                for (int j = col - 1; j <=col + 1; j++) {
                    if (current.table[i][j].empty)
                        db++;
                }
            }
        }
        else if (col==0 && row>0 && row<5){
            for (int i = row-1; i <= row + 1; i++) {
                for (int j = col; j <= col + 1; j++) {
                    if (current.table[i][j].empty)
                        db++;
                }
            }
        }
        else if (col==7 && row>0 && row<5){
            for (int i = row-1; i <= row + 1; i++) {
                for (int j = col-1; j <= col; j++) {
                    if (current.table[i][j].empty)
                        db++;
                }
            }
        }
        else if(col==0 && row==0){
            if(current.table[1][1].empty){db++;}
            if(current.table[1][0].empty){db++;}
            if(current.table[0][1].empty){db++;}
        }
        else if(col==0 && row==5){
            if(current.table[row-1][col+1].empty){db++;}
            if(current.table[row-1][col].empty){db++;}
            if(current.table[row][col+1].empty){db++;}
        }
        else if(col==7 && row==0){
            if(current.table[row+1][col-1].empty){db++;}
            if(current.table[row+1][col].empty){db++;}
            if(current.table[row][col-1].empty){db++;}
        }
        else if(col==7 && row==5){
            if(current.table[row-1][col-1].empty){db++;}
            if(current.table[row-1][col].empty){db++;}
            if(current.table[row][col-1].empty){db++;}
        }
       if (db==0)
           win=true;
       return win;
    }
}