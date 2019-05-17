package pkg.game;

public class Model {
    /** Method to change the kings positions.
     * @param player which player wants to take the change
     * @param current actual board where the change make
     * @param whereX the first new coordinate of the king
     * @param whereY the second new coordinate of the king
     * @return returns the updated {@code current} board after the change
     */
    public static Table positionChange(PlayerModel player, Table current, int whereX, int whereY){
        int row=10,col=10;
        if(player.whiteKing){

            for (int i = 0; i < 6; i++) {
                for (int j=0;j<8;j++)
                    if(current.table[i][j].kingWhite) {
                       row=i;
                       col=j;
                    }
            }
            current.table[row][col].empty=true;
            current.table[row][col].kingWhite=false;
            current.table[whereX][whereY].empty=false;
            current.table[whereX][whereY].kingWhite=true;

        }else if (player.blackKing){

            for (int i = 0; i < 6; i++) {
                for (int j=0;j<8;j++)
                    if(current.table[i][j].kingBlack) {
                        row=i;
                        col=j;
                    }
            }
            current.table[row][col].empty=true;
            current.table[row][col].kingBlack=false;
            current.table[whereX][whereY].empty=false;
            current.table[whereX][whereY].kingBlack=true;
        }
        return current;
    }
    /**
     * Method to change the deleted field features.
     * @param player who wants to delete
     * @param current actual board where the delete make
     * @param whereDel_x first coordinate of the deleted field
     * @param whereDel_Y second coordinate of the deleted field
     * @return returns the updated {@code current} board after the delete
     */
    public static Table deleteField(PlayerModel player, Table current, int whereDel_x, int whereDel_Y){
        if(player.whiteKing){

            current.table[whereDel_x][whereDel_Y].kingWhite=false;
            current.table[whereDel_x][whereDel_Y].kingBlack=false;
            current.table[whereDel_x][whereDel_Y].empty=false;
            current.table[whereDel_x][whereDel_Y].deleted=true;

        }else if (player.blackKing){

            current.table[whereDel_x][whereDel_Y].kingWhite=false;
            current.table[whereDel_x][whereDel_Y].kingBlack=false;
            current.table[whereDel_x][whereDel_Y].empty=false;
            current.table[whereDel_x][whereDel_Y].deleted=true;
        }
        return current;
    }
}
