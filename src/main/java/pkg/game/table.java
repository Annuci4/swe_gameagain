package pkg.game;


public class table {

    public static state[][] table = new state[6][8];
    /**
     * Create the starter table.
     */
    public static void createTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = new state();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j].empty = true;
            }
        }
        table[2][0].kingWhite = true;

        for (int i = 2; i < 4; i++) {
            for (int j = 1; j < 8; j++) {
                table[i][j].empty = true;
            }
        }
        table[3][0].empty = true;
        table[3][7].empty = false;
        table[3][7].kingBlack = true;

        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j].empty = true;
            }
        }

    }
}


