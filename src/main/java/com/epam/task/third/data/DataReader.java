package com.epam.task.third.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.third.exceptions.DataException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class DataReader {

    private static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> readData(String filename) throws DataException {
        List<String> dataFromFile = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                String stringToValidate = bufferedReader.readLine();
                dataFromFile.add(stringToValidate);
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.ERROR, "Error when closing buffered reader", e);
            }
        }
        return dataFromFile;
    }
}
