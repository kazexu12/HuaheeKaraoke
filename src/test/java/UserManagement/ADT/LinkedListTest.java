package UserManagement.ADT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Loo Zi Kang
 */
@DisplayName("SessionManagement ADT - LinkedListTest")
public class LinkedListTest {

    private Linkedlist<String> list;

    @BeforeEach
    void initEach() {
        list = new Linkedlist<>();
    }

    @Test
    @DisplayName("Able to add item")
    public void addItemTest() {
        list.addData("Item 1");
        list.addData("Item 2");
        list.addData("Item 3");
        assertEquals(list.size(), 3);
        assertEquals(list.getDataFromFront(1), "Item 1");
        assertEquals(list.getDataFromFront(2), "Item 2");
        assertEquals(list.getDataFromFront(3), "Item 3");
    }

    @Test
    @DisplayName("Able to add item in position")
    public void addItemInPosTest() {
        list.addData("Item 1");
        list.addData("Item 2");
        list.addData("Item 3");
        list.addData(1, "Item at start");
        assertEquals(list.getDataFromFront(1), "Item at start");
        assertEquals(list.getDataFromFront(2), "Item 1");
        assertEquals(list.getDataFromFront(3), "Item 2");
        assertEquals(list.getDataFromFront(4), "Item 3");
        assertEquals(list.size(), 4);
        
        list.addData(5, "Item at end");
        assertEquals(list.getDataFromFront(1), "Item at start");
        assertEquals(list.getDataFromFront(2), "Item 1");
        assertEquals(list.getDataFromFront(3), "Item 2");
        assertEquals(list.getDataFromFront(4), "Item 3");
        assertEquals(list.getDataFromFront(5), "Item at end");
        assertEquals(list.size(), 5);
        
        list.addData(3, "middle");
        assertEquals(list.getDataFromFront(3), "middle");
        assertEquals(list.getDataFromFront(1), "Item at start");
        assertEquals(list.getDataFromFront(2), "Item 1");
        assertEquals(list.getDataFromFront(3), "middle");
        assertEquals(list.getDataFromFront(4), "Item 2");
        assertEquals(list.getDataFromFront(5), "Item 3");
        assertEquals(list.getDataFromFront(6), "Item at end");
        assertEquals(list.size(), 6);
    }
}
