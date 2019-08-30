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

		// check if the value appears more than one times. First the left half
		int searchedValueFromindex = nextIndexToBeChecked;
		while (searchedValueFromindex > startIndex) {
			int nextCandidate = array[searchedValueFromindex - 1];
			if (nextCandidate != value) {
				break;
			}

			--searchedValueFromindex;
		}

		// Now the right half.
		int searchedValueUntilIndex = nextIndexToBeChecked;
		while (searchedValueUntilIndex < endIndex) {
			int nextCandidate = array[searchedValueUntilIndex + 1];
			if (nextCandidate != value) {
				break;
			}

			++searchedValueUntilIndex;
		}

		// Now return the pair: from which index until which index, we meet our value
		return new Pair(searchedValueFromindex, searchedValueUntilIndex);
	}
}
