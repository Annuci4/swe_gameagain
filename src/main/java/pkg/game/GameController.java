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
public class GameController {

    private static Logger logger = LoggerFactory.getLogger(GameController.class);

    public PlayerModel player1 = new PlayerModel(true, true, false, true, false, 2,0);
    public PlayerModel player2 = new PlayerModel(false, false, false, false, true,3,7);

    Table table = new Table();
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
        System.out.println("A fekete király neve: ");
        String player2_name=scan.nextLine();
        player2.name=player2_name;

        table.createTable();
        View.print(table);
        int row;
        int col;
        int del_x;
        int del_y;
        System.out.println("A játékot "+player1_name+" kezdi!");

        while (!player1.win && !player2.win) {

            if (player1.turn) {
                System.out.println("Az fehér király lép!");
            }else{
                System.out.println("A fekete király lép!");
            }
            System.out.println("Kérlek add meg az X és Y koordinátákat.");
            while(true) {
                while (true) {
                    System.out.print("X: ");
                    helper = scan.next();
                    if (Test.alphabetCheck(helper)){
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    logger.error("Invalid character");}
                    if (!Test.alphabetCheck(helper)) {
                        row = Integer.parseInt(helper);
                        if(player1.turn)
                            player1.second=row;
                        else
                            player2.second=row;
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
                    if (Test.alphabetCheck(helper)){
                        System.out.println("A-a...Ez nem lesz jó!\"");
                    logger.error("Invalid character");}
                    if (!Test.alphabetCheck(helper)) {
                        col = Integer.parseInt(helper);
                        if(player1.turn)
                            player1.second=col;
                        else
                            player2.second=col;
                        if (col < 0 || col > 7) {
                            System.out.println("A-a...Ez nem lesz jó!\"");
                            logger.error("Invalid number");
                        } else {
                            break;
                        }
                    }
                }
                if (player1.turn) {
                    if (Test.preCheck(row, col, table, player1)) {
                        Model.positionChange(player1, table, row, col);
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
                    if (Test.preCheck(row, col, table, player2)) {
                        Model.positionChange(player2, table, row, col);
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
            while(true)
            {
                while(true) {
                    System.out.print("Delete x: ");
                    helper = scan.next();
                    if (Test.alphabetCheck(helper)){
                        System.out.println("A-a...Ez nem lesz jó!\"");
                     logger.error("Invalid character.");}
                    if (!Test.alphabetCheck(helper)) {
                        del_x = Integer.parseInt(helper);
                        if (del_x < 0 || del_x > 7) {
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
                    if (Test.alphabetCheck(helper)){
                        System.out.println("A-a...Ez nem lesz jó!");
                        logger.error("Invalid character.");}
                    if (!Test.alphabetCheck(helper)) {
                        del_y = Integer.parseInt(helper);
                        if (del_y < 0 || del_y > 7) {
                            System.out.println("A-a...Ez nem lesz jó!\"");
                            logger.error("Invalid number.");
                        } else {
                            break;
                        }
                    }
                }
                if (player1.delete_turn) {
                    if (Test.deleteCheck(del_x, del_y, table)) {
                        Model.deleteField(player1, table, del_x, del_y);
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
                    if (Test.deleteCheck(del_x, del_y, table)) {
                        Model.deleteField(player1, table, del_x, del_y);
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
            if (Test.winCheck(player1.first,player1.second,table)) {
                    player2.win = true;
                    System.out.println("Gratulálok " + player2_name + "!");
                    logger.info("Player1 won!");
            }
            if (Test.winCheck(player2.first,player2.second,table)) {
                    player1.win = true;
                    System.out.println("Gratulálok " + player1_name + "!");
                    logger.info("Player2 won!");
            }

            }

                GameResult gs;
               gs = createGameResult();
               creator.persist(gs);

            for (GameResult gr : creator.findBest(5)) {
         System.out.println(gr.getName()+" " + "\t"+ gr.getCreated());
            }

        }

    private GameResult createGameResult(){
        return GameResult.builder()
                .name(player1.name)
                .name2(player2.name)
                .build();
    }
}