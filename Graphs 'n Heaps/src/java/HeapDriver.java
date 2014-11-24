/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */

import heap.Heap;
import heap.PriQOverflowException;
import heap.PriQUnderflowException;

/**
 * Test driver for the Heap ADT.
 * @author Xan Mead
 */
public class HeapDriver {
	public static void main(String[] args) {
		String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		Heap<String> heap = new Heap<>(50);
		
                System.out.println("~ENQUEING~");
		System.out.print("Order of insertion:");
		for (int i = 0; i < 50; i++) {
			if (i%5 == 0) {
				System.out.println();
			}
			String hit = "" + set.charAt((int)(Math.random()*26));
			
			try {
				heap.enqueue(hit);
			} catch (PriQOverflowException e) {
				e.printStackTrace();
			}
			
			System.out.print(hit + " ");
		}
		System.out.println();
		
		System.out.println("~DEQUEING~");
                System.out.print("(Output should be sorted):");
		int index = 0;
		while(!heap.isEmpty()) {
			if (index%5 == 0) {
				System.out.println();
			}
			try {
				System.out.print(heap.dequeue() + " ");
			} catch (PriQUnderflowException e) {
				e.printStackTrace();
			}
			index++;
		}
	}
}
