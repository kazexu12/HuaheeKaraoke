package SessionManagement.ADT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

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
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        assertEquals(queue.peek(), "Item 3");
        assertEquals(queue.size(), 3);
    }

    @Test
    @DisplayName("Able to add item to the in front of the queue")
    void addItemBack() {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.push("Item Added");
        assertEquals(queue.poll(), "Item Added");
        assertEquals(queue.size(), 4);
    }

    @Test
    @DisplayName("Able to remove item from the in front of the queue")
    void removeItemFront() {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        String item = queue.pop();
        assertEquals(item, "Item 1");
        assertEquals(queue.size(), 2);
        assertEquals(queue.poll(), "Item 2");
        assertEquals(queue.peek(), "Item 3");
    }

    @Test
    @DisplayName("Able to remove item from front of the queue until empty")
    void removeItemFrontUntilEmpty() {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.pop();
        queue.pop();
        queue.pop();
        assertEquals(queue.size(), 0);
        assertNull(queue.poll());
        assertNull(queue.peek());
    }

    @Test
    @DisplayName("Able to remove item from back of the queue")
    void removeItemBack() {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        String item = queue.remove();
        assertEquals(item, "Item 3");
        assertEquals(queue.size(), 2);
        assertEquals(queue.poll(), "Item 1");
        assertEquals(queue.peek(), "Item 2");
    }

    @Test
    @DisplayName("Able to remove item from back of the queue until empty")
    void removeItemBackUntilEmpty() {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.remove();
        queue.remove();
        queue.remove();
        assertEquals(queue.size(), 0);
        assertNull(queue.poll());
        assertNull(queue.peek());
    }
    
    @Test
    @DisplayName("Able to clear queue")
    void ableToClearQueue() {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.clear();
        assertEquals(queue.size(), 0);
        assertNull(queue.poll());
        assertNull(queue.peek());
    }
    
    @Test
    @DisplayName("Able to check if queue is empty")
    void queueIsEmptyTest() {
        assertTrue(queue.isEmpty());
        queue.add("Item 1");
        assertFalse(queue.isEmpty());
        queue.pop();
        assertTrue(queue.isEmpty());
    }
}
