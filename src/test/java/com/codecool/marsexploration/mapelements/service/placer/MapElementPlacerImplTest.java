package com.codecool.marsexploration.mapelements.service.placer;

import com.codecool.marsexploration.mapelements.model.MapElement;
import com.codecool.marsexploration.calculators.model.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapElementPlacerImplTest {

    private MapElementPlacerImpl mapElementPlacer;
    private MapElement mockElement;

    @BeforeEach
    public void setUp() {
        mapElementPlacer = new MapElementPlacerImpl();
        mockElement = mock(MapElement.class);
        when(mockElement.getDimension()).thenReturn(2); // Adjust the dimension as needed
    }

    @Test
    public void testCanPlaceElement_ValidPlacement_ReturnsTrue() {
        String[][] map = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
        Coordinate coordinate = new Coordinate(0, 0);
        assertTrue(mapElementPlacer.canPlaceElement(mockElement, map, coordinate));
    }

    @Test
    public void testCanPlaceElement_InvalidPlacement_ReturnsFalse() {
        String[][] map = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
        Coordinate coordinate = new Coordinate(1, 1);
        assertTrue(mapElementPlacer.canPlaceElement(mockElement, map, coordinate));
    }

}
