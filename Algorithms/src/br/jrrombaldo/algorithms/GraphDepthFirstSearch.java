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

    public void dfs(int src) {
	for (int w : graph.adj[src]) {
	    // not visited
	    if (comeFrom[w] < 0) {
		dfs(w);
		comeFrom[w] = src;
	    }
	}
    }

    public boolean isTherePath(int dst) {
	return comeFrom[dst] > 0;
    }

    public void pathTo(int src, int des) {
	for (int v = des; v != src; v = comeFrom[v])
	    System.out.println(path);

    }

}
