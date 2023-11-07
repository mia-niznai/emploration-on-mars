# Exploration on planet Mars

### Mars Exploration Technical Design
The purpose of the Mars Explorer application is to generate a randomized imaginary map of Mars. The map we want to create is a square map: it's like a chessboard but with an arbitrary number of fields.

We have four type of objects or elements we wish to place on the map: mountains, pits, minerals, and water. Some elements are one-dimensional meaning they take up only one square. These are minerals and water. The rest, mountains and pits, can take up any number of squares. Also, some elements could have a preference with regards to their placement on the map. For example water is typically found next to pits.

The starter code contains some sample maps in the resources package. These maps have been generated with the following parameters:

mountain: 2x20, 1x30
pit: 2x10, 1x20
mineral, water: 10x1

Configuration
The application uses configuration objects to describe each of these elements. For example, the config object for the mountain element is already provided in the starter code:

String mountainSymbol = "#";

MapElementConfiguration mountainsCfg = new MapElementConfiguration(
mountainSymbol,
"mountain",
List.of(
new ElementToSize(2, 20),
new ElementToSize(1, 30)
),
3,
""
);
This declares that the mountains are represented with the symbol '#', are named 'mountain', and we'd like to have three mountain ranges on the map: two with the size of 20 and one with the size of 30.

The last parameter is the dimension growth: this means how much extra dimensions we'd like to have for our mountains to get some empty space within the mountain range.

For example, the minimum squares required for a mountain range with the size of 20 is 25 (5x5). With the dimension growth parameter, however, we can add more dimensions, so the # characters representing a mountain will be more spread out. In this case, we are adding three extra dimensions to each mountain range, so the 25 squares will turn into 64 (8x8).

We place the 20 # characters on 64 squares instead of 25, which will result in a more sparse placement (there will be more empty space).


The MapElementConfiguration objects are collected into a MapConfiguration object, which is then processed by the MapElementsGenerator which transforms them into actual MapElement objects. A MapElement represents the occupied space with a multidimensional array.

In the final step, the MapGenerator creates a randomized map and places the previously generated elements on it with the help of the MapElementPlacer. The generated Map object can be written onto a console or into a file using its overridden toString() method.

The application makes good use of the Open/Closed software development principle. It is possible to define & generate new types of elements simply by adding a related config object. No changes are required in either the MapelementGenerator or in the MapGenerator or in any other components to extend the functionality of our application.

Of course we also make use of the _Single Responsibility Principle and the Interface Segregation Principle in the app.


Modules
Below you will find a small summary about each module.

Configuration: contains the model classes related to the configuration of the map, and the configuration validator service.
Calculators: provide useful functions to work with coordinates and multidimensional arrays.
MapElements: contains all the components related to creating the map and its elements.
Output: has services that help with writing the map to different outputs (e.g. a file)
By breaking up the functionality of our app into modules, we can allow a team of multiple members to work on the features in parallel, thus optimizing the development cycle.

Developers:
* Mia Niznai
* George Meleancă