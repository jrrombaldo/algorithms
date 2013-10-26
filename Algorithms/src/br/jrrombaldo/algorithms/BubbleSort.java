package br.jrrombaldo.algorithms;
public class BubbleSort extends BaseAlgorithm {

    protected static void bubbleSort(int[] vect) {
	boolean swapped;
	do {
	    swapped = false;
	    for (int i = 0; i < vect.length - 1; i++) {
		if (vect[i] > vect[i + 1]) {
		    swap(vect, i, i + 1);
		    swapped = true;
		}
	    }
	} while (swapped);
    }

    public static void main(String args[]) {
	bubbleSort(_vect);
	print(_vect);
    }

}
