package lab11_undirected;


import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Pair> l = new ArrayList<Pair>();
		l.add(new Pair("A","B"));
		l.add(new Pair("B","C"));
		l.add(new Pair("A","D"));
		l.add(new Pair("B","D"));
		l.add(new Pair("D","E"));
		l.add(new Pair("E", "F"));
		Graph g = new Graph(l);
		System.out.println("Spanning Tree:");
		Graph t = g.getSpanningTree();
		System.out.println(t);
		ConnectedComponentSearch c = new ConnectedComponentSearch(g);
		System.out.println("Total Components:"+c.computeConnectedComponent());
		System.out.println(c.componentMap);
		System.out.println(c.vertexComponentMap);
		
		ShortPathLength spl = new ShortPathLength(g);
		System.out.println("Short Path is:"+spl.computeShortestPath(new Vertex("C"), new Vertex("F")));
//		System.out.println("Spanning Tree of the spanning tree:");
//		System.out.println(t.getSpanningTree());
	}

}
