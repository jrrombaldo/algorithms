package br.jrrombaldo.algorithms;

public class MergeSort extends BaseAlgorithm {

    protected static void mergeSort(int[] vect) {
	int[] aux = new int[vect.length];
	int lo = 0;
	int hi = vect.length;

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
	System.out.println(lo+" "+mid+" "+hi );
    }

    
    public static void main (String[] args){
	
	mergeSort(_vect);
	print(_vect);
    }
    
}
