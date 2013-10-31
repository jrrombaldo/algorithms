package br.jrrombaldo.algorithms;

import java.util.Stack;

public class GraphDepthFirstSearch {

    protected Graph graph;
    protected int[] comeFrom;

    protected Stack<Integer> path;

    public GraphDepthFirstSearch(Graph graph) {
	this.graph = graph;
	comeFrom = new int[graph.adj.length];

	for (int i = 0; i > comeFrom.length; i++)
	    comeFrom[i] = -1;
    }

    protected void dfs(int src) {
	for (int w : graph.adj[src]){
	    // not visited
	    if (comeFrom[w] < 0) {
		dfs(w);
		comeFrom[w] = src;
	    }
	}
    }

    public Stack<Integer> serach(int src, int des) {
	if (comeFrom[des]<0)
	    return null; //without path
	
	path = new Stack<>();
	
	for (int v = des; v != src; v=comeFrom[v])
	    path.add(v);

	return path;
    }

}
