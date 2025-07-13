import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    // Setup method (runs before every test)
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup completed.");
    }

    // Teardown method (runs after every test)
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown completed.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 30;
        int b = 10;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(20, result);
    }
}
