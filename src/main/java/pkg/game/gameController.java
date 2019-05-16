package pkg.game;

import java.util.*;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pkg.results.GameResult;
import pkg.results.GameResultDao;
import util.guice.PersistenceModule;

/**
 * GameLogic.
 */
public class gameController {

    private static Logger logger = LoggerFactory.getLogger(gameController.class);

    public playerModel player1 = new playerModel(true, true, false, true, false);
    public playerModel player2 = new playerModel(false, false, false, false, true);

    table table = new table();
    String helper;
    
    public void startGame() {
        Injector injector = Guice.createInjector(new PersistenceModule("result"));
        GameResultDao creator = injector.getInstance(GameResultDao.class);

        Scanner scan = new Scanner(System.in);
        player1.whiteKing = true;
        player2.blackKing = true;
        System.out.println("A fehér király neve: ");
        String player1_name=scan.nextLine();
        player1.name=player1_name;
        System.out.println("A fehér király neve: ");
        String player2_name=scan.nextLine();
        player2.name=player2_name;
        //player plyr1=creator.createPlayer(player1_name,0);
        //player plyr2=creator.createPlayer(player2_name,0);

        table.createTable();
        View.print(table);
        int row;
        int col;
        int del_x;
        int del_y;
        System.out.println("A játékot "+player1_name+" kezdi!");

        while (!player1.win && !player2.win) {
            System.out.println("Kérlek add meg az X és Y koordinátákat.");
            while(true) {
                while (true) {
                    System.out.print("X: ");
                    helper = scan.next();
                    if (Test.AlphabetTest(helper)){
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    logger.error("Invalid character");}
                    if (!Test.AlphabetTest(helper)) {
                        row = Integer.parseInt(helper);
                        if (row < 0 || row > 5) {
                            System.out.println("A-a...Ez nem lesz jó!\"");
                            logger.error("Invalid number");
                        } else {
                            break;
                        }
                    }
                }
                while (true) {
                    System.out.print("Y: ");
                    helper = scan.next();
                    if (Test.AlphabetTest(helper)){
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    logger.error("Invalid character");}
                    if (!Test.AlphabetTest(helper)) {
                        col = Integer.parseInt(helper);
                        if (col < 0 || col > 7) {
                            System.out.println("A-a...Ez nem lesz jó!\"");
                            logger.error("Invalid number");
                        } else {
                            break;
                        }
                    }
                }
                if (player1.turn) {
                    if (Test.PreTest(row, col, table, player1)) {
                        Model.doSomeMagic(player1, table, row, col);
                        player1.turn = false;
                        player2.turn = true;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("Erre a mezőre nem léphet!");
                        logger.error("Invalid field.");
                        player1.turn = true;
                        player2.turn = false;
                    }
                } else if (player2.turn) {
                    if (Test.PreTest(row, col, table, player2)) {
                        Model.doSomeMagic(player2, table, row, col);
                        player1.turn = true;
                        player2.turn = false;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("Erre a mezőre nem léphet!");
                        logger.error("Invalid field.");
                        player1.turn = false;
                        player2.turn = true;
                    }
                }
            }
            System.out.println("Kérlek add meg a törlendő mező koordinátáit");
            while(true) {
                while(true) {
                    System.out.print("Delete x: ");
                    helper = scan.next();
                    if (Test.AlphabetTest(helper)){
                        System.out.println("A-a...Ez nem lesz jó!\"");
                     logger.error("Invalid character.");}
                    if (!Test.AlphabetTest(helper)) {
                        del_x = Integer.parseInt(helper);
                        if (col < 0 || col > 7) {
                            System.out.println("A-a...Ez nem lesz jó!\"");
                             logger.error("Invalid number.");
                        } else {
                            break;
                        }
                    }
                }
                while(true) {
                    System.out.print("Delete y: ");
                    helper = scan.next();
                    if (Test.AlphabetTest(helper)){
                        System.out.println("A-a...Ez nem lesz jó!");
                        logger.error("Invalid character.");}
                    if (!Test.AlphabetTest(helper)) {
                        del_y = Integer.parseInt(helper);
                        if (col < 0 || col > 7) {
                            System.out.println("A-a...Ez nem lesz jó!\"");
                            logger.error("Invalid number.");
                        } else {
                            break;
                        }
                    }
                }
                if (player1.delete_turn) {
                    if (Test.DeleteTest(del_x, del_y, table)) {
                        Model.doSomeDelete(player1, table, del_x, del_y);
                        player1.delete_turn = false;
                        player2.delete_turn = true;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("Ezt a mezőt nem lehet törölni!");
                        logger.error("Invalid field.");
                        player1.delete_turn = true;
                        player2.delete_turn = false;
                    }
                } else if (player2.delete_turn) {
                    if (Test.DeleteTest(del_x, del_y, table)) {
                        Model.doSomeDelete(player1, table, del_x, del_y);
                        player1.delete_turn = true;
                        player2.delete_turn = false;
                        View.print(table);
                        break;
                    } else {
                        System.out.println("Ezt a mezőt nem lehet törölni!");
                        logger.error("Invalid field.");
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
                if(table.table[1][1].empty){db++;}
                if(table.table[1][0].empty){db++;}
                if(table.table[0][1].empty){db++;}
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
                if (player1.delete_turn) {
                    player2.win = true;
                    System.out.println("Gratulálok " + player2_name + "!");
                    logger.info("Player1 won!");
                }
                if (player2.delete_turn) {
                    player1.win = true;
                    System.out.println("Gratulálok " + player1_name + "!");
                    logger.info("Player2 won!");
                }

            }
                GameResult gs;
                gs = createGameResult();
                creator.persist(gs);


        }


    }
    private GameResult createGameResult(){
        return GameResult.builder()
                .name(player1.name)
                .name2(player2.name)
                .build();
    }
}