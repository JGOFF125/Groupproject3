package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;

	// first node in the list
	private Node head;

	// last node in the list
	private Node tail;

	// keeps track of how many nodes are in the list
	private int size;

	// starts the list empty
	public SLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);

		// if list is empty, new node becomes head and tail
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			// new node goes in front of current head
			newNode.setNext(this.head);
			this.head = newNode;
		}

		this.size++;
	}

	@Override
	public void append(Object data) {
		Node newNode = new Node(data);

		// if list is empty, new node becomes head and tail
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			// current tail points to new node, then tail moves
			this.tail.setNext(newNode);
			this.tail = newNode;
		}

		this.size++;
	}

	// these are for the other parts of the project
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}

		if (index == 0) {
			prepend(data);
		} else if (index == this.size) {
			append(data);
		} else {
			Node current = this.head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			Node newNode = new Node(data);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			this.size++; 
		}
	}

	public void set(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
		Node current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		current.setData(data); 
	}

	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
		Node current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	@Override
	public int indexOf(Object data) {
		Node current = this.head;
		int index = 0;
		while (current != null) {
			if (current.getData().equals(data)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1; 
	}

	@Override
	public boolean contains(Object data) {
		return indexOf(data) != -1;
	}

	

	@Override
	public void clear() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
	}


	/**
	 * Person 3: Cleanup & Deletion
	 * Removes the node at the specified index from the linked list.
	 * * @param index The position of the node to remove (0-based).
	 * @throws IndexOutOfBoundsException if the index is invalid.
	 */
	public void remove(int index) throws IndexOutOfBoundsException {
		// 1. Boundary Check: Ensure the index actually exists
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}

	// Case 1: Removing the very first node (Head)
		if (index == 0) {
			// Tell the head pointer to skip the first person and point to the second person
			this.head = this.head.getNext();
			
			// If we just deleted the ONLY person in the list, the tail needs to be null too
			if (this.head == null) {
				this.tail = null;
			}
		} 
	 //Removing from the middle or the end
		else {
			// Start at the front
			Node current = this.head;
			
			// Walk forward until we are standing exactly ONE spot BEFORE the node we want to delete
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			
			// Identify the specific node we are kicking out
			Node nodeToRemove = current.getNext();
			
			// Rewire the chain: Tell the current node to bypass the deleted node and grab the next one
			current.setNext(nodeToRemove.getNext());
			
			// If the node we just kicked out happened to be the Tail (the very last node),
			//  update the tail pointer to look at the new last person.
			if (nodeToRemove == this.tail) {
				this.tail = current;
			}
		}
		
		// Shrink the size tracker by 1 since we successfully removed someone
		this.size--; 
	}
		
	}

