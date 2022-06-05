import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicTest(){
        assertEquals(8, PiGenerator.powerMod(8, 3, 9));
    }

    @Test
    public void zeroTest(){
        assertEquals(0, PiGenerator.powerMod(0, 6, 5));
    }

    @Test
    public void unityTest(){
        assertEquals(1, PiGenerator.powerMod(3, 1, 2));
    }

    @Test
    public void negativeTest(){
        assertEquals(6, PiGenerator.powerMod(-2, 6, 7));
    }

    @Test
    public void negativeTest1(){
        assertEquals(-4, PiGenerator.powerMod(-2, 6, -5));
    }
}
