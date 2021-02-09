package com.epam.task.third.creators;

import com.epam.task.third.exceptions.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.parsers.StringParser;
import com.epam.task.third.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class Creator {

    private final DataReader reader;
    private final StringParser parser;
    protected Validator validator;

    public Creator(final DataReader reader, final StringParser parser, final Validator validator) {
        this.reader = reader;
        this.parser = parser;
        this.validator = validator;
    }

    List<List<Integer>> preProcess(String filename) throws DataException {
        List<List<Integer>> result = new ArrayList<>();

        List<String> stringsToValidate = null;
        try {
            stringsToValidate = reader.readData(filename);
        } catch (DataException e) {
            throw new DataException(e.getMessage(), e);
        }
        List<Integer> coordinates;
        for(String line : stringsToValidate){
            if (validator.isOnlyDigits(line)){
                coordinates = parser.parse(line);
                result.add(coordinates);
            }
        }
        return result;
    }
}
