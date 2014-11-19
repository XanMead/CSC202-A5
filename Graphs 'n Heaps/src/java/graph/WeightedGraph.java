/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */
package graph;

import adt.queue.QueueInterface;

/**
 * Implementation of the Graph ADT.
 * This graph is directed and weighted.
 * Edge values are integers.
 * The {@code equals} method of vertices is used throughout.
 * @author Xan Mead
 */
public class WeightedGraph<T> implements WeightedGraphInterface<T> {
	
	/** Special value indicating an undefined edge. */
	public static final int NULL_EDGE = -1;
	
	/** Current number of vertices in the graph. */
	private int numVertices;
	
	/** Maximum number of vertices allowed in this instance. */
	private int maxVertices;
	
	/** Array of the vertices in this graph. */
	private T[] vertices;
	
	/**
	 * Array parallel to {@code vertices}.
	 * Indicates if a vertex has been "visited" in the current traversal.
	 */
	private boolean[] marks;
	
	/** Denotes the weight of the edge from [Vertex A] to [Vertex B]. */
	private int[][] edges;
	
	/**
	 * Creates an empty graph.
	 * @param maxVertices Maximum number of vertices in this graph.
	 */
	public WeightedGraph(int maxVertices) {
		this.maxVertices = maxVertices;
		this.numVertices = 0;
		this.vertices = (T[]) new Object[maxVertices];
		this.marks = new boolean[maxVertices];
		this.edges = new int[maxVertices][];
	}
	
	/** @return Maximum number of vertices allowed in this instance. */
	public int getMaxVertices() { return maxVertices; }
	
	/** {@inheritDoc}*/
	@Override
	public boolean isEmpty() {
		return (numVertices == 0);
	}
	
	/** {@inheritDoc}*/
	@Override
	public boolean isFull() {
		return (numVertices == maxVertices);
	}
	
	/**
	 * {@inheritDoc}
	 * Preconditions:
	 *		The vertex is not null.
	 *		The vertex does not already exist in the graph.
	 *		The graph is not full.
	 */
	@Override
	public void addVertex(T vertex) {
		vertices[numVertices] = vertex;
		for (int i = 0; i <= numVertices; i++) {
			edges[i][numVertices] = NULL_EDGE;
			edges[numVertices][i] = NULL_EDGE;
		}
		numVertices++;
	}
	
	/**
	 * {@inheritDoc}
	 * Precondition: {@code vertex} must not be null.
	 * This implementation uses the vertices' {@code equals} method.
	 */
	@Override
	public boolean hasVertex(T vertex) {
		for (int i = 0; i < numVertices; i++) {
			if (vertices[i].equals(vertex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * Preconditions:
	 *		Both vertices exist in the graph.
	 *		Weight is positive.
	 */
	@Override
	public void addEdge(T fromVertex, T toVertex, int weight) {
		int from;
		int to;
		
		from = indexOf(fromVertex);
		to = indexOf(toVertex);
		
		edges[from][to] = weight;
	}

	@Override
	public int weightIs(T fromVertex, T toVertex) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public QueueInterface<T> getToVertices(T vertex) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void clearMarks() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void markVertex(T vertex) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isMarked(T vertex) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	/**
	 * Finds the index of a vertex.
	 * @param vertex Vertex to find.
	 * @return index of the vertex.
	 */
	private int indexOf(T vertex) {
		int index = 0;
		while (!vertex.equals(vertices[index])) {
			index++;
		}
		return index;
	}
}