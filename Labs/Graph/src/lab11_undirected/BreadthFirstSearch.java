package lab11_undirected;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch extends AbstractGraphSearch {
	protected HashMap<Vertex, Vertex> visitedVertices = new HashMap<Vertex, Vertex>();
	Graph graph;
	List<Vertex> vertices = null;
	Iterator<Vertex> iterator = null;
	HashMap<Vertex,LinkedList<Vertex>> adjacencyList;
	protected int numVertices;
	Queue<Vertex> queue;
	
	public BreadthFirstSearch(Graph g) {
		this.graph = g;
		queue = new ArrayDeque<Vertex>();
		vertices = g.vertices;
		numVertices = vertices.size();
		adjacencyList = graph.getAdjacencyList();
		System.out.println(adjacencyList);
	}

	@Override
	protected boolean someVertexUnvisited() {
		return visitedVertices.size()<numVertices;
	}

	public boolean getHasBeenVisited(Vertex v) {
		return visitedVertices.containsKey(v);
	}
	public void setHasBeenVisited(Vertex v) {
		visitedVertices.put(v,v);
	}
		
	protected void processVertex(Vertex w){
		
	}
	
	@Override
	protected void handleInitialVertex() {
		Vertex v = nextUnvisited();
		if(v != null){
			setHasBeenVisited(v);
			processVertex(v);
			queue.add(v);
		}
	}

	@Override
	protected void singleComponentLoop() {
		while(!queue.isEmpty()){
			Vertex v = nextUnvisitedAdjacent(queue.peek());
			while(v!=null) { 
				setHasBeenVisited(v);
				processEdge(new Edge(queue.peek(),v));
				processVertex(v);
				queue.add(v);
				v=nextUnvisitedAdjacent(queue.peek());
			}
			
		}
	}

	protected void processEdge(Edge edge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void additionalProcessing() {
		// TODO Auto-generated method stub
		
	}
	
	public Vertex nextUnvisited() {
		while(iterator.hasNext()){
			Vertex next = iterator.next();
			if(!visitedVertices.containsKey(next)){
				return next;
			}
		}
		return null;
	}
	
	public Vertex nextUnvisitedAdjacent(Vertex v) {
		List<Vertex> listOfAdjacent = adjacencyList.get(v);
		Iterator<Vertex> it = listOfAdjacent.iterator();
		Vertex retVert = null;
		//this loop will visit each element matched with v in the adjacency list
		//ONLY ONCE, since whenever a list element is encountered, 
		//it is removed after processing 
		while(it.hasNext()) {
			Vertex u = it.next();
			if(visitedVertices.containsKey(u)) {
				it.remove();
			}
			if(!visitedVertices.containsKey(u)) {
				retVert = u;
				it.remove();
				return retVert;				
			}	
		}
		//unvisited adjacent vertex not found
		return retVert;  //returning null
	}

}
