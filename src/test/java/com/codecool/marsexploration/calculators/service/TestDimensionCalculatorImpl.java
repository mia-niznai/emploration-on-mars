package com.codecool.marsexploration.calculators.service;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDimensionCalculatorImpl {
    DimensionCalculatorImpl dimensionCalculator;

    public TestDimensionCalculatorImpl() {
        dimensionCalculator = new DimensionCalculatorImpl();
    }

    @Test
    public void testCalculateDimension() {
        assertEquals(dimensionCalculator.calculateDimension(20, 3), 8);
    }

    @Test
    public void testCalculateDimension_Size1() {
        assertEquals(dimensionCalculator.calculateDimension(1, 0), 1);
    }

    @Test
    public void testCalculateDimension_Size0() {
        assertEquals(dimensionCalculator.calculateDimension(0, 5), 5);
    }

    @Test
    public void testCalculateDimension_PerfectSquare() {
        assertEquals(dimensionCalculator.calculateDimension(16, 0), 4);
    }

    @Test
    public void testCalculateDimension_PerfectSquareWithGrowth() {
        assertEquals(dimensionCalculator.calculateDimension(16, 3), 7);
    }

    @Test
    public void testCalculateDimension_SizeIsPerfectSquare() {
        assertEquals(dimensionCalculator.calculateDimension(25, 0), 5);
    }

    @Test
    public void testCalculateDimension_SizeOneLessThanPerfectSquare() {
        assertEquals(dimensionCalculator.calculateDimension(15, 0), 4);
    }

    @Test
    public void testCalculateDimension_SizeOneLessThanPerfectSquareWithGrowth() {
        assertEquals(dimensionCalculator.calculateDimension(15, 1), 5);
    }

    @Test
    public void testCalculateDimension_LargeSizeAndGrowth() {
        assertEquals(dimensionCalculator.calculateDimension(1000000, 1000), 2000);
    }


}
