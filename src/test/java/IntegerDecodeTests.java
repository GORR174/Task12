import org.junit.Assert;
import org.junit.Test;

public class IntegerDecodeTests {
    @Test
    public void decimalTest() {
        int result = Integer.decode("123");
        Assert.assertEquals(result, 123);

        result = Integer.decode("12");
        Assert.assertEquals(result, 12);

        result = Integer.decode(String.valueOf(Integer.MAX_VALUE));
        Assert.assertEquals(result, Integer.MAX_VALUE);
    }

    @Test
    public void negativeDecimalTest() {
        int result = Integer.decode("-123");
        Assert.assertEquals(result, -123);

        result = Integer.decode("-12");
        Assert.assertEquals(result, -12);

        result = Integer.decode(String.valueOf(Integer.MIN_VALUE));
        Assert.assertEquals(result, Integer.MIN_VALUE);
    }

    @Test
    public void hexTest() {
        int result = Integer.decode("#FF");
        Assert.assertEquals(result, 255);

        result = Integer.decode("0xF");
        Assert.assertEquals(result, 15);

        result = Integer.decode("0XA");
        Assert.assertEquals(result, 10);
    }

    @Test
    public void negativeHexTest() {
        int result = Integer.decode("-#FF");
        Assert.assertEquals(result, -255);

        result = Integer.decode("-0xF");
        Assert.assertEquals(result, -15);

        result = Integer.decode("-0XA");
        Assert.assertEquals(result, -10);
    }

    @Test
    public void octalTest() {
        int result = Integer.decode("011");
        Assert.assertEquals(result, 9);
    }

    @Test
    public void negativeOctalTest() {
        int result = Integer.decode("-011");
        Assert.assertEquals(result, -9);
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() {
        int result = Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void notANumberTest() {
        int result = Integer.decode("null");
    }

    @Test(expected = NumberFormatException.class)
    public void emptyTest() {
        int result = Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void wrongPositionTest() {
        int result = Integer.decode("+-3");
    }
}