
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SinglyLinkedTest {
    private SinglyLinkedList singleLinkedList;

    @Before
    public void setUp() throws Exception {
        singleLinkedList = new SinglyLinkedList();
    }

    @Test
    public void getSizeNoElementsAdded() {
        int expected = 0;
        assertEquals(expected, singleLinkedList.getSize());
    }

    @Test
    public void getSizeOneElementAdded() {
        int expected = 1;
        singleLinkedList.insertHead(10);
        assertEquals(expected, singleLinkedList.getSize());
    }

    @Test
    public void getSizeFiftyThousandElementsAdded() {
        int expected = 50000;
        for (int i = 0; i < expected; i++) {
            singleLinkedList.insertHead(i);
        }
        assertEquals(expected, singleLinkedList.getSize());
    }

    @Test
    public void insertHeadOneElement() {
        int expectedSize = 1;
        singleLinkedList.insertHead(2);
        assertEquals(expectedSize, singleLinkedList.getSize());

    }
    
    @Test
    public void removeOneElement() {
        int expectedSize = 6;
        singleLinkedList.insertHead(1);
        singleLinkedList.insertHead(2);
        singleLinkedList.insertHead(3);
        singleLinkedList.insertHead(4);
        singleLinkedList.insertHead(5);
        singleLinkedList.insertHead(6);
        singleLinkedList.insertHead(7);
        singleLinkedList.deleteHead();
        assertEquals(expectedSize, singleLinkedList.getSize());
    }

    
    @Test(expected = IndexOutOfBoundsException.class)
    public void insertElementAbovePosition() {
        singleLinkedList.insertHead(1);
        singleLinkedList.insertHead(2);
        singleLinkedList.insertAtNth(3, 6);
    }
}