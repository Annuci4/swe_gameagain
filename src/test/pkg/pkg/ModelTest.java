package pkg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pkg.game.playerModel;
import pkg.game.table;
import javax.persistence.Table;
import java.util.function.BooleanSupplier;
import static org.junit.jupiter.api.Assertions.*;
import static pkg.game.Model.doSomeDelete;
import static pkg.game.Model.doSomeMagic;
import static pkg.game.Test.*;

public class ModelTest {

    private table current;
    @BeforeEach
    void setUp() {
        current = new table();
        current.createTable();
    }

    private playerModel player;
    @BeforeEach
    void setUp2() {
        player = new playerModel(true, true, false, true, false);
    }

    @Test
    public void dosomemagicTest(){
        doSomeMagic(player,current,1,2);
        assertFalse(current.table[1][1].kingWhite);
        assertFalse(current.table[0][0].kingWhite);
        assertTrue(current.table[1][2].kingWhite);
    }

    @Test
    public void dosomedeleteTest(){
        doSomeDelete(player,current,1,2);
        assertFalse(current.table[1][1].kingWhite);
        assertFalse(current.table[3][6].kingWhite);
        assertFalse(current.table[1][2].kingWhite);
    }
}
