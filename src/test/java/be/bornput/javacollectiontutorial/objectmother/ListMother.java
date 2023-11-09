package be.bornput.javacollectiontutorial.objectmother;

import java.util.Arrays;
import java.util.List;

public class ListMother {

    public final static List<String> EXPECTED_DUPLICATES = List.of("Item 3", "Item 1");
    
    public static List<String> generateDummyListOfStringsWithDuplicatesAndNullValues() {
        return Arrays.asList( "Item 3", "Item 1" , "Item 4", null , "Item 1", null, "Item 3");
    }

    public static List<String> generateDummyListInSpecificOrder() {
        return Arrays.asList( "Item 3", "Item 2" , "Item 1", "Item 3", "Item 4");
    }

    public static List<String> generateDummyListOfStringsWithNoDuplicatesAndNullValue() {
        return Arrays.asList( "Item 3", "Item 1" , "Item 4", null);
    }

    public static List<String> generateDummyListOfStringsWithNoDuplicatesAndNoNullValue() {
        return Arrays.asList( "Item 3", "Item 1" , "Item 4");
    }

}
