package com.codecool.marsexploration.calculators.service;

import com.codecool.marsexploration.calculators.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  CoordinateCalculatorImpl implements CoordinateCalculator {

    final Random random;

    public CoordinateCalculatorImpl() {
        random = new Random();
    }
    public Coordinate getRandomCoordinate(int dimension) {
        var x = random.nextInt(dimension);
        var y = random.nextInt(dimension);
        return new Coordinate(x,y);
    }
    public List<Coordinate> getAdjacentCoordinates(Coordinate coordinate, int dimension) {
        List<Coordinate> adjacentCoordinates = new ArrayList<>();
        int x = coordinate.x();
        int y = coordinate.y();

        adjacentCoordinates.add(new Coordinate(x, Math.max(0, y - 1)));  //top
        adjacentCoordinates.add(new Coordinate(x, Math.min(dimension - 1, y + 1)));  //bottom
        adjacentCoordinates.add(new Coordinate(Math.max(0, x - 1), y));  //left
        adjacentCoordinates.add(new Coordinate(Math.min(dimension - 1, x + 1), y));  //right

        return adjacentCoordinates;
    }
    public List<Coordinate> getAdjacentCoordinates(Iterable<Coordinate> coordinates, int dimension) {
        List<Coordinate> allAdjacentCoordinates = new ArrayList<>();

        for (Coordinate coordinate : coordinates) {
            allAdjacentCoordinates.addAll(getAdjacentCoordinates(coordinate, dimension));
        }

        return allAdjacentCoordinates;
    }
}
