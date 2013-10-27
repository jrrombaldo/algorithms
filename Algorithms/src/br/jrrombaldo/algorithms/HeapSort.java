package br.jrrombaldo.algorithms;

public class HeapSort extends Heap {

    protected static void heapSort(int[] vect) {
	int n = getN(vect);
	for (int k = n / 2; k >= 1; k--) {
	    sink(vect, k);
	}
    }

    public static void main(String[] args) {
	int[] heap = { 0, 23, 50, 10, 99, 18, 24, 97, 84, 11, 10, 77, 13, 54,
		98, 77 };
	print(heap);
	heapSort(heap);
	print(heap);

    }

}
