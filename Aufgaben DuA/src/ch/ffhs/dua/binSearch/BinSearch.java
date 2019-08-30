package ch.ffhs.dua.binSearch;

public class BinSearch 
{
	/**
	 * Findet für einen aufsteigend geordneten Array zu einer Zahl value
	 * den kleinsten und den grössten Index.
	 * @param array
	 * @param value
	 * @return Ein Paar mit kleinestem und grösstem Index oder 
	 * null, wenn der gegebene Wert im array nicht vorkommt.
	 */
	public static Pair search(int[] array, int value) {

		// start and end index of the array. check in this interval for the "m" term
		int start = 0;
		int end = array.length - 1;
		int nextIndexToBeChecked = -1;

		while (start <= end) {		// continue as long as the interval between start and end is not empty

			nextIndexToBeChecked = ((end - start) / 2) + start; // middlePoint is to be checked, divide the array by 2
			int candidate = array[nextIndexToBeChecked];		// save the middlePoint value to a variable

			if (candidate == value) {		// If the candidate matches the searched value: break loop & stop searching.
				break;
			}
			if (value < candidate) {
				end = nextIndexToBeChecked - 1;
			} else {
				start = nextIndexToBeChecked + 1;
			}
		}

		// If the candidateIndex still has its initial value the given array is empty. So no result.
		if (nextIndexToBeChecked < 0) {
			return null;
		}

		// Now we retrieve the value at the found position. It still could be that there's another value. In this case
		// the value is not contained in the array and we return null.
		int candidate = array[nextIndexToBeChecked];
		if (candidate != value) {
			return null;
		}

		// If the value was found, it might appear more times to the right and/or left within the current bounding box.
		// First, let's check downwards
		int lowerResult = nextIndexToBeChecked;
		while (lowerResult > start) {
			int nextCandidate = array[lowerResult - 1];
			if (nextCandidate != value) {
				break;
			}

			--lowerResult;
		}

		// Then let's see upwards.
		int upperResult = nextIndexToBeChecked;
		while (upperResult < end) {
			int nextCandidate = array[upperResult + 1];
			if (nextCandidate != value) {
				break;
			}

			++upperResult;
		}

		// Now we can return the range of indices containing the wanted value
		return new Pair(lowerResult, upperResult);
	}
}
