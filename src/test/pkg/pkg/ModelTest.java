package pkg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pkg.game.PlayerModel;
import pkg.game.Table;

import static org.junit.jupiter.api.Assertions.*;
import static pkg.game.Model.deleteField;
import static pkg.game.Model.positionChange;

public class ModelTest {

    private Table current;
    @BeforeEach
    void setUp() {
        current = new Table();
        current.createTable();
    }

    private PlayerModel player;
    @BeforeEach
    void setUp2() {
        player = new PlayerModel(true, true, false, true, false, 2,5);
    }

    @Test
    public void positionChangeTest(){
        positionChange(player,current,1,2);
        assertFalse(current.table[1][1].kingWhite);
        assertFalse(current.table[0][0].kingWhite);
        assertTrue(current.table[1][2].kingWhite);
    }

    @Test
    public void deleteFieldTest(){
        deleteField(player,current,1,2);
        assertTrue(current.table[1][2].deleted);
        assertFalse(current.table[1][1].deleted);
        assertFalse(current.table[3][6].deleted);
    }
}
