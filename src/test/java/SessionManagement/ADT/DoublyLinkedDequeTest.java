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

    private DoublyLinkedDeque<String> queue;

    @BeforeEach
    void initEach() {
        queue = new DoublyLinkedDeque<>();
    }

    @Test
    @DisplayName("Able to add item to back of the queue")
    void addItemFront() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        assertEquals(queue.peekBack(), "Item 3");
        assertEquals(queue.size(), 3);
    }

    @Test
    @DisplayName("Able to add item to the in front of the queue")
    void addItemBack() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        queue.pushFront("Item Added");
        assertEquals(queue.peekFront(), "Item Added");
        assertEquals(queue.size(), 4);
    }

    @Test
    @DisplayName("Able to remove item from the in front of the queue")
    void removeItemFront() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        String item = queue.removeFront();
        assertEquals(item, "Item 1");
        assertEquals(queue.size(), 2);
        assertEquals(queue.peekFront(), "Item 2");
        assertEquals(queue.peekBack(), "Item 3");
    }

    @Test
    @DisplayName("Able to remove item from front of the queue until empty")
    void removeItemFrontUntilEmpty() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        queue.removeFront();
        queue.removeFront();
        queue.removeFront();
        assertEquals(queue.size(), 0);
        assertNull(queue.peekFront());
        assertNull(queue.peekBack());
    }

    @Test
    @DisplayName("Able to remove item from back of the queue")
    void removeItemBack() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        String item = queue.removeBack();
        assertEquals(item, "Item 3");
        assertEquals(queue.size(), 2);
        assertEquals(queue.peekFront(), "Item 1");
        assertEquals(queue.peekBack(), "Item 2");
    }

    @Test
    @DisplayName("Able to remove item from back of the queue until empty")
    void removeItemBackUntilEmpty() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        queue.removeBack();
        queue.removeBack();
        queue.removeBack();
        assertEquals(queue.size(), 0);
        assertNull(queue.peekFront());
        assertNull(queue.peekBack());
    }
    
    @Test
    @DisplayName("Able to clear queue")
    void ableToClearQueue() {
        queue.pushBack("Item 1");
        queue.pushBack("Item 2");
        queue.pushBack("Item 3");
        queue.clear();
        assertEquals(queue.size(), 0);
        assertNull(queue.peekFront());
        assertNull(queue.peekBack());
    }
    
    @Test
    @DisplayName("Able to check if queue is empty")
    void queueIsEmptyTest() {
        assertTrue(queue.isEmpty());
        queue.pushBack("Item 1");
        assertFalse(queue.isEmpty());
        queue.removeFront();
        assertTrue(queue.isEmpty());
    }
}
