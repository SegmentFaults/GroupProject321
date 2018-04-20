import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTests {

	
	/* Input Space Partitioning
	 * 
	 * Week05_Day01_ISP
	 * 
	 * Parameters: list...
	 * Characteristic1:
	 * 	block1
	 * 	block2
	 * 	block3
	 *
	 * Characteristic2:
	 *	block1
	 *	block2
	 *	block3
	 */
	
	
	private DoublyLinkedList list = null;	
	
	@Before
	public void setUp() throws Exception {
		list = new DoublyLinkedList();
	}

	
	/*
	 * Parameters: none
	 * Characteristic
	 * 
	 */
	@Test
	public void testInsertHead() {	
		list.insertHead(0);
		
		assertEquals(1, list.size());
	}

	@Test
	public void testInsertTail() {
		list.insertTail(1);
		
		assertEquals(1, list.size());
	}

	@Test
	public void testDeleteHead() {
		list.insertHead(1);
		
		Link newHead = list.deleteHead();
		
		assertEquals(null, newHead);
	}

	@Test
	public void testDeleteTail() {
		list.insertTail(1);
		
		Link newTail = list.deleteTail();
		
		assertEquals(null, newTail);
	}

	@Test
	public void testDelete() {
		list.insertHead(0);
		
		Link deleted = list.delete(0);
		
		assertEquals(0, deleted.value);
	}

	@Test
	public void testInsertOrdered() {
		list.insertOrdered(0);
		
		assertEquals(1, list.size());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, list.isEmpty());
		
		list.insertHead(0);
		
		assertEquals(false, list.isEmpty());
	}
}
