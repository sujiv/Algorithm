package lab11_undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnectedComponentSearch extends DepthFirstSearch {
	ArrayList<List<Vertex>> componentMap = new ArrayList<>();
	HashMap<Vertex,Integer> vertexComponentMap = new HashMap<>();
	int currentComponentNumber = 0;
	public ConnectedComponentSearch(Graph graph) {
		super(graph);
	}
	
	@Override
	protected void handleInitialVertex() {
		if(currentComponentNumber<=componentMap.size())
			componentMap.add(new ArrayList<>());
		super.handleInitialVertex();
	}
	
	
	
	@Override
	public void processVertex(Vertex v) {
		//super.processVertex(v);
		componentMap.get(currentComponentNumber).add(v);
		vertexComponentMap.put(v, currentComponentNumber);
	}
	
	@Override
	public void additionalProcessing() {
		super.additionalProcessing();
		//if(someVertexUnvisited()) {
			currentComponentNumber++;
			//componentMap.add(new ArrayList<>());
			//System.out.println(someVertexUnvisited());
		//}
	}
	
	public int computeConnectedComponent() {
		super.start();
		return currentComponentNumber;
	}
}
