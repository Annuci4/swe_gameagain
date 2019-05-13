package pkg;

import static java.lang.Math.abs;

public class Test {

    /**
     * Test for the possible moves.
     * @param x first coordinate of the field tested
     * @param y second coordinate of the field tested
     * @param current tested board
     * @param player which player wants to take the move
     * @return {@code valid} true, if the test accept the coordinates
     */
    public static Boolean preTest(int x, int y,  table current, playerModel player){
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
        //System.out.println("hy"+where1+" "+where2);
       if(current.table[x][y].empty && abs(where1-x)<=1 && abs(where2-y)<=1){
           valid=true;
       }
       return valid;
    }

    /**
     * test which examines that in the current table the player can delete the defined field or not .
     * @param x first coordinate of the field what the player wants to delete
     * @param y second coordinate of the field what the player wants to delete
     * @param current tested board
     * @return {@code valid} true, if the player can delete the field (The field is empty and not deleted yet.)
     */
    public static Boolean deleteTest(int x, int y, table current){
        boolean valid = false;
        if(current.table[x][y].empty && !current.table[x][y].deleted){
            valid = true;
        }
        return valid;
    }



}
