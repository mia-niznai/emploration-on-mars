package com.codecool.marsexploration.output.service;

import com.codecool.marsexploration.mapelements.model.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MapFileWriterImplTest {

    private MapFileWriter mapFileWriter;
    private BufferedWriter mockBufferedWriter;

    @BeforeEach
    public void setUp() {
        mockBufferedWriter = mock(BufferedWriter.class);
        mapFileWriter = new MapFileWriter() {
            @Override
            public void writeMapFile(Map map, String file) throws IOException {
                mockBufferedWriter.write(map.toString());
            }
        };
    }

    @Test
    public void testWriteMapFile() throws IOException {
        Map mockMap = mock(Map.class);
        String fileName = "test_map.txt";

        mapFileWriter.writeMapFile(mockMap, fileName);

        verify(mockBufferedWriter, times(1)).write(mockMap.toString());
    }
}
