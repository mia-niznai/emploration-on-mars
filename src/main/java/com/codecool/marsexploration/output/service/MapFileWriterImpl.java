package com.codecool.marsexploration.output.service;

import com.codecool.marsexploration.mapelements.model.Map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MapFileWriterImpl implements MapFileWriter {

    public void writeMapFile(Map map, String file) throws IOException {

        String mapString = map.toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(mapString);

        writer.close();
    }
}
