package com.codecool.marsexploration.mapelements.service.builder;

import com.codecool.marsexploration.calculators.service.DimensionCalculator;
import com.codecool.marsexploration.mapelements.model.MapElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapElementBuilderImplTest {

    private DimensionCalculator dimensionCalculator;
    private MapElementBuilderImpl mapElementBuilder;

    @BeforeEach
    public void setUp() {
        dimensionCalculator = new DimensionCalculator() {
            @Override
            public int calculateDimension(int size, int growth) {
                // Simple mock behavior for dimension calculation
                return size + growth;
            }
        };
        mapElementBuilder = new MapElementBuilderImpl(dimensionCalculator);
    }

    @Test
    public void testBuildMapElementCorrectName() {
        MapElement result = mapElementBuilder.build(2, "X", "Test", 1, "");
        assertEquals("Test", result.getName());
    }

    @Test
    public void testBuildMapElementCorrectDimension() {
        MapElement result = mapElementBuilder.build(2, "X", "Test", 1, "");
        assertEquals(3, result.getDimension());
    }

    @Test
    public void testBuildMapElementCorrectSymbolCount() {
        MapElement result = mapElementBuilder.build(2, "X", "Test", 1, "");
        int count = 0;
        for (int i = 0; i < result.getRepresentation().length; i++) {
            for (int j = 0; j < result.getRepresentation()[i].length; j++) {
                if ("X".equals(result.getRepresentation()[i][j])) {
                    count++;
                }
            }
        }
        assertEquals(2, count);
    }

    @Test
    public void testBuildMapElementPreferredLocationSymbol() {
        MapElement result = mapElementBuilder.build(2, "X", "Test", 1, "Y");
        assertEquals("Y", result.getPreferredLocationSymbol());
    }
}
