import org.example.Main;
import org.junit.jupiter.api.*;

public class MainTest {
    Main main;

    @BeforeAll
    static void setup() {
        System.out.println("run this once before all tests");
    }

    @BeforeEach
    void init() {
        System.out.println("run this before each test");
        main = new Main();
    }

    @DisplayName("name of a test")
    @Test
    void testMain() {
        String actuallyReturnedString = main.returnString();
        Assertions.assertEquals("string", actuallyReturnedString);
    }
}
