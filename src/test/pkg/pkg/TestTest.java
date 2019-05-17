package pkg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pkg.game.PlayerModel;
import pkg.game.Table;

import static org.junit.jupiter.api.Assertions.*;
import static pkg.game.Test.*;

public class TestTest {

    private Table current;
    private Table current2;

    @BeforeEach
    void setUp(){
        current=new Table();
        current.createTable();
    }
    @BeforeEach
    void setUp3(){
        current2=new Table();
        current2.createTable2();

    }

    private PlayerModel player;

    @BeforeEach
    void setUp2(){
        player = new PlayerModel(true,true,false,true,false,2,0);
    }

    @Test
    public void preTest() {
        assertFalse(preCheck(5,5,current, player));
        assertFalse(preCheck(5,4,current, player));
        assertFalse(preCheck(1,2,current, player));
        assertTrue(preCheck(1,0,current, player));
        assertTrue(preCheck(1,1,current,player));
        assertTrue(preCheck(2,1,current,player));
        assertTrue(preCheck(3,1,current,player));
        assertTrue(preCheck(3,0,current,player));
    }
    @Test
    public void deleteTest() {
        assertFalse(deleteCheck(2,0,current));
        assertFalse(deleteCheck(3,7,current));
        assertTrue(deleteCheck(1,1,current));
        assertTrue(deleteCheck(5,7,current));
        assertTrue(deleteCheck(3,4,current));
    }
    @Test
    public void alphabetTest() {
        assertTrue(alphabetCheck("almafa"));
        assertTrue(alphabetCheck("44banán"));
        assertTrue(alphabetCheck("nemleszjo"));
        assertTrue(alphabetCheck("alma"));
        assertTrue(alphabetCheck("34póni"));
        assertFalse(alphabetCheck("1"));
    }
    @Test
    public void winTest(){
        assertTrue(winCheck(3,3,current2));
        assertFalse(winCheck(2,4,current2));
        assertFalse(winCheck(0,0,current2));
        assertFalse(winCheck(3,7,current2));
        assertFalse(winCheck(2,4,current2));
    }
}
