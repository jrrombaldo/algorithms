package br.jrrombaldo.algorithms;

public class MergeSort extends BaseAlgorithm {

    protected static void mergeSort(int[] vect) {
	int[] aux = new int[vect.length];
	int lo = 0;
	int hi = vect.length - 1;

	mergeSort(vect, aux, lo, hi);
    }

    protected static void mergeSort(int[] vect, int[] aux, int lo, int hi) {
	if (hi <= lo)
	    return;

	int mid = (hi - lo) / 2 + lo;
	mergeSort(vect, aux, lo, mid);
	mergeSort(vect, aux, mid + 1, hi);
	merge(vect, aux, lo, mid, hi);
    }

    protected static void merge(int[] vect, int[] aux, int lo, int mid, int hi) {
	for (int x = lo; x <= hi; x++)
	    aux[x] = vect[x];

	int i = lo;
	int j = mid + 1;
	for (int k = lo; k <= hi; k++) {
	    if (i > mid) {
		vect[k] = aux[j++];
	    } else if (j > hi) {
		vect[k] = aux[i++];
	    } else if (aux[i] <= aux[j]) {
		vect[k] = aux[i++];
	    } else {
		vect[k] = aux[j++];
	    }
	}
    }

    public static void main(String[] args) {
	for (int i = 0; i < 30; i++) {
	    mergeSort(_vect);
	    print(_vect);
	}
    }

}
