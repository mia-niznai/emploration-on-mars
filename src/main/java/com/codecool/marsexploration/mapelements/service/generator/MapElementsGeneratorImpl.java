package com.codecool.marsexploration.mapelements.service.generator;

import com.codecool.marsexploration.configuration.model.ElementToSize;
import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.configuration.model.MapElementConfiguration;
import com.codecool.marsexploration.mapelements.model.MapElement;
import com.codecool.marsexploration.mapelements.service.builder.MapElementBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapElementsGeneratorImpl implements MapElementsGenerator {

    private final MapElementBuilder builder;

    public MapElementsGeneratorImpl(MapElementBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Iterable<MapElement> createAll(MapConfiguration mapConfig) {
        List<MapElement> listOfAllMapElements = mapConfig.mapElementConfigurations().stream()
                .flatMap(mapElemConfig -> mapElemConfig.elementToSizes().stream()
                        .flatMap(element -> IntStream.range(0, element.elementCount())
                                .mapToObj(i -> builder.build(
                                        element.size(),
                                        mapElemConfig.symbol(),
                                        mapElemConfig.name(),
                                        mapElemConfig.dimensionGrowth(),
                                        mapElemConfig.preferredLocationSymbol()
                                ))
                        )
                )
                .collect(Collectors.toList());

        printGeneratedMapElements(listOfAllMapElements);
        return listOfAllMapElements;
    }

    private void printGeneratedMapElements(List<MapElement> mapElements) {
        System.out.println("These Map elements will be generated :\n");
        mapElements.forEach(element -> System.out.println(element + "\n"));
    }
}
