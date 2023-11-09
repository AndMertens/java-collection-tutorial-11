package be.bornput.javacollectiontutorial.objectmother;

import java.util.HashSet;
import java.util.Set;

public class SetMother {

    public static final String DUPLICATE_ITEM = "Item 1";

    public static Set<String>  generateDummySetWithNullValue() {
        Set<String> dummySetWithNullValue = new HashSet<>();

        dummySetWithNullValue.add("Item 3");
        dummySetWithNullValue.add("Item 1");
        dummySetWithNullValue.add(null);
        dummySetWithNullValue.add("Item 4");
        dummySetWithNullValue.add("Item 2");
        
        return dummySetWithNullValue;
    }

    public static Set<String> generateDummySetWithoutNullValue() {
        Set<String> dummySetWithoutNullValue = new HashSet<>();
        
        dummySetWithoutNullValue.add("Item 3");
        dummySetWithoutNullValue.add("Item 1");
        dummySetWithoutNullValue.add("Item 4");
        dummySetWithoutNullValue.add("Item 2");
        
        return dummySetWithoutNullValue;
    }

    public static Set<String> generateDummySetInSpecificOrder() {

        Set<String> dummySetInSpecificOrder = new HashSet<>();
        dummySetInSpecificOrder.add("Item 1");
        dummySetInSpecificOrder.add("Item 2");
        dummySetInSpecificOrder.add("Item 3");
        dummySetInSpecificOrder.add("Item 4");

        return dummySetInSpecificOrder;

    }

}
