package br.jrrombaldo.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GraphBreadthFirtPaths {
    protected boolean[] marked;
    protected int[] cameFrom;
    protected int[] distance;

    protected Graph graph;

    public GraphBreadthFirtPaths(Graph graph) {
	this.graph = graph;
	marked = new boolean[graph.adj.length];
	cameFrom = new int[graph.adj.length];
	distance = new int[graph.adj.length];

	for (int d = 0; d < distance.length; d++)
	    distance[d] = -1;
    }

    protected void bsf(int src) {
	List<Integer> srcList = new ArrayList<>();

	distance[src] = 0;
	marked[src] = true;
	srcList.add(src);

	while (srcList.size() > 0) {
	    int v = srcList.get(0);
	    srcList.remove(0);

	    for (int w : graph.adj[v]) {
		if (!marked[w]){
		    cameFrom[w] = v;
		    distance[w] = distance[v]+1;
		    marked[w] = true;
		    srcList.add(w);
		}
	    }
	}
    }
    
    public int dintance(int dst){
	return distance[dst];
    }
    
    public boolean isTherePath(int dst){
	return marked[dst];
    }
    
    public void pathTo(int dst) {
        for (int x = dst; distance[x] != 0; x = cameFrom[x])
           System.out.println(x);
    }

}
