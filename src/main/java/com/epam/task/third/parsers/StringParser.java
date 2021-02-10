package com.epam.task.third.parsers;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private static final String STRING_SPLITTER = " ";

    public List<Integer> parse(String data) {

        List<Integer> numbers = new ArrayList<>();
        String[] parts = data.split(STRING_SPLITTER);
        for (String part : parts) {
            int number = Integer.parseInt(part);
            numbers.add(number);
        }
        return numbers;
    }
}
