package io.github.vdaburon.jmeter.utils.jsonkpi;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilsCsvFile {
    /**
     * Read all lines in a csv file
     * @param fileIn the csv file name to read
     * @return a ArrayList of CSVRecord contains all lines
     * @throws IOException error when read the CSV file
     */
    public static List<CSVRecord> readCsvFile(String fileIn) throws IOException {
        Reader in = new FileReader(fileIn);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);

        List<CSVRecord> listRecordsBetweenFirstAndLast = new ArrayList();

        for (CSVRecord record : records) {
            listRecordsBetweenFirstAndLast.add(record);
        }
        in.close();
        return listRecordsBetweenFirstAndLast;
    }
}
