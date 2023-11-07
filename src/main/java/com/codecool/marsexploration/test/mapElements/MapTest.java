//package com.codecool.marsexploration.test.mapElements;
//
//import org.testng.annotations.Test;
//
//import static com.codecool.marsexploration.mapelements.model.Map.createStringRepresentation;
//import static org.testng.AssertJUnit.assertEquals;
//
//
//public class MapTest {
//
//      @Test
//    public void testEmptyArray(){
//        String[][] arr = new String[0][0];
//        String expected = "";
//        String result = createStringRepresentation(arr);
//        assertEquals(expected, result);
//     }
//
//     @Test
//    public void testSingleElementArray(){
//          String[][] arr = {{"Hello"}};
//          String expected = "Hello\n";
//          String result = createStringRepresentation(arr);
//          assertEquals(expected, result);
//     }
//
//     @Test
//    public void testMultipleElementsInRow(){
//          String[][] arr = {{"Hello", "World", "!"}};
//          String expected = "HelloWorld!\n";
//          String result = createStringRepresentation(arr);
//          assertEquals(expected, result);
//     }
//
//     @Test
//    public void testMultipleRowsAndColumns(){
//          String[][] arr = {{"A", "B", "C"}, {"1", "2", "3"}, {"X", "Y", "Z"}};
//          String expected = "ABC\n123\nXYZ\n";
//         String result = createStringRepresentation(arr);
//         assertEquals(expected, result);
//     }
//
//
//}
