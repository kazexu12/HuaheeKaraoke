package SessionManagement.ADT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Loo Zi Kang
 */
@DisplayName("SessionManagement ADT - DoublyLinkedDequeTest")
public class DoublyLinkedDequeTest {

    private DoublyLinkedDeque<String> deque;

    @BeforeEach
    void initEach() {
        deque = new DoublyLinkedDeque<>();
    }

    @Test
    @DisplayName("Able to add item to back of the deque")
    void addItemFront() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        assertEquals(deque.peekBack(), "Item 3");
        assertEquals(deque.size(), 3);
    }

    @Test
    @DisplayName("Able to add item to the in front of the deque")
    void addItemBack() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        deque.pushFront("Item Added");
        assertEquals(deque.peekFront(), "Item Added");
        assertEquals(deque.size(), 4);
    }

    @Test
    @DisplayName("Able to remove item from the in front of the deque")
    void removeItemFront() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        String item = deque.removeFront();
        assertEquals(item, "Item 1");
        assertEquals(deque.size(), 2);
        assertEquals(deque.peekFront(), "Item 2");
        assertEquals(deque.peekBack(), "Item 3");
    }

    @Test
    @DisplayName("Able to remove item from front of the deque until empty")
    void removeItemFrontUntilEmpty() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        assertEquals(deque.size(), 0);
        assertNull(deque.peekFront());
        assertNull(deque.peekBack());
    }

    @Test
    @DisplayName("Able to remove item from back of the deque")
    void removeItemBack() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        String item = deque.removeBack();
        assertEquals(item, "Item 3");
        assertEquals(deque.size(), 2);
        assertEquals(deque.peekFront(), "Item 1");
        assertEquals(deque.peekBack(), "Item 2");
    }

    @Test
    @DisplayName("Able to remove item from back of the deque until empty")
    void removeItemBackUntilEmpty() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        deque.removeBack();
        deque.removeBack();
        deque.removeBack();
        assertEquals(deque.size(), 0);
        assertNull(deque.peekFront());
        assertNull(deque.peekBack());
    }

    @Test
    @DisplayName("Able to clear deque")
    void ableToClearDeque() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        deque.clear();
        assertEquals(deque.size(), 0);
        assertNull(deque.peekFront());
        assertNull(deque.peekBack());
    }

    @Test
    @DisplayName("Able to check if deque is empty")
    void dequeIsEmptyTest() {
        assertTrue(deque.isEmpty());
        deque.pushBack("Item 1");
        assertFalse(deque.isEmpty());
        deque.removeFront();
        assertTrue(deque.isEmpty());
    }

    @Test
    @DisplayName("Able to make a copy of the deque")
    void copyTest() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        DoublyLinkedDeque<String> cloned = (DoublyLinkedDeque) deque.copy();
        cloned.clear();
        assertEquals(cloned.size(), 0);
        assertEquals(deque.size(), 3);
    }

    @Test
    @DisplayName("Able to iterate through Deque from front")
    void iterateFrontTest() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        java.util.Iterator<String> i = deque.getForwardIterator();
        assertTrue(i.hasNext());
        assertEquals(i.next(), "Item 1");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "Item 2");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "Item 3");
        assertFalse(i.hasNext());
        assertNull(i.next());
    }

    @Test
    @DisplayName("Able to iterate through Deque from back")
    void iterateRearTest() {
        deque.pushBack("Item 1");
        deque.pushBack("Item 2");
        deque.pushBack("Item 3");
        java.util.Iterator<String> i = deque.getReverseIterator();
        assertTrue(i.hasNext());
        assertEquals(i.next(), "Item 3");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "Item 2");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "Item 1");
        assertFalse(i.hasNext());
        assertNull(i.next());
    }
}
