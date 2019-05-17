package pkg.game;

public class Table {

    public State[][] table = new State[8][10];

    /**
     * Create the starter Table.
     */
    public void createTable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = new State();
            }
        }
        for (int i=0; i<10;i++){
            table[0][i].empty=false;
            table[0][i].deleted=true;
        }
        for (int i=0; i<10;i++){
            table[7][i].empty=false;
            table[7][i].deleted=true;
        }
        for (int i=0; i<8;i++){
            table[i][0].empty=false;
            table[i][0].deleted=true;
        }
        for (int i=0; i<8;i++){
            table[i][9].empty=false;
            table[i][9].deleted=true;
        }

        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                table[i][j].empty = true;
            }
        }
        table[3][1].empty=false;
        table[3][1].kingWhite = true;

        for (int i = 3; i < 5; i++) {
            for (int j = 2; j < 9; j++) {
                table[i][j].empty = true;
            }
        }
        table[4][1].empty = true;
        table[4][8].empty = false;
        table[4][8].kingBlack = true;

        for (int i = 5; i < 7; i++) {
            for (int j = 1; j < 9; j++) {
                table[i][j].empty = true;
            }
        }
    }
    public void createTable2(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = new State();
            }
        }
        for (int i=0; i<10;i++){
            table[0][i].empty=false;
            table[0][i].deleted=true;
        }
        for (int i=0; i<10;i++){
            table[7][i].empty=false;
            table[7][i].deleted=true;
        }
        for (int i=0; i<8;i++){
            table[i][0].empty=false;
            table[i][0].deleted=true;
        }
        for (int i=0; i<8;i++){
            table[i][9].empty=false;
            table[i][9].deleted=true;
        }

        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                table[i][j].empty = true;
            }
        }

        //table[3][3].empty = true;
        table[3][2].empty = false;
        table[3][2].kingBlack = true;
        table[1][8].kingWhite=true;
        table[1][8].empty=false;

        table[3][2].empty=false;
        table[3][2].deleted=true;
        table[3][4].empty=false;
        table[3][4].deleted=true;
        table[2][2].empty=false;
        table[2][2].deleted=true;
        table[2][3].empty=false;
        table[2][3].deleted=true;
        table[2][4].empty=false;
        table[2][4].deleted=true;
        table[4][2].empty=false;
        table[4][2].deleted=true;
        table[4][3].empty=false;
        table[4][3].deleted=true;
        table[4][4].empty=false;
        table[4][4].deleted=true;
    }
}



