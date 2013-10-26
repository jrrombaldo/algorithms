package br.jrrombaldo.algorithms;
public class BinarySearch extends BaseAlgorithm {

    protected static boolean binarySearch(int key, int[] vect) {
	int low = 0;
	int max = vect.length - 1;

	while (low <= max) {
	    int mid = (max - low) / 2;

	    if (key == vect[mid])
		return true;
	    else if (key < vect[mid])
		max = mid - 1;
	    else
		low = mid + 1;
	}

	return false;
    }

    public static void main(String args[]) {
	System.out.println(binarySearch(23, _vect));
    }

}
