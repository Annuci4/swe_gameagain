
package pkg.game;

/**
 * the view.
 */
public class View {

    /**
     * examine the status of the field in the current Table and
     * associate them with letters based on them and draw the Table.
     * @param current the {@code current} Table to update
     */
    public static void print(Table current){
        System.out.println("  0 1 2 3 4 5 6 7 ");
        for(int i = 0; i < 6; i++){
            System.out.print(i + " ");

            for (int j = 0; j < 8; j++){
                if (current.table[i][j].empty == true){
                    System.out.print(current.table[i][j].Status ="O"+"|");

                }else if(current.table[i][j].kingBlack == true){
                    System.out.print(current.table[i][j].Status ="B"+"|");

                }else if (current.table[i][j].kingWhite == true){
                    System.out.print(current.table[i][j].Status ="W" + "|");

                }else if (current.table[i][j].deleted == true ){
                    System.out.print(current.table[i][j].Status ="-"+ "|");
                }
            }System.out.println();
        }
    }
}