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
	public void clear() {
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		return null;
	}

	@Override
	public int indexOf(Object data) {
		return -1;
	}

	@Override
	public boolean contains(Object data) {
		return false;
	}
}