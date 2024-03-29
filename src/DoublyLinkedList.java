/**
 * This class implements a DoublyLinkedList. This is done using the classes
 * LinkedList and Link.
 * 
 * A linked list is simplar to an array, it holds values. However,
 * links in a linked list do not have indees. With a linked list
 * you do not need to predetermine it's size as it grows and shrinks
 * as it is edited. This is an example of a double ended, doubly
 * linked list. Each link references the next link and the previous
 * one.
 * 
 * @author Unknown
 *
 */

class DoublyLinkedList{
	/** Head refers to the front of the list */
	private Link head;
	/** Tail refers to the back of the list */
	private Link tail;

	/**
	 * Constructor
	 */
	public DoublyLinkedList(){
		head = null;
		tail = null;
	}

	/**
	 * Insert an element at the head
	 * 
	 * @param x Element to be inserted
	 */
	public void insertHead(int x){
		Link newLink = new Link(x); //Create a new link with a value attached to it
		if(isEmpty()) //Set the first element added to be the tail
			tail = newLink;
		else
			head.previous = newLink; // newLink <-- currenthead(head)
		newLink.next = head; // newLink <--> currenthead(head)
		head = newLink; // newLink(head) <--> oldhead
	}

	/**
	 * Insert an element at the tail
	 * 
	 * @param x Element to be inserted
	 */
	public void insertTail(int x){
		Link newLink = new Link(x);
		newLink.next = null; // currentTail(tail)     newlink -->
		tail.next = newLink; // currentTail(tail) --> newLink -->
		newLink.previous = tail; // currentTail(tail) <--> newLink -->
		tail = newLink; // oldTail <--> newLink(tail) -->
	}

	/**
	 * Delete the element at the head
	 * 
	 * @return The new head
	 */
	public Link deleteHead(){
		Link temp = head;
		head = head.next; // oldHead <--> 2ndElement(head)
		head.previous = null; // oldHead --> 2ndElement(head) nothing pointing at old head so will be removed
		if(head == null)
			tail = null;
		return temp;
	}

	/**
	 * Delete the element at the tail
	 * 
	 * @return The new tail
	 */
	public Link deleteTail(){
		Link temp = tail;
		tail = tail.previous; // 2ndLast(tail) <--> oldTail --> null
 		tail.next = null; // 2ndLast(tail) --> null
		return temp;
	}

	/**
	 * Delete the element from somewhere in the list
	 * 
	 * @param x element to be deleted
	 * @return  Link deleted
	 */
	public Link delete(int x){
		Link current = head;

		while(current.value != x) //Find the position to delete
			current = current.next;

		if(current == head)
			deleteHead();

		else if(current == tail)
			deleteTail();

		else{ //Before: 1 <--> 2(current) <--> 3
			current.previous.next = current.next;  // 1 --> 3
			current.next.previous = current.previous; // 1 <--> 3
		}
		return current;
	}

	/**
	 * Inserts element and reorders
	 * 
	 * @param x Element to be added
	 */
	public void insertOrdered(int x){
		Link newLink = new Link(x);
		Link current = head;
		while(current != null && x > current.value) //Find the position to insert
			current = current.next;

		if(current == head)
			insertHead(x);

		else if(current == null)
			insertTail(x);

		else{ //Before: 1 <--> 2(current) <--> 3
			newLink.previous = current.previous; // 1 <-- newLink
			current.previous.next = newLink; // 1 <--> newLink
			newLink.next = current; // 1 <--> newLink --> 2(current) <--> 3
			current.previous = newLink; // 1 <--> newLink <--> 2(current) <--> 3
		}
	}

	/**
	 * Returns true if list is empty
	 * 
	 * @return true if list is empty
	 */
	public boolean isEmpty(){
		return(head == null);
	}

	/**
	 * Prints contents of the list
	 */
	public void display(){ //Prints contents of the list
		Link current = head;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
	// custom methods because this project sucks
	
	public int size() {
		int count = 0;
		Link current = head;
		while(current!=null){
			count++;
			current = current.next;
		}
		
		return count;
	}
}

/**
 * This class is used to implement the nodes of the
 * linked list.
 * 
 * @author Unknown
 *
 */
class Link{
	/** Value of node */
	public int value;
	/** This points to the link in front of the new link */
	public Link next;
	/** This points to the link behind the new link */
	public Link previous;

	/**
	 * Constructor
	 * 
	 * @param value Value of node
	 */
	public Link(int value){
		this.value = value;
	}

	/**
	 * Displays the node
	 */
	public void displayLink(){
		System.out.print(value+" ");
	}
}
