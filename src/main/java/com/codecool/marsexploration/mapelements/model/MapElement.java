package com.codecool.marsexploration.mapelements.model;

public class MapElement {
    private String[][] representation;
    private String name;
    private int dimension;
    private String preferredLocationSymbol;

    public MapElement(String[][] representation, String name, int dimension) {
        this(representation, name, dimension, null);
    }

    public MapElement(String[][] representation, String name, int dimension, String preferredLocationSymbol) {
        this.representation = representation;
        this.name = name;
        this.dimension = dimension;
        this.preferredLocationSymbol = preferredLocationSymbol;
    }

    private static String createStringRepresentation(String[][] arr) {

        StringBuilder sb = new StringBuilder();

        for (String[] row : arr) {
            for (String element : row) {
                sb.append(element).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public int getDimension() {
        return dimension;
    }

    public String[][] getRepresentation() {
        return representation;
    }

    public String getPreferredLocationSymbol() {
        return preferredLocationSymbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return createStringRepresentation(representation);
    }
}