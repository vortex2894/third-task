package com.epam.task.third.validators;

import java.util.List;

public interface Validator {

    String DIGIT_PATTERN = "^[0-9 ]+$";

    boolean isOnlyDigits(String line);

    boolean isValid(List<Integer> data);

}
