package br.jrrombaldo.algorithms;

public class QuickFindUnion {

    private int[] id;
    public int count;

    public QuickFindUnion(int n) {
	count = n;
	id = new int[n];
	for (int i = 0; i < n; i++)
	    id[i] = i;
    }

    public int find(int p) {
	return id[p];
    }

    public boolean connected(int p, int q) {
	return id[p] == id[q];
    }

    public void union(int p, int q) {
	if (connected(p, q))
	    return;
	int pid = id[p];
	for (int i = 0; i < id.length; i++)
	    if (id[i] == pid)
		id[i] = id[q];
	count--;
    }

}
