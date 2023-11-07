package com.codecool.marsexploration.calculators.service;

import com.codecool.marsexploration.calculators.model.Coordinate;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CoordinateCalculatorImplTest {

    private CoordinateCalculator calculator;

    @Before
    public void setUp() {
        calculator = new CoordinateCalculatorImpl();
    }

    @Test
    public void testGetRandomCoordinateWithinBounds() {
        int dimension = 10;
        Coordinate coord = calculator.getRandomCoordinate(dimension);
        assertTrue(coord.x() >= 0 && coord.x() < dimension);
        assertTrue(coord.y() >= 0 && coord.y() < dimension);
    }

    @Test
    public void testGetRandomCoordinateForDimensionOne() {
        Coordinate coord = calculator.getRandomCoordinate(1);
        assertEquals(0, coord.x());
        assertEquals(0, coord.y());
    }

    @Test
    public void testGetAdjacentCoordinatesForNonBoundary() {
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(1, 0),
                new Coordinate(1, 2),
                new Coordinate(0, 1),
                new Coordinate(2, 1)
        );
        List<Coordinate> result = calculator.getAdjacentCoordinates(new Coordinate(1, 1), 3);
        assertEquals(expected, result);
    }

    @Test
    public void testGetAdjacentCoordinatesForBoundary() {
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(0, 0),         //top
                new Coordinate(0, 2),         //bottom
                new Coordinate(0, 1),         //left
                new Coordinate(1, 1)          //right
        );
        List<Coordinate> result = calculator.getAdjacentCoordinates(new Coordinate(0, 1), 3);
        assertEquals(expected, result);
    }

    @Test
    public void testGetAllAdjacentCoordinatesForMultiple() {
        List<Coordinate> input = Arrays.asList(new Coordinate(1, 1), new Coordinate(0, 0));
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(1, 0),
                new Coordinate(1, 2),
                new Coordinate(0, 1),
                new Coordinate(2, 1),
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(0, 0),
                new Coordinate(1, 0)
        );
        List<Coordinate> result = calculator.getAdjacentCoordinates(input, 3);
        assertEquals(expected, result);
    }

    @Test
    public void testGetAllAdjacentCoordinatesForEmptyList() {
        assertTrue(calculator.getAdjacentCoordinates(Arrays.asList(), 3).isEmpty());
    }
}
