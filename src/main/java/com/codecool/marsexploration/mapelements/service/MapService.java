package com.codecool.marsexploration.mapelements.service;

import com.codecool.marsexploration.calculators.service.CoordinateCalculator;
import com.codecool.marsexploration.calculators.service.CoordinateCalculatorImpl;
import com.codecool.marsexploration.calculators.service.DimensionCalculator;
import com.codecool.marsexploration.calculators.service.DimensionCalculatorImpl;
import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.configuration.service.ConfigurationProvider;
import com.codecool.marsexploration.configuration.service.MapConfigurationValidator;
import com.codecool.marsexploration.configuration.service.MapConfigurationValidatorImpl;
import com.codecool.marsexploration.mapelements.service.builder.MapElementBuilder;
import com.codecool.marsexploration.mapelements.service.builder.MapElementBuilderImpl;
import com.codecool.marsexploration.mapelements.service.generator.MapElementsGenerator;
import com.codecool.marsexploration.mapelements.service.generator.MapElementsGeneratorImpl;
import com.codecool.marsexploration.mapelements.service.generator.MapGenerator;
import com.codecool.marsexploration.mapelements.service.generator.MapGeneratorImpl;
import com.codecool.marsexploration.mapelements.service.placer.MapElementPlacer;
import com.codecool.marsexploration.mapelements.service.placer.MapElementPlacerImpl;
import com.codecool.marsexploration.output.service.MapFileWriter;
import com.codecool.marsexploration.output.service.MapFileWriterImpl;

import java.io.IOException;

import static com.codecool.marsexploration.Application.WorkDir;
import static com.codecool.marsexploration.Application.random;
import static com.codecool.marsexploration.configuration.service.ConfigurationProvider.getConfiguration;

public class MapService {

    private final DimensionCalculator dimensionCalculator = new DimensionCalculatorImpl();
    private final CoordinateCalculator coordinateCalculator = new CoordinateCalculatorImpl();
    private final MapElementBuilder mapElementFactory = new MapElementBuilderImpl(dimensionCalculator);
    private final MapElementsGenerator mapElementsGenerator = new MapElementsGeneratorImpl(mapElementFactory);
    private final MapConfigurationValidator mapConfigValidator = new MapConfigurationValidatorImpl();
    private final MapElementPlacer mapElementPlacer = new MapElementPlacerImpl();
    private final MapFileWriter mapFileWriter = new MapFileWriterImpl();
    private final MapGenerator mapGenerator = new MapGeneratorImpl(mapElementsGenerator, mapElementPlacer, coordinateCalculator, mapFileWriter);

    public void createAndWriteMaps(int count) throws IOException {
        var mapConfig = getConfiguration();
        var counter = 0;
        var mapNumber = 1;

        while (counter < count) {

            if (this.mapConfigValidator.validate(getConfiguration())) {
                try {
                    System.out.println("Map number " + mapNumber + " was generated: \n");
                    this.mapFileWriter.writeMapFile(this.mapGenerator.generate(mapConfig), WorkDir + "map" + random.nextInt(1, 100));
                    mapConfig = getConfiguration();
                    counter++;
                    mapNumber++;
                } catch (IOException e) {
                    System.err.println("An error occurred while writing the map file: " + e.getMessage());
                }

            } else {
                mapConfig = getConfiguration();
                System.out.println("this map could not be generated");
            }
        }
    }

    class ConfigurationService {
        public MapConfiguration getValidConfiguration() {
            MapConfiguration mapConfig;
            do {
                mapConfig = ConfigurationProvider.getConfiguration();
            } while (!new MapConfigurationValidatorImpl().validate(mapConfig));
            return mapConfig;
        }
    }
}
