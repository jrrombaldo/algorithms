package br.jrrombaldo.algorithms;

public class QuickSort extends BaseAlgorithm {

    protected static void quickSort(int[] vect) {
	shuffle(vect);
	int k = quickSortPartition(vect, 0, vect.length - 1);
	quickSort(vect, 0, k - 1);
	quickSort(vect, k + 1, vect.length - 1);
    }

    protected static void quickSort(int[] vect, int lo, int hi) {
	if (lo >= hi)
	    return;// finished
	int k = quickSortPartition(vect, lo, hi);
	quickSort(vect, lo, k - 1);
	quickSort(vect, k + 1, hi);
    }

    protected static int quickSortPartition(int[] vect, int lo, int hi) {
	int i = lo + 1;
	int j = hi;
	int key = lo;
	boolean contin = true;

	while (contin) {
	    while (vect[i] < vect[key] && i < hi) {
		i++;
	    }
	    while (vect[j] > vect[key] && j > lo) {
		j--;
	    }

	    if (i >= j) {
		swap(vect, key, j);
		break;
	    }
	    swap(vect, i, j);
	}
	return j;
    }

    public static void main(String args[]) {
	for (int i = 0; i < 30; i++) {
	    quickSort(_vect);
	    print(_vect);
	}

    }
}
