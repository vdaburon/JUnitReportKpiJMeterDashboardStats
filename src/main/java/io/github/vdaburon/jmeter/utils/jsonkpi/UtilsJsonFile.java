package io.github.vdaburon.jmeter.utils.jsonkpi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class UtilsJsonFile {
    private static final Logger LOGGER = Logger.getLogger(UtilsJsonFile.class.getName());

    /**
     * Read all lines in a Json file
     *
     * @param fileIn the json file name to read
     * @return a ArrayList of Statistic
     * @throws IOException error when read the json file and mapping
     */
    public static List<Statistic> readJsonFile(String fileIn) throws IOException {

        ArrayList<Statistic> listStats = new ArrayList<Statistic>();
        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get(fileIn));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map> mapStat = new HashMap<String, Map>();

        mapStat = objectMapper.readValue(jsonData, HashMap.class);

        LOGGER.fine("mapStat=" + mapStat);
        Iterator<Map.Entry<String, Map>> iterator = mapStat.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map> entry = iterator.next();
            LOGGER.fine(entry.getKey() + ":" + entry.getValue());
            Statistic stat = new Statistic(entry.getValue());
            listStats.add(stat);
        }
        return listStats;
    }
}
