package com.codecool.marsexploration.mapelements.service.generator;

import com.codecool.marsexploration.calculators.model.Coordinate;
import com.codecool.marsexploration.calculators.service.CoordinateCalculator;
import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.mapelements.model.Map;
import com.codecool.marsexploration.mapelements.model.MapElement;
import com.codecool.marsexploration.mapelements.service.placer.MapElementPlacer;
import com.codecool.marsexploration.output.service.MapFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGeneratorImpl implements MapGenerator {

    private final MapElementsGenerator elementsGenerator;
    private final MapElementPlacer elementPlacer;
    private final CoordinateCalculator coordinateCalculator;
    private final MapFileWriter fileWriter;
    private final Random random = new Random();

    public MapGeneratorImpl(MapElementsGenerator elementsGenerator, MapElementPlacer elementPlacer,
                            CoordinateCalculator coordCalculator, MapFileWriter fileWriter) {
        this.elementsGenerator = elementsGenerator;
        this.elementPlacer = elementPlacer;
        this.coordinateCalculator = coordCalculator;
        this.fileWriter = fileWriter;
    }

    @Override
    public Map generate(MapConfiguration mapConfig) {
        String[][] mapRepresentation = new String[mapConfig.mapSize()][mapConfig.mapSize()];
        Map generatedMap = new Map(mapRepresentation);
        List<MapElement> listOfMapElements = new ArrayList<>();
        elementsGenerator.createAll(mapConfig).forEach(listOfMapElements::add);

        for (int i = 0; i < mapRepresentation.length; i++) {
            for (int j = 0; j < mapRepresentation[i].length; j++) {
                mapRepresentation[i][j] = "";
            }
        }

        for (MapElement mapElement : listOfMapElements) {
            List<Coordinate> positions;
            if (mapElement.getPreferredLocationSymbol() == null) {
                positions = new ArrayList<>();
                for (int i = 0; i < mapRepresentation.length; i++) {
                    for (int j = 0; j < mapRepresentation[i].length; j++) {
                        if (elementPlacer.canPlaceElement(mapElement, mapRepresentation, new Coordinate(i, j))) {
                            positions.add(new Coordinate(i, j));
                        }
                    }
                }
            } else {
                positions = new ArrayList<>();
                String symbol = mapElement.getPreferredLocationSymbol();
                for (int i = 0; i < mapRepresentation.length; i++) {
                    for (int j = 0; j < mapRepresentation[i].length; j++) {
                        if (mapRepresentation[i][j].equals(symbol)) {
                            positions.add(new Coordinate(i, j));
                        }
                    }
                }
            }

            if (!positions.isEmpty()) {
                int randomPositionIndex = positions.size() > 1 ? random.nextInt(positions.size()) : 0;
                elementPlacer.placeElement(mapElement, mapRepresentation, positions.get(randomPositionIndex));
                generatedMap.setSuccessfullyGenerated(true);
            } else {
                generatedMap.setSuccessfullyGenerated(false);
            }
        }

        System.out.println("This is the generated map: ");
        System.out.println(generatedMap);

        return generatedMap;
    }

}
