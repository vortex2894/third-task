package com.epam.task.third.creators;

import com.epam.task.third.exceptions.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Pyramid;
import com.epam.task.third.parsers.StringParser;
import com.epam.task.third.validators.Validator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PyramidCreator extends Creator {

    private static final Logger LOGGER = Logger.getLogger(PyramidCreator.class);

    public PyramidCreator(DataReader reader, StringParser parser, Validator validator) {
        super(reader, parser, validator);
    }

    public List<Pyramid> process(String filename) throws DataException {
        List<Pyramid> result = new ArrayList<>();
        List<List<Integer>> data = preProcess(filename);
        for (List<Integer> coordinates : data) {
            if (validator.isValid(coordinates)) {
                Pyramid pyramid = new Pyramid(coordinates);
                result.add(pyramid);
            }
        }
        LOGGER.log(Level.INFO, "Pyramids successfully created!");
        return result;
    }

}
