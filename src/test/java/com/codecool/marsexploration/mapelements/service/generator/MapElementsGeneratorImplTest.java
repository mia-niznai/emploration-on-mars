package com.codecool.marsexploration.mapelements.service.generator;

import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.mapelements.model.MapElement;
import com.codecool.marsexploration.mapelements.service.builder.MapElementBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class MapElementsGeneratorImplTest {

    private MapElementBuilder builder;
    private MapElementsGeneratorImpl generator;

    @BeforeEach
    void setUp() {
        builder = mock(MapElementBuilder.class);
        generator = new MapElementsGeneratorImpl(builder);
    }

    @Test
    void testCreateAll() {
       MapConfiguration config = mock(MapConfiguration.class);

        Iterable<MapElement> result = generator.createAll(config);

        assertNotNull(result);

    }
}
