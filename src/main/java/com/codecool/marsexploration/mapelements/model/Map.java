package com.codecool.marsexploration.mapelements.model;

public class Map {

    private String[][] representation;

    private boolean successfullyGenerated;

    public Map(String[][] representation) {
        this.representation = representation;
    }

    public boolean isSuccessfullyGenerated() {
        return successfullyGenerated;
    }

    public void setSuccessfullyGenerated(boolean successfullyGenerated) {
        this.successfullyGenerated = successfullyGenerated;
    }

    public static String createStringRepresentation(String[][] arr) {

        StringBuilder sb = new StringBuilder();

        for (String[] row : arr) {
            for (String element : row) {
                sb.append(element).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String[][] getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return createStringRepresentation(representation);
    }
}

