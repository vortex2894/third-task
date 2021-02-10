package com.epam.task.third.creators;

import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Point;
import com.epam.task.third.exceptions.DataException;
import com.epam.task.third.parsers.StringParser;
import com.epam.task.third.validators.impl.PyramidValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class PointCreatorTest {

    private final static String FIRST_STRING = "3t 4 1";
    private final static String SECOND_STRING = "0 0 0 0";
    private final static String THIRD_STRING = "1 3 7";
    private final static String FOURTH_STRING = "6 5 8 9";

    private final static List<Integer> FIRST_POINT_ARRAY = Arrays.asList(0, 0, 0, 0);
    private final static List<Integer> SECOND_POINT_ARRAY = Arrays.asList(1, 3, 7);
    private final static List<Integer> THIRD_POINT_ARRAY = Arrays.asList(6, 5, 8, 9);

    private final static List<String> TEST_ARRAY = Arrays.asList(FIRST_STRING, SECOND_STRING, THIRD_STRING, FOURTH_STRING);
    private final static String TEST_DATA = "src/test/resources/testDataForPoints.txt";

    private static DataReader reader;
    private static StringParser parser;
    private static PyramidValidator validator;
    private static PointCreator creator;

    @BeforeClass
    public static void init() throws DataException {

        reader = Mockito.mock(DataReader.class);
        when(reader.readData(ArgumentMatchers.anyString())).thenReturn(TEST_ARRAY);

        validator = Mockito.mock(PyramidValidator.class);
        when(validator.isOnlyDigits(FIRST_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(SECOND_STRING)).thenReturn(false);
        when(validator.isOnlyDigits(THIRD_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(FOURTH_STRING)).thenReturn(true);

        parser = Mockito.mock(StringParser.class);
        when(parser.parse(FIRST_STRING)).thenReturn(FIRST_POINT_ARRAY);
        when(parser.parse(THIRD_STRING)).thenReturn(SECOND_POINT_ARRAY);
        when(parser.parse(FOURTH_STRING)).thenReturn(THIRD_POINT_ARRAY);

        when(validator.isValid(FIRST_POINT_ARRAY)).thenReturn(true);
        when(validator.isValid(SECOND_POINT_ARRAY)).thenReturn(false);
        when(validator.isValid(THIRD_POINT_ARRAY)).thenReturn(true);

    }

    @Test
    public void testPointCreationProcess() throws DataException {

        creator = new PointCreator(reader, parser, validator);

        List<Point> expected = Arrays.asList(new Point(FIRST_POINT_ARRAY), new Point(THIRD_POINT_ARRAY));

        List<Point> actual = creator.process(TEST_DATA);

        Assert.assertEquals(expected, actual);
    }
}
