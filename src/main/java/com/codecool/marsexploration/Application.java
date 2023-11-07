package com.codecool.marsexploration;

import com.codecool.marsexploration.mapelements.service.MapService;
import java.io.IOException;
import java.util.Random;


public class Application {

    public static final String WorkDir = "src/main/new";
    public static Random random = new Random();

    public static void main(String[] args) throws IOException {
        System.out.println("Mars Exploration Sprint 1");

        MapService mapService = new MapService();
        mapService.createAndWriteMaps(3);
    }
}

