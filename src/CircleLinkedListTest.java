
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CircleLinkedListTest {
    private CircleLinkedList circleLinkedList;

    @Before
    public void setUp() throws Exception {
        circleLinkedList = new CircleLinkedList();
    }

    @Test
    public void getSizeNoElementsAdded() {
        int expected = 0;
        assertEquals(expected, circleLinkedList.getSize());
    }

    @Test
    public void getSizeOneElementAdded() {
        int expected = 1;
        circleLinkedList.append(10);
        assertEquals(expected, circleLinkedList.getSize());
    }

    @Test
    public void getSizeFiftyThousandElementsAdded() {
        int expected = 50000;
        for (int i = 0; i < expected; i++) {
            circleLinkedList.append(i);
        }
        assertEquals(expected, circleLinkedList.getSize());
    }

    @Test
    public void appendOneElement() {
        int expectedSize = 1;
        circleLinkedList.append("howdy");
        assertEquals(expectedSize, circleLinkedList.getSize());

    }

    @Test(expected = NullPointerException.class)
    public void appendNullElement() {
        circleLinkedList.append(null);
    }

    @Test
    public void appendElementsOfDifferentTypes() {
        int expectedSize = 7;
        circleLinkedList.append(1);
        circleLinkedList.append('c');
        circleLinkedList.append(3.14);
        circleLinkedList.append(false);
        circleLinkedList.append("howdy");
        circleLinkedList.append(6f);
        circleLinkedList.append(new BigInteger("1008"));
        assertEquals(expectedSize, circleLinkedList.getSize());
    }

    @Test
    public void removeOneElement() {
        int expectedSize = 6;
        circleLinkedList.append(1);
        circleLinkedList.append('c');
        circleLinkedList.append(3.14);
        circleLinkedList.append(false);
        circleLinkedList.append("howdy");
        circleLinkedList.append(6f);
        circleLinkedList.append(new BigInteger("1008"));
        circleLinkedList.remove(4);
        assertEquals(expectedSize, circleLinkedList.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementAtNegativePosition() {
        circleLinkedList.append(1);
        circleLinkedList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementAbovePosition() {
        circleLinkedList.append(1);
        circleLinkedList.remove(100);
    }
}