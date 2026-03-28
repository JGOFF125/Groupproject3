package sait.sll.utility;

import java.io.Serializable;

public class Node implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// stores the actual object/data inside the node
	private Object data;
	
	private Node next;

	public Node() {
		this.data = null;
		this.next = null;
	}

	public Node(Object data) {
		this.data = data;
		this.next = null;
	}

	// This returns the data stored in the node
	public Object getData() {
		return data;
	}

	// Then here we update the data stored in the node
	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	// This sets the next node reference
	public void setNext(Node next) {
		this.next = next;
	}
}