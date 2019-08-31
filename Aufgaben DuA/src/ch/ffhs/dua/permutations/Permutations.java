package ch.ffhs.dua.permutations;


import java.util.ArrayList;

public class Permutations
{
	/**
	 * Erzeugt ein Array von allen Permutationen von {0,1,2,3,...,n-1}.
	 * @param n Anzahl Elemente in einer Permutation.
	 * @return  Ein Array von Permutationen; jede Permutation ist ein Array von Integern.
	 */

	private static ArrayList<int[]> permutations;

	public static int[][] permutations(int sizeOfArray) {		// renamed "n" to "sizeOfArray" for better var naming
		permutations = new ArrayList<>();

		int[] arrayOfInt = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arrayOfInt[i] = i;
		}

		permutations(arrayOfInt, sizeOfArray);		// use the @overloaded Method permutations with 2 parameters (int[], n): see below

		int[][] result = new int[permutations.size()][];

		for (int i = 0; i < permutations.size(); i++) {
			result[i] = permutations.get(i);
		}

		return result;
	}

	/*
	 * This is a Recursive generator method.
	 * for the method clone() used below: a Method from the java.lang.Object package.
	 * "Object cloning refers to creation of exact copy of an object. It creates a new instance of the class of
	 * current object and initializes all its fields with exactly the contents of the corresponding fields of
	 * this object."
	 * source: GeeksForGeeks.org
	 * */
	private static void permutations(int[] arrayOfInt, int sizeOfArray) {

		if (sizeOfArray == 1) {
			permutations.add(arrayOfInt.clone());
			return;
		}

		for (int i = 0; i < sizeOfArray; i++) {
			swap(arrayOfInt, i, sizeOfArray - 1);		// the swap method is written below
			permutations(arrayOfInt, sizeOfArray - 1);		// recursion
			swap(arrayOfInt, i, sizeOfArray - 1);
		}
	}

	// Swap two values in an array
	private static void swap(int[] array, int xValue, int yValue) {
		int xValueTempSaved = array[xValue];
		array[xValue] = array[yValue];
		array[yValue] = xValueTempSaved;

	}
}
