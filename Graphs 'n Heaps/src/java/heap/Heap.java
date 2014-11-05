/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */

package heap;

import java.util.ArrayList;

/**
 * This is an array-based binary tree implementation of the priority queue.
 * @author Xan Mead
 */
public class Heap <T extends Comparable<T>> implements PriQueueInterface {
	
	/** Elements in the priority queue.*/
	private ArrayList<T> elements;
	
	/** Index of the last element in the collection.*/
	private int lastIndex;
	
	/** Largest allowed index in the collection.*/
	private int maxIndex;
	
	/**
	 * Creates an empty heap.
	 * @param maxSize maximum number of elements allowed in the heap.
	 */
	public Heap(int maxSize) {
		this.elements = new ArrayList<>(maxSize);
		this.lastIndex = -1;
		this.maxIndex = maxSize - 1;
	}
	
	@Override
	public boolean isEmpty() {
		return lastIndex == -1;
	}

	@Override
	public boolean isFull() {
		return lastIndex == maxIndex;
	}

	@Override
	public void enqueue(Comparable element) throws PriQOverflowException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Comparable dequeue() throws PriQUnderflowException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
