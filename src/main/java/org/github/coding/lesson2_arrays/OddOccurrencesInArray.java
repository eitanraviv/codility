package org.github.coding.lesson2_arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 A non-empty zero-indexed array A consisting of N integers is given.
 The array contains an odd number of elements, and each element of the
 array can be paired with another element that has the same value, except
 for one element that is left unpaired.

 For example, in array A such that:

 A[0] = 9  A[1] = 3  A[2] = 9
 A[3] = 3  A[4] = 9  A[5] = 7
 A[6] = 9
 the elements at indexes 0 and 2 have value 9,
 the elements at indexes 1 and 3 have value 3,
 the elements at indexes 4 and 6 have value 9,
 the element at index 5 has value 7 and is unpaired.
 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

 For example, given array A such that:

 A[0] = 9  A[1] = 3  A[2] = 9
 A[3] = 3  A[4] = 9  A[5] = 7
 A[6] = 9
 the function should return 7, as explained in the example above.

 Assume that:

 N is an odd integer within the range [1..1,000,000];
 each element of array A is an integer within the range [1..1,000,000,000];
 all but one of the values in A occur an even number of times.
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.

 * @author eitanraviv
 * @since 12 Jan 2016
 */
public class OddOccurrencesInArray
{
	@Test
	public void test()
	{
		OddOccurrencesInArray p = new OddOccurrencesInArray();

		assertEquals(1, p.solution(new int[]{1}));
		System.out.println("--------------");
		assertEquals(2, p.solution(new int[]{1, 2, 1}));
		System.out.println("--------------");
		assertEquals(3, p.solution(new int[]{1, 1, 2, 2, 3}));
		System.out.println("--------------");
		assertEquals(4, p.solution(new int[]{2, 2, 4}));
		System.out.println("--------------");
		assertEquals(4, p.solution(new int[]{1,2,3,4,3,2,1}));
		System.out.println("--------------");
		assertEquals(4, p.solution(new int[]{1,2,3,4,1,2,3}));
	}

	/**
	 */
	public int solution(int[] A)
	{
		if (A.length == 1) {
			return A[0];
		}
		int odd = 0;
		for (int i = 0; i < A.length; i++)
		{
			odd ^= A[i];
			System.out.println(odd);
		}
		return odd;
	}
}