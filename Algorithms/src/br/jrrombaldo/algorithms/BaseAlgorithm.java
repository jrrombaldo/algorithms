package br.jrrombaldo.algorithms;

import java.util.Random;

public class BaseAlgorithm {

    protected static int[] _vect = { 23, 50, 10, 99, 18, 24, 97, 84, 11, 10,
	    77, 13, 54, 98, 77 };

    protected static Random _rand = new Random();

    protected static void print(int[] vect) {
	
	for (int i : vect) {
	    System.out.print(i + " ");
	}
	System.out.println("");
	
	assert isSorted(vect);
    }

    public static boolean isSorted(int[] vect){
	for(int i=0; i< vect.length -1 ; i++){
	   if (vect[i] > vect[i+1])
	       return false;
	}
	return true;
    }

    protected static void swap(int[] vect, int k1, int k2) {
	int aux = vect[k1];
	vect[k1] = vect[k2];
	vect[k2] = aux;
    }

    protected static void shuffle(int[] vect) {
	for (int i = 0; i < vect.length; i++)
	    swap(vect, i, _rand.nextInt(vect.length));
    }

    public static void main(String args[]) {
	shuffle(_vect);
	print(_vect);
    }

}
