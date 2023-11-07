package com.codecool.marsexploration.mapelements.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapTest {

    @Test
    void createStringRepresentation_withValidArray_returnFormattedString() {
        String[][] sampleArray = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };

        String expectedOutput =
                "A B C \n" +
                        "D E F \n" +
                        "G H I \n";

        String actualOutput = Map.createStringRepresentation(sampleArray);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createStringRepresentation_withEmptyArray_returnEmptyString() {
        String[][] emptyArray = {};

        String expectedOutput = "";

        String actualOutput = Map.createStringRepresentation(emptyArray);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createStringRepresentation_withArrayContainingEmptyRows_returnFormattedStringWithBlankLines() {
        String[][] arrayWithEmptyRows = {
                {},
                {"A", "B"},
                {},
                {"C"}
        };

        String expectedOutput =
                "\n" +
                        "A B \n" +
                        "\n" +
                        "C \n";

        String actualOutput = Map.createStringRepresentation(arrayWithEmptyRows);

        assertEquals(expectedOutput, actualOutput);
    }
}
