package be.bornput.javacollectiontutorial.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static be.bornput.javacollectiontutorial.objectmother.ListMother.*;
import static org.assertj.core.api.Assertions.assertThat;

class ArrayListTest {

    Predicate<String> duplicatePredicate = item -> item != null && EXPECTED_DUPLICATES.contains(item);
    Predicate<String> nullValuePredicate = Objects::isNull;

    @Test
    void givenArrayList_whenContainsDuplicatesAndMultipkleNullValues_thenListContainsAllValues() {
        List<String> items = new ArrayList<>(generateDummyListOfStringsWithDuplicatesAndNullValues());
        Assertions.assertAll(
                () -> assertThat(items.stream().filter(nullValuePredicate).count()).isEqualTo(2),
                () -> assertThat(items.stream().filter(duplicatePredicate).count()).isEqualTo(4)
        );
    }

    @Test
    void givenArrayList_whenAddingMultipkleNullValues_thenListContainsNullValue() {
       List<String> items = new ArrayList<>(generateDummyListOfStringsWithNoDuplicatesAndNoNullValue());
       int initialSize = items.size();

       items.add(null);
       items.add(null);

       Assertions.assertAll(
               () -> assertThat(items.stream().filter(nullValuePredicate).count()).isEqualTo(2),
                () -> assertThat(items).hasSize(initialSize + 2));
    }

    @Test
    void givenArrayList_whenAddingDuplicates_thenListContainDuplicateValues() {
        List<String> items = new ArrayList<>(generateDummyListOfStringsWithNoDuplicatesAndNullValue());
        int initialSize = items.size();
        items.add("Item 3");
        items.add("Item 3");

        assertThat(items).hasSize( initialSize + 2);
        assertThat(items.parallelStream().filter("Item 3"::equals).count()).isEqualTo(3);
    }

    @Test
    void givenArrayList_whenRetrievingElements_thenInsertionOrderIsMaintained() {
        List<String> items = new ArrayList<>(generateDummyListInSpecificOrder());
        assertThat(items).containsExactly("Item 3", "Item 2","Item 1","Item 3","Item 4");

    }

}
