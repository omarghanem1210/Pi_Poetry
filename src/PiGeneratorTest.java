import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    private static final String PI_FIRST_HUNDRED = "243f6a8885a308d313198a2e03707344a4093822299f31d0082efa98ec4e"
            + "6c89452821e638d01377be5466cf34e90c6cc0ac";

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
        assertEquals(1, PiGenerator.powerMod(-2, 6, 7));
    }

    @Test
    public void negativeTest1(){
        assertEquals(4, PiGenerator.powerMod(-2, 6, -5));
    }

    @Test
    public void largeNumberTest(){
        assertEquals(448, PiGenerator.powerMod(4, 17, 576));
    }

    @Test
    public void onePrecisionTest(){
        assertEquals(PI_FIRST_HUNDRED.substring(0, 1), Integer.toHexString(PiGenerator.computePiInHex(1)[0]));
    }

    @Test
    public void tenPrecisionTest(){
        int[] list = PiGenerator.computePiInHex(10);
        for (int i = 0; i < 10; i++){
            assertEquals(PI_FIRST_HUNDRED.substring(i, i+1), Integer.toHexString(list[i]));
        }
    }

    @Test
    public void hundredPrecisionTest(){
        for (int i = 0; i < 100; i++){
            int[] list = PiGenerator.computePiInHex(100);
            assertEquals(PI_FIRST_HUNDRED.substring(i, i+1), Integer.toHexString(list[i]));
        }

    }
}
