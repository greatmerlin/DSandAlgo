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
		int startIndex = 0;
		int endIndex = array.length - 1;
		int nextIndexToBeChecked = -1;

		while (startIndex <= endIndex) {		// continue as long as the interval between start and end is not empty

			nextIndexToBeChecked = ((endIndex - startIndex) / 2) + startIndex; // middlePointIndex is to be checked, divide the array by 2 and break point of the while loop -> (+ startIndex)
			int candidateValue = array[nextIndexToBeChecked];		// save the middlePointIndex value to a variable

			if (candidateValue == value) {		// If the candidate matches the searched value: break loop & stop searching.
				break;
			}
			else if (candidateValue > value) {
				endIndex = nextIndexToBeChecked - 1;		// set the end index to (middlePointIndex - 1) -> we now search from start to (middlePointIndex - 1) = first half of our start array
			} else {										// if the value > candidateValue
				startIndex = nextIndexToBeChecked + 1;		// set the start index to (middlePointIndex + 1) -> we now search from (middlePointIndex + 1) to endIndex = second half of our start array
			}
		}

		if (nextIndexToBeChecked < 0) {		// If the nextIndexToBeChecked still has its given initial value (-1), the "m" was not found. So we return null -> no result.
			return null;
		}

        // if the value at the found index is not -1 but also still not same as "m" return null (test case 1 & 2)
		int candidate = array[nextIndexToBeChecked];
		if (candidate != value) {
			return null;
		}

		// If the value was found, it might appear more times to the right and/or left within the current bounding box.
		// First, let's check downwards
		int lowerResult = nextIndexToBeChecked;
		while (lowerResult > startIndex) {
			int nextCandidate = array[lowerResult - 1];
			if (nextCandidate != value) {
				break;
			}

			--lowerResult;
		}

		// Then let's see upwards.
		int upperResult = nextIndexToBeChecked;
		while (upperResult < endIndex) {
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
