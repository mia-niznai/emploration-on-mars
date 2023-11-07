package com.codecool.marsexploration.mapelements.service.builder;

import com.codecool.marsexploration.calculators.service.DimensionCalculator;
import com.codecool.marsexploration.mapelements.model.MapElement;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class MapElementBuilderImpl implements MapElementBuilder{

    final DimensionCalculator dimensionCalculator;
    final Random random;

    public MapElementBuilderImpl (DimensionCalculator dimensionCalculator) {
        this.dimensionCalculator = dimensionCalculator;
        this.random = new Random();
    }

    public MapElement build(int size, String symbol, String name, int dimensionGrowth, String preferredLocationSymbol) {

        var elementDimension = dimensionCalculator.calculateDimension(size, dimensionGrowth);
        String[][] representation = new String [elementDimension][elementDimension];
        int counter = 0;

        for (int i = 0; i < representation.length; i++) {
            for (int j = 0; j < representation[i].length; j++) {
                representation[i][j] = "";
            }
        }
        while (counter < size) {

            var row = random.nextInt(0, elementDimension);
            var column = random.nextInt(0, elementDimension);

            if (representation[row][column].equals("")) {
                representation[row][column] = symbol;
                counter++;
            }

        }

        return preferredLocationSymbol == "" ? new MapElement(representation, name, elementDimension)
                : new MapElement(representation, name, elementDimension, preferredLocationSymbol);
    }
}
