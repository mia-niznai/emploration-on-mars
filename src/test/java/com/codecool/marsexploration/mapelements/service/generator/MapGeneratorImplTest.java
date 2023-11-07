import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import com.codecool.marsexploration.calculators.service.CoordinateCalculator;
import com.codecool.marsexploration.mapelements.model.MapElement;
import com.codecool.marsexploration.mapelements.service.generator.MapElementsGenerator;
import com.codecool.marsexploration.mapelements.service.generator.MapGeneratorImpl;
import com.codecool.marsexploration.mapelements.service.placer.MapElementPlacer;
import com.codecool.marsexploration.output.service.MapFileWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.mapelements.model.Map;

import java.util.Collections;
import java.util.List;

public class MapGeneratorImplTest {

    private MapElementsGenerator elementsGenerator;
    private MapElementPlacer elementPlacer;
    private CoordinateCalculator coordCalculator;
    private MapFileWriter fileWriter;

    private MapGeneratorImpl mapGenerator;

    @BeforeEach
    void setUp() {
        elementsGenerator = mock(MapElementsGenerator.class);
        elementPlacer = mock(MapElementPlacer.class);
        coordCalculator = mock(CoordinateCalculator.class);
        fileWriter = mock(MapFileWriter.class);

        mapGenerator = new MapGeneratorImpl(elementsGenerator, elementPlacer, coordCalculator, fileWriter);
    }
    @Test
    void testGenerate_SuccessfulGeneration() {

        MapConfiguration mapConfig = new MapConfiguration(10, 0.2, Collections.emptyList());
        List<MapElement> mapElements = Collections.singletonList(mock(MapElement.class));

        when(elementsGenerator.createAll(mapConfig)).thenReturn(mapElements);
        when(elementPlacer.canPlaceElement(any(), any(), any())).thenReturn(true);

        Map generatedMap = mapGenerator.generate(mapConfig);

        assertTrue(generatedMap.isSuccessfullyGenerated());
    }


}
