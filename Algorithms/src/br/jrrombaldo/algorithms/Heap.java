package br.jrrombaldo.algorithms;

public class Heap extends BaseAlgorithm {

    protected static void insert(int[] vect, int k) {
	int n = getN(vect);
	vect[n + 1] = k;
	swim(vect, n + 1);
    }

    protected static int delMax(int[] vect) {
	int n = getN(vect);
	int max = vect[1];
	vect[1] = vect[n];
	vect[n] = 0;
	sink(vect, 1);

	return max;
    }

    protected static int getN(int[] vect) {
	int n = 0;
	for (n = vect.length - 1; n > 0 && vect[n] == 0; n--) {
	}
	return n;
    }

    /* Bottom-up reheapify (swim) */
    protected static void swim(int[] vect, int k) {
	while (k > 1 && vect[k] > vect[k / 2]) {
	    swap(vect, k, k / 2);
	    k = k / 2;
	}
    }

    /* Top-down heapify (sink) */
    protected static void sink(int[] vect, int k) {
	int n = getN(vect);
	while (2 * k <= n) {
	    /* j = greater son */
	    int j = vect[2 * k] > vect[2 * k + 1] ? (2 * k) : (2 * k + 1);

	    if (vect[k] < vect[j])
		swap(vect, j, k);
	    k = j;
	}
    }

    public static void main(String[] args) {
	int[] heap = new int[32];

	System.out.println("testing insert...");
	for (int x : _vect) {
	    insert(heap, x);
	}
	print(heap);

	System.out.println("\n\ntesting delmax...");
	for (int y = 0; y < 10; y++) {
	    System.out.println("del: " + delMax(heap));
	    print(heap);
	}
    }

}
