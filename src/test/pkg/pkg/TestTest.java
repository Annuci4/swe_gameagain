package pkg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pkg.game.PlayerModel;
import pkg.game.Table;

import static org.junit.jupiter.api.Assertions.*;
import static pkg.game.Test.*;

public class TestTest {

    private Table current;

    @BeforeEach
    void setUp(){
        current=new Table();
        current.createTable();
    }

    private PlayerModel player;

    @BeforeEach
    void setUp2(){
        player = new PlayerModel(true,true,false,true,false);
    }
    @Test
    public void preTest() {
        assertFalse(PreTest(5,5,current, player));
        assertFalse(PreTest(5,4,current, player));
        assertFalse(PreTest(1,2,current, player));
        assertTrue(PreTest(1,0,current, player));
        assertTrue(PreTest(1,1,current,player));
        assertTrue(PreTest(2,1,current,player));
        assertTrue(PreTest(3,1,current,player));
        assertTrue(PreTest(3,0,current,player));
    }
    @Test
    public void deleteTest() {
        assertFalse(DeleteTest(2,0,current));
        assertFalse(DeleteTest(3,7,current));
        assertTrue(DeleteTest(1,1,current));
        assertTrue(DeleteTest(5,7,current));
        assertTrue(DeleteTest(3,4,current));
    }
    @Test
    public void alphabetTest() {
        assertTrue(AlphabetTest("almafa"));
        assertTrue(AlphabetTest("44banán"));
        assertTrue(AlphabetTest("nemleszjo"));
        assertTrue(AlphabetTest("alma"));
        assertTrue(AlphabetTest("34póni"));
        assertFalse(AlphabetTest("1"));
    }
}
