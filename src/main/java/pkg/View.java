
package pkg;

public class View {

    /**
     * examine the status of the field in the current table and
     * associate them with letters based on them and draw the table.
     * @param current the {@code current} table to update
     */
    public static void print(table current){

        for(int i = 0; i < 6; i++){
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