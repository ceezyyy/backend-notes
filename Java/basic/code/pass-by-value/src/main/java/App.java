import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class App {

    @Test
    public void testPrimitives() {

        int x = 1;
        int y = 2;

        assertEquals(x, 1);
        assertEquals(y, 2);

        modifyPrimitives(x, y);

        // Test passed
        assertEquals(x, 1);
        assertEquals(y, 2);

    }

    public void modifyPrimitives(int x, int y) {
        x = 5;
        y = 10;
    }

}
