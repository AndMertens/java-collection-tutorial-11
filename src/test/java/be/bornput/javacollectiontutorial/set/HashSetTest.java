package be.bornput.javacollectiontutorial.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static be.bornput.javacollectiontutorial.objectmother.SetMother.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class HashSetTest {

    @Test
    void givenASet_whenAddingDuplicateItem_thenDuplicateItemIsNotAdded() {
        Set<String> withNullValue = generateDummySetWithNullValue();
        int initialSizeOfSet = withNullValue.size();

        withNullValue.add(DUPLICATE_ITEM);

        Assertions.assertAll(
            () -> assertThat(withNullValue).hasSize(initialSizeOfSet),
            () -> assertThat(withNullValue).containsExactlyInAnyOrder(null, "Item 3","Item 4","Item 1", "Item 2")
        );
    }

    @Test
    void givenASetWithNoNullValues_WhenAddingNullValue_thenNullIsAdded() {
        Set<String> noNullValue = generateDummySetWithoutNullValue();
        int initialSizeOfSet = noNullValue.size();

        noNullValue.add(null);

        Assertions.assertAll(
            () -> assertThat(noNullValue).hasSize(initialSizeOfSet + 1),
            () -> assertThat(noNullValue).containsExactlyInAnyOrder(null, "Item 3","Item 4","Item 1", "Item 2")
        );
    }

    @Test
    void givenASet_whenRetrievingItems_thenInsertionOrderIsNotPreserved() {
        Set<String> specificOrder = generateDummySetInSpecificOrder();
        Assertions.assertAll(
                () -> assertThat(specificOrder).hasSize(4),
                () -> assertThat(specificOrder.stream().findFirst().orElse("")).isNotEqualTo("Item 1")
        );
    }

}
