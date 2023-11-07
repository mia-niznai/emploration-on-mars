package com.codecool.marsexploration.configuration.service;

import com.codecool.marsexploration.configuration.model.ElementToSize;
import com.codecool.marsexploration.configuration.model.MapConfiguration;
import com.codecool.marsexploration.configuration.model.MapElementConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codecool.marsexploration.configuration.model.Symbols.*;
import static org.junit.jupiter.api.Assertions.*;

class MapConfigurationValidatorImplTest {


    private MapConfigurationValidator validator;

    @BeforeEach
    void setUp() {
        validator = new MapConfigurationValidatorImpl();
    }

    @Test
    void testValidate_Successful() {
        MapElementConfiguration mountainConfig = new MapElementConfiguration(MOUNTAIN, "dummyValue1", List.of(new ElementToSize(3, 3)), 3, "dummyValue2");
        MapElementConfiguration pitConfig = new MapElementConfiguration(PIT, "dummyValue1", List.of(new ElementToSize(5, 5)), 10, "dummyValue2");

        MapConfiguration mapConfiguration = new MapConfiguration(10, 0.5, List.of(mountainConfig, pitConfig));

        assertTrue(validator.validate(mapConfiguration));
    }

    @Test
    void testValidate_FailureDueToWrongDimensionGrowth() {
        MapElementConfiguration mountainConfig = new MapElementConfiguration(MOUNTAIN, "dummyValue1", List.of(new ElementToSize(3, 3)), 5, "dummyValue2"); // Incorrect dimensionGrowth

        MapConfiguration mapConfiguration = new MapConfiguration(10, 0.5, List.of(mountainConfig));

        assertTrue(validator.validate(mapConfiguration));
    }

    @Test
    void testValidate_FailureDueToExceedingSize() {
        MapElementConfiguration mountainConfig = new MapElementConfiguration(MOUNTAIN, "dummyValue1", List.of(new ElementToSize(50, 50)), 3, "dummyValue2"); // Too many elements for the given map size

        MapConfiguration mapConfiguration = new MapConfiguration(10, 0.5, List.of(mountainConfig));

        assertFalse(validator.validate(mapConfiguration));
    }
}
