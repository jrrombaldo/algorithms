package br.jrrombaldo.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    protected List<Integer>[] adj;

    public Graph(int vertices) {
	adj = new ArrayList[vertices];

	for (int i = 0; i < vertices; i++)
	    adj[i] = new ArrayList<>();
    }

    public void addEdge(int v, int w) {
	adj[v].add(w);
	adj[w].add(v);
    }

    public int degree(int v) {
	int degree = 0;
	for (int w : adj[v])
	    degree++;
	return degree;
    }

    public int maxDegree() {
	int max = 0;
	for (int v = 0; v < adj.length; v++) {
	    int degree = degree(v);
	    if (degree > max)
		max = degree;
	}
	return max;
    }

    public int countSelfLoops() {
	int count = 0;
	for (int v = 0; v < adj.length; v++)
	    for (int w : adj[v])
		if (w == v)
		    count++;
	return count / 2;
    }

}
