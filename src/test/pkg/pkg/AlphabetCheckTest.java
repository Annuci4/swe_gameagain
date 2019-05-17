package pkg;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static pkg.game.AlphabetCheck.alphabetCheck;

public class AlphabetCheckTest {

    @Test
    public void alphabetTest() {
        assertTrue(alphabetCheck("almafa"));
        assertTrue(alphabetCheck("44banán"));
        assertTrue(alphabetCheck("nemleszjo"));
        assertTrue(alphabetCheck("alma"));
        assertTrue(alphabetCheck("34póni"));
        assertFalse(alphabetCheck("1"));
    }
}