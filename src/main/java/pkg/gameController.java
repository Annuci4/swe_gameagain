package pkg;

import java.util.*;

/**
 * Game logic.
 */
public class gameController {

    public playerModel player1 = new playerModel(true, true, false, true, false);
    public playerModel player2 = new playerModel(false, false, false, false, true);

    table table = new table();
    String helper;

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        player1.whiteKing = true;
        player2.blackKing = true;
        table.createTable();
        View.print(table);
        int row;
        int col;
        int del_x;
        int del_y;
        while (!player1.win && !player2.win) {
            System.out.println("Kérlek add meg az X és Y koordinátákat.");

                while (true) {
                    System.out.print("X: ");
                    helper = scan.next();
                    if (Test.alphabetTest(helper))
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    if (!Test.alphabetTest(helper)) {
                        row = Integer.parseInt(helper);
                        if (row < 0 || row > 5)
                            System.out.println("A-a...Ez nem lesz jó!\"");
                        else
                            break;
                    }
                }
                while (true) {
                    System.out.print("Y: ");
                    helper = scan.next();
                    if (Test.alphabetTest(helper))
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    if (!Test.alphabetTest(helper)) {
                        col = Integer.parseInt(helper);
                        if (col < 0 || col > 7)
                            System.out.println("A-a...Ez nem lesz jó!\"");
                        else
                            break;
                    }
                }
                if (player1.turn) {
                    // System.out.println("first player_white");
                    if (Test.preTest(row, col, table, player1)) {
                        Model.doSomeMagic(player1, table, row, col);
                        player1.turn = false;
                        player2.turn = true;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("rosszdata");
                        player1.turn = true;
                        player2.turn = false;
                    }
                } else if (player2.turn) {
                    // System.out.println("second player_black");
                    if (Test.preTest(row, col, table, player2)) {
                        Model.doSomeMagic(player2, table, row, col);
                        player1.turn = true;
                        player2.turn = false;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("rosszdata");
                        player1.turn = false;
                        player2.turn = true;
                    }
                }
            System.out.println("Kérlek add meg a törlendő mező koordinátáit");
            while(true) {
                while(true) {
                    System.out.print("Delete x: ");
                    helper = scan.next();
                    if (Test.alphabetTest(helper))
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    if (!Test.alphabetTest(helper)) {
                        del_x = Integer.parseInt(helper);
                        if (col < 0 || col > 7)
                            System.out.println("A-a...Ez nem lesz jó!\"");
                        else
                            break;
                    }
                }
                while(true) {
                    System.out.print("Delete y: ");
                    helper = scan.next();
                    if (Test.alphabetTest(helper))
                        System.out.println("A-a...Ez nem lesz jó!");
                    if (!Test.alphabetTest(helper)) {
                        del_y = Integer.parseInt(helper);
                        if (col < 0 || col > 7)
                            System.out.println("A-a...Ez nem lesz jó!\"");
                        else
                            break;
                    }
                }
                if (player1.delete_turn) {
                    if (Test.deleteTest(del_x, del_y, table)) {
                        Model.doSomeDelete(player1, table, del_x, del_y);
                        player1.delete_turn = false;
                        player2.delete_turn = true;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("Ezt a mezőt nem lehet törölni!");
                        player1.delete_turn = true;
                        player2.delete_turn = false;
                    }
                } else if (player2.delete_turn) {

                    if (Test.deleteTest(del_x, del_y, table)) {
                        Model.doSomeDelete(player1, table, del_x, del_y);
                        player1.delete_turn = true;
                        player2.delete_turn = false;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("Ezt a mezőt nem lehet törölni!");
                        player1.delete_turn = false;
                        player2.delete_turn = true;
                    }
                }
            }
            int db=0;
           if(row>0 && row<5 && col>0 && col<7) {
               for (int i = row - 1; i < row + 1; i++) {
                   for (int j = col - 1; j < col + 1; j++) {
                       if (table.table[i][j].empty)
                           db++;
                   }
               }
           }
           if (row==0 && col>0 && col<7){
               for (int i = row; i < row + 1; i++) {
                   for (int j = col - 1; j < col + 1; j++) {
                       if (table.table[i][j].empty)
                           db++;
                   }
               }
           }
            if (row==7 && col>0 && col<7){
                for (int i = row-1; i < row; i++) {
                    for (int j = col - 1; j < col + 1; j++) {
                        if (table.table[i][j].empty)
                            db++;
                    }
                }
            }
            if (col==0 && row>0 && row<5){
                for (int i = row-1; i < row + 1; i++) {
                    for (int j = col; j < col + 1; j++) {
                        if (table.table[i][j].empty)
                            db++;
                    }
                }
            }
            if (col==7 && row>0 && row<5){
                for (int i = row-1; i < row + 1; i++) {
                    for (int j = col-1; j < col; j++) {
                        if (table.table[i][j].empty)
                            db++;
                    }
                }
            }
            if(col==0 && row==0){
                if(table.table[row+1][col+1].empty){db++;}
                if(table.table[row+1][col].empty){db++;}
                if(table.table[row][col+1].empty){db++;}
            }
            if(col==0 && row==5){
                if(table.table[row-1][col+1].empty){db++;}
                if(table.table[row-1][col].empty){db++;}
                if(table.table[row][col+1].empty){db++;}
            }
            if(col==7 && row==0){
                if(table.table[row+1][col-1].empty){db++;}
                if(table.table[row+1][col].empty){db++;}
                if(table.table[row][col-1].empty){db++;}
            }
            if(col==7 && row==5){
                if(table.table[row-1][col-1].empty){db++;}
                if(table.table[row-1][col].empty){db++;}
                if(table.table[row][col-1].empty){db++;}
            }
            if(db==0) {
                if (player2.turn) {
                    player1.win = true;
                    System.out.println("Player1 won!");
                }
                if (player1.turn) {
                    player2.win = true;
                    System.out.println("Player2 won!");
                }
            }
        }
    }
}