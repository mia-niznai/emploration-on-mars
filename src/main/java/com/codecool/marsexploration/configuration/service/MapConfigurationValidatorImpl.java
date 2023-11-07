package com.codecool.marsexploration.configuration.service;

import com.codecool.marsexploration.configuration.model.ElementToSize;
import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.configuration.model.MapElementConfiguration;

import static com.codecool.marsexploration.configuration.model.Symbols.*;

public class MapConfigurationValidatorImpl implements MapConfigurationValidator {

    public boolean validate(MapConfiguration mapConfig) {
        int totalElementsCount = 0;

        for (MapElementConfiguration mapElementConfiguration : mapConfig.mapElementConfigurations()) {

            for (ElementToSize elementToSize : mapElementConfiguration.elementToSizes()) {
                totalElementsCount += elementToSize.size() * elementToSize.elementCount();
            }

            String name = mapElementConfiguration.name();
            int dimensionGrowth = mapElementConfiguration.dimensionGrowth();

            if ((name.equals(MOUNTAIN) && dimensionGrowth != 3) ||
                    (name.equals(PIT) && dimensionGrowth != 10) ||
                    ((name.equals(MINERAL) || name.equals(WATER)) && dimensionGrowth != 0)) {
                return false;
            }
        }

        return (mapConfig.mapSize() * mapConfig.mapSize() * mapConfig.elementToSpaceRatio()) >= totalElementsCount;
    }
}
