import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HelperTests {

    @Test
    public void addTest() {
        Helper helper = new Helper();
        int result = helper.add(5, 5);
        Assertions.assertEquals(11, result);
    }
}