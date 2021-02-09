package com.epam.task.third.creators;

import com.epam.task.third.exceptions.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Point;

import java.util.ArrayList;
import java.util.List;

import com.epam.task.third.parsers.StringParser;
import com.epam.task.third.validators.Validator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PointCreator extends Creator {

    private final static Logger LOGGER = Logger.getLogger(PyramidCreator.class);

    public PointCreator(DataReader reader, StringParser parser, Validator validator) {
        super(reader, parser, validator);
    }

    public List<Point> process(String filename) throws DataException {
        List<Point> result = new ArrayList<>();
        List<List<Integer>> data = preProcess(filename);
        for (List<Integer> coordinates : data) {
            if (validator.isValid(coordinates)) {
                Point point = new Point(coordinates);
                result.add(point);
            }
        }
        LOGGER.log(Level.INFO, "Points successfully created!");
        return result;
    }
}
