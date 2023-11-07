package com.codecool.marsexploration.configuration.service;

import com.codecool.marsexploration.configuration.model.ElementToSize;
import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.configuration.model.MapElementConfiguration;
import com.codecool.marsexploration.configuration.model.Symbols;

import java.util.Arrays;
import java.util.List;

public class ConfigurationProvider {
    public static MapConfiguration getConfiguration() {


        MapElementConfiguration mountainsCfg = new MapElementConfiguration(
                Symbols.MOUNTAIN,
                "mountain",
                List.of(
                        new ElementToSize(2, 20),
                        new ElementToSize(1, 30)
                ),
                3,
                ""
        );

        MapElementConfiguration pittsCfg = new MapElementConfiguration(
                Symbols.PIT,
                "pit",
                List.of(
                        new ElementToSize(4, 10),
                        new ElementToSize(1, 20)
                ),
                10,
                ""
        );

        MapElementConfiguration mineralsCfg = new MapElementConfiguration(
                Symbols.MINERAL,
                "mineral",
                List.of(
                        new ElementToSize(10, 1)
                ),
                0,
                Symbols.MOUNTAIN
        );

        MapElementConfiguration waterCfg = new MapElementConfiguration(
                Symbols.WATER,
                "water",
                List.of(
                        new ElementToSize(10, 1)
                ),
                0,
                Symbols.PIT
        );

        List<MapElementConfiguration> elementsCfg = Arrays.asList(mountainsCfg, pittsCfg, mineralsCfg, waterCfg);
        return new MapConfiguration(100, 0.5, elementsCfg);
    }
}
