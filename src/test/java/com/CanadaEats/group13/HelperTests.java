import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HelperTests {

    @Test
    public void addTest() {
        Helper helper = new Helper();
        int result = helper.add(10, 10);
        Assertions.assertEquals(20, result);
    }
}