package lab11_undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortPathLength extends BreadthFirstSearch {
	HashMap<Vertex,Integer> levelsMap = new HashMap<>();
	HashMap<Vertex,Vertex> parentMap = new HashMap<>();
	Vertex start, end;
	
	public ShortPathLength(Graph g) {
		super(g);
	}
	
	public List<Vertex> computeShortestPath(Vertex s, Vertex e){
		start = s;
		end = e;
		Vertex trav = e;
		super.start();
		List<Vertex> shortPath = new ArrayList<Vertex>();
		System.out.println(parentMap);
		System.out.println(levelsMap);
		while(parentMap.get(trav)!=trav) {
			shortPath.add(0,trav);
			trav = parentMap.get(trav);
		}
		shortPath.add(0,start);
		System.out.println("Shortest path length is:"+levelsMap.get(end));
		return shortPath;
	}

	@Override
	protected void handleInitialVertex() {
		setHasBeenVisited(start);
		levelsMap.put(start, 0);
		parentMap.put(start,start);
		queue.add(start);
	}

	@Override
	protected void singleComponentLoop() {
		while(!queue.isEmpty()){
			Vertex v = nextUnvisitedAdjacent(queue.peek());
			while(v!=null) { 
				System.out.println("Vertex: "+v);
				setHasBeenVisited(v);
				processEdge(new Edge(queue.peek(),v));
				processVertex(v);
				queue.add(v);
				v=nextUnvisitedAdjacent(queue.peek());
				System.out.println("Queue: "+queue);
			}
			queue.remove();
		}
	}

	@Override
	protected void processVertex(Vertex w){
		levelsMap.put(w, levelsMap.get(parentMap.get(w))+1);
	}
	
	@Override
	protected void processEdge(Edge edge) {
		parentMap.put(edge.v, edge.u);
	}
}
