package SessionManagement.ADT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Loo Zi Kang
 */
@DisplayName("SessionManagement ADT - ArrayListTest")
public class ArrayListTest {

    private ArrayList<String> arr;

    @BeforeEach
    void initEach() {
        arr = new ArrayList<>();
        arr.add("Item 1");
        arr.add("Item 2");
        arr.add("Item 3");
    }

    @Test
    @DisplayName("Able to add item into Arraylist")
    void addItem() {
        arr.add("Item");
        assertEquals("Item", arr.get(3));
        assertEquals(arr.size(), 4);
    }

    @Test
    @DisplayName("Able to add item into start of arraylist")
    void addItemStart() {
        arr.add(0, "Insert");
        assertEquals(arr.get(0), "Insert");
        assertEquals(arr.get(1), "Item 1");
        assertEquals(arr.get(2), "Item 2");
        assertEquals(arr.get(3), "Item 3");
        assertEquals(arr.size(), 4);
    }

    @Test
    @DisplayName("Able to add item into end of arraylist")
    void addItemEnd() {
        arr.add(3, "Insert");
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Item 2");
        assertEquals(arr.get(2), "Item 3");
        assertEquals(arr.get(3), "Insert");
        assertEquals(arr.size(), 4);
    }

    @Test
    @DisplayName("Able to add item into random position")
    void addItemInPos() {
        arr.add(1, "Insert");
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Insert");
        assertEquals(arr.get(2), "Item 2");
        assertEquals(arr.get(3), "Item 3");
        assertEquals(arr.size(), 4);
    }

    @Test
    @DisplayName("Able to check if arraylist contains item")
    void containsTest() {
        assertTrue(arr.contains("Item 1"));
        assertFalse(arr.contains("Nope"));
    }

    @Test
    @DisplayName("Able to get item from position")
    void getItemFromPosition() {
        arr.get(0);
    }

    @Test
    @DisplayName("Throws exception when attempt to get items out of bound")
    void outOfBoundTest() {
        assertThrows(Exception.class, () -> {
            arr.get(arr.size());
        });
    }

    @Test
    @DisplayName("Internal array expansion works as expected")
    void arrayExpansionTest() {
        arr.add("Item 4");
        arr.add("Item 5");
        arr.add("Item 6");
        assertEquals(arr.size(), 6);
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Item 2");
        assertEquals(arr.get(2), "Item 3");
        assertEquals(arr.get(3), "Item 4");
        assertEquals(arr.get(4), "Item 5");
        assertEquals(arr.get(5), "Item 6");
    }

    @Test
    @DisplayName("Able to remove item from first position")
    void removeStartPosTest() {
        arr.remove(0);
        assertEquals(arr.get(0), "Item 2");
        assertEquals(arr.get(1), "Item 3");
        assertEquals(arr.size(), 2);
    }

    @Test
    @DisplayName("Able to remove item from last position")
    void removeLastPosTest() {
        arr.remove(arr.size() - 1);
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Item 2");
        assertEquals(arr.size(), 2);
    }

    @Test
    @DisplayName("Able to remove item from random position")
    void removeRandPosTest() {
        arr.remove(1);
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Item 3");
        assertEquals(arr.size(), 2);
    }

    @Test
    @DisplayName("Able to remove item located at the start")
    void removeStartTest() {
        arr.remove("Item 1");
        assertEquals(arr.get(0), "Item 2");
        assertEquals(arr.get(1), "Item 3");
        assertEquals(arr.size(), 2);
    }

    @Test
    @DisplayName("Able to remove item located at the end")
    void removeLastTest() {
        arr.remove("Item 3");
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Item 2");
        assertEquals(arr.size(), 2);
    }

    @Test
    @DisplayName("Able to remove item located randomly")
    void removeRandTest() {
        arr.remove("Item 2");
        assertEquals(arr.get(0), "Item 1");
        assertEquals(arr.get(1), "Item 3");
        assertEquals(arr.size(), 2);
    }
    
    @Test
    @DisplayName("Able to compare between 2 arraylist which contains the same value")
    void cmpArlist() {
        ArrayList<String> other = new ArrayList<>();
        other.add("Item 1");
        other.add("Item 2");
        other.add("Item 3");
        
        ArrayList<String> fakeOther = new ArrayList<>();
        
        assertTrue(arr.equals(other));
        assertTrue(arr.equals(arr));
        assertFalse(arr.equals(""));
        assertFalse(arr.equals(fakeOther));
        assertFalse(arr.equals(null));
    }
}
