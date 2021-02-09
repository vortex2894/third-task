package com.epam.task.third.data;

import com.epam.task.third.exceptions.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final static String TEST_DATA = "src/test/resources/testData.txt";
    private final static String INVALID_DATA = "src/test/resources/hello.txt";
    private final static List<String> EXPECTED = Arrays.asList("3t 4 1", "0 0 0 0", "1 3 7", "6 5 8 9");

    private final DataReader reader = new DataReader();

    @Test
    public void testReadDataFromFile() throws DataException {
        List<String> actual = reader.readData(TEST_DATA);
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test(expected = DataException.class)
    public void testMethodThrowsDataException() throws DataException {
        List<String> actual = reader.readData(INVALID_DATA);
    }
}
