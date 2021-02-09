package com.epam.task.third.validators.impl;

import com.epam.task.third.validators.Validator;

import java.util.List;
import java.util.regex.Pattern;

public class PyramidValidator implements Validator {

    @Override
    public boolean isOnlyDigits(String line) {
        return Pattern.matches(DIGIT_PATTERN, line);
    }

    public boolean isValid(List<Integer> data) {
        return data.size() == 12;
    }
}
