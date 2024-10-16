import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class CalculationsTest {	
	
	@Test
    public void basicMagic7Test() {
		/* 
		 * assertTrue checks if the actual value (the return value of
		 * your method) is the boolean value true
		 * 
		 * assertFalse checks if the actual value (the return value of
		 * your method) is the boolean value false
		 */
        assertTrue(Calculations.magic7(2, 5));
        assertTrue(Calculations.magic7(7, 9));
        assertTrue(Calculations.magic7(14, 7));
        assertTrue(Calculations.magic7(7, 14));
        assertFalse(Calculations.magic7(5, 6));
        assertFalse(Calculations.magic7(5, 3));
    }
	
	@Test
    public void basicFast12Test() {
        assertTrue(Calculations.fast12(12));
        assertTrue(Calculations.fast12(14));
        assertTrue(Calculations.fast12(10));
        assertFalse(Calculations.fast12(15));
        assertFalse(Calculations.fast12(18));
    }
	
}
