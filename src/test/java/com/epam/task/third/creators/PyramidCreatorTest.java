package com.epam.task.third.creators;

import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Pyramid;
import com.epam.task.third.exceptions.DataException;
import com.epam.task.third.parsers.StringParser;
import com.epam.task.third.validators.impl.PyramidValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class PyramidCreatorTest {

    private static final String FIRST_STRING = "4 5 6 2 4 7 6 2 1 4 7 2";
    private static final String SECOND_STRING = "2q 7w 4 5 1 3 9 5 7 3 6 3";
    private static final String THIRD_STRING = " ";

    private static final List<Integer> VALID_ARRAY = Arrays.asList(4, 5, 6, 2, 4, 7, 6, 2, 1, 4, 7, 2);

    private static final List<String> TEST_ARRAY = Arrays.asList(FIRST_STRING, SECOND_STRING, THIRD_STRING);
    private static final String TEST_DATA = "src/test/resources/pyramids.txt";


    private static DataReader reader;
    private static StringParser parser;
    private static PyramidValidator validator;
    private static PyramidCreator creator;


    @BeforeClass
    public static void init() throws DataException {

        reader = Mockito.mock(DataReader.class);
        when(reader.readData(ArgumentMatchers.anyString())).thenReturn(TEST_ARRAY);

        validator = Mockito.mock(PyramidValidator.class);
        when(validator.isOnlyDigits(FIRST_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(SECOND_STRING)).thenReturn(false);
        when(validator.isOnlyDigits(THIRD_STRING)).thenReturn(false);


        parser = Mockito.mock(StringParser.class);
        when(parser.parse(FIRST_STRING)).thenReturn(VALID_ARRAY);

        when(validator.isValid(VALID_ARRAY)).thenReturn(true);
    }

    @Test
    public void testPyramidCreationProcess() throws DataException {

        creator = new PyramidCreator(reader, parser, validator);

        List<Pyramid> expected = Collections.singletonList(new Pyramid(VALID_ARRAY));

        List<Pyramid> actual = creator.process(TEST_DATA);

        Assert.assertEquals(expected, actual);
    }

}
