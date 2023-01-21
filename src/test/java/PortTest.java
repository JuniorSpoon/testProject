import org.example.Port;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortTest {

    @Test
    public void sequenceNumbersTest() {
        String[] array = new String[]{"1-5,7,9-11"};
        Port port = new Port(array);
        int[] result = port.arrayToSequenceNumbers();
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 7, 9, 10, 11}, result);


    }

    @Test
    public void sequenceNumbersTest2() {
        String[] array = new String[]{"6-10,12,18-20"};
        Port port = new Port(array);
        int[] result = port.arrayToSequenceNumbers();
        Assert.assertArrayEquals(new int[]{6, 7, 8, 9, 10, 12, 18, 19, 20}, result);
    }

    @Test
    public void sequenceNumbersTest3() {
        String[] array = new String[]{"18-20"};
        Port port = new Port(array);
        int[] result = port.arrayToSequenceNumbers();
        Assert.assertArrayEquals(new int[]{18, 19, 20}, result);
    }

    @Test
    public void sequenceNumbersTest4() {
        String[] array = new String[]{"10"};
        Port port = new Port(array);
        int[] result = port.arrayToSequenceNumbers();
        Assert.assertArrayEquals(new int[]{10}, result);
    }

    @Test
    public void sequenceNumbersTest5() {
        String[] array = {"6-10", "12-14"};
        Port port = new Port(array);
        int[] result = port.arrayToSequenceNumbers();
        Assert.assertArrayEquals(new int[]{6, 7, 8, 9, 10, 12, 13, 14}, result);
    }

    @Test
    public void sequenceNumbersTest6() {
        String[] array = {"1,3-5", "2", "3-4"};
        Port port = new Port(array);
        int[] result = port.arrayToSequenceNumbers();
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 4, 4, 5}, result);
    }

    @Test
    public void arrayToShuffledSequenceArrayTest() {
        String[] array = {"1,3-5", "2", "3-4"};
        Port port = new Port(array);
        List<List<Integer>> result = port.arrayToShuffledSequenceArray();
        List<List<Integer>> expected = new ArrayList<>() {{
            add(Arrays.asList(1, 2, 3));
            add(Arrays.asList(1, 2, 4));
            add(Arrays.asList(3, 2, 3));
            add(Arrays.asList(3, 2, 4));
            add(Arrays.asList(4, 2, 3));
            add(Arrays.asList(4, 2, 4));
            add(Arrays.asList(5, 2, 3));
            add(Arrays.asList(5, 2, 4));
        }};
        Assert.assertEquals(expected, result);
    }

    @Test
    public void arrayToShuffledSequenceArrayTest2() {
        String[] array = {"7-12", "8", "10-12", "6"};
        Port port = new Port(array);
        List<List<Integer>> result = port.arrayToShuffledSequenceArray();
        List<List<Integer>> expected = new ArrayList<>() {{
            add(Arrays.asList(7, 8, 10, 6));
            add(Arrays.asList(7, 8, 11, 6));
            add(Arrays.asList(7, 8, 12, 6));
            add(Arrays.asList(8, 8, 10, 6));
            add(Arrays.asList(8, 8, 11, 6));
            add(Arrays.asList(8, 8, 12, 6));
            add(Arrays.asList(9, 8, 10, 6));
            add(Arrays.asList(9, 8, 11, 6));
            add(Arrays.asList(9, 8, 12, 6));
            add(Arrays.asList(10, 8, 10, 6));
            add(Arrays.asList(10, 8, 11, 6));
            add(Arrays.asList(10, 8, 12, 6));
            add(Arrays.asList(11, 8, 10, 6));
            add(Arrays.asList(11, 8, 11, 6));
            add(Arrays.asList(11, 8, 12, 6));
            add(Arrays.asList(12, 8, 10, 6));
            add(Arrays.asList(12, 8, 11, 6));
            add(Arrays.asList(12, 8, 12, 6));
        }};
        Assert.assertEquals(expected, result);
    }
}
