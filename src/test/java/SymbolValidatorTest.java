import org.junit.Test;

import static org.junit.Assert.*;

public class SymbolValidatorTest {

    @Test
    public void wrongLength() throws Exception {
        assertFalse(SymbolValidator.isValid("Boron", "B"));
        assertTrue(SymbolValidator.isValid("Boron", "Bo"));
        assertFalse(SymbolValidator.isValid("Boron", "Bor"));
    }

    @Test
    public void missingLetter() throws Exception {
        assertFalse(SymbolValidator.isValid("Mercury", "Hg"));
        assertTrue(SymbolValidator.isValid("Mercury", "Cy"));
    }

    @Test
    public void wrongOrder() throws Exception {
        assertFalse(SymbolValidator.isValid("Silver", "Rv"));
        assertTrue(SymbolValidator.isValid("Magnesium", "Ma"));
        assertTrue(SymbolValidator.isValid("Magnesium", "Am"));
    }

    @Test
    public void sameLetters() throws Exception {
        assertFalse(SymbolValidator.isValid("Xenon", "Xx"));
        assertFalse(SymbolValidator.isValid("Xenon", "Oo"));
        assertTrue(SymbolValidator.isValid("Xenon", "Nn"));
    }

    @Test
    public void examples() throws Exception {
        assertTrue(SymbolValidator.isValid("Spenglerium", "Ee"));
        assertTrue(SymbolValidator.isValid("Zeddemorium", "Zr"));
        assertTrue(SymbolValidator.isValid("Venkmine", "Kn"));
        assertFalse(SymbolValidator.isValid("Stantzon", "Zt"));
        assertFalse(SymbolValidator.isValid("Melintzum", "Nn"));
        assertFalse(SymbolValidator.isValid("Tullium", "Ty"));
    }

    @Test
    public void bonusChallenge1() throws Exception {
        assertEquals("Ei", SymbolValidator.firstValidSymbol("Gozerium"));
        assertEquals("Ie", SymbolValidator.firstValidSymbol("Slimyrine"));
    }

    @Test
    public void bonusChallenge2() throws Exception {
        assertEquals(11, SymbolValidator.distinctValidSymbolsCount("Zuulon"));
    }
}