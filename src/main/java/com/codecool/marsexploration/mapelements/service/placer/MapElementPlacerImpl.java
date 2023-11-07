package com.codecool.marsexploration.mapelements.service.placer;

import com.codecool.marsexploration.calculators.model.Coordinate;
import com.codecool.marsexploration.mapelements.model.MapElement;

public class MapElementPlacerImpl implements MapElementPlacer {

    public boolean canPlaceElement(MapElement element, String[][] map, Coordinate coordinate) {


        if (map[coordinate.x()][coordinate.y()] == "") {

            if (coordinate.x() + element.getDimension() > map.length || coordinate.y() + element.getDimension() > map.length) return false;

            for (int i = coordinate.x(); i < coordinate.x() + element.getDimension()-1; i++) {
                for (int j = coordinate.y(); j < coordinate.y() + element.getDimension()-1; j++) {

                    if (map[i][j] != "") {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public void placeElement(MapElement element, String[][] map, Coordinate coordinate) {
        var x_elementRepresentation = 0;
        var y_elementRepresentation = 0;

        for (int i = coordinate.x(); i < coordinate.x() + element.getDimension(); i++) {
            y_elementRepresentation = 0;

            for (int j = coordinate.y(); j < coordinate.y() + element.getDimension(); j++) {

                map[i][j] = element.getRepresentation()[x_elementRepresentation][y_elementRepresentation];
                y_elementRepresentation++;
            }
            x_elementRepresentation++;

        }
    }
}
