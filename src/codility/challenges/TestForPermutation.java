package codility.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

import codility.generic.Array;
import codility.generic.Guards;

public class TestForPermutation
{
	private static final int MAX_LEN = 100000;
	private static final int MAX_VALUE = 100000;
	private static final int MIN_VALUE = 1;

	@Test
	public void test()
	{
		TestForPermutation e = new TestForPermutation();
		assertEquals(0, e.solution(new int[] {}));
		assertEquals(1, e.solution(new int[] {1}));
		assertEquals(0, e.solution(new int[] {3}));
		assertEquals(1, e.solution(new int[] {1,2}));
		assertEquals(0, e.solution(new int[] {2,3}));
		assertEquals(0, e.solution(new int[] {0,1}));
		assertEquals(1, e.solution(new int[] {1,3,4,2}));
		assertEquals(0, e.solution(new int[] {5,3,4,2}));
		assertEquals(0, e.solution(new int[] {-1,-3,-4,-2}));
		
		int m = 100000;
		int[] H = new int[m];
		for (int i = 0; i < m; i++)
		{
			H[i] = i + 1;
		}
		assertEquals(1, e.solution(H));
	}
	
	public int solution(int[] A)
	{
		try
		{
			if (Array.isEmpty(A)) {
				return 0;
			}
			Guards.guardLessThanEquals(A.length, MAX_LEN);

			int[] B = new int[A.length];
			for (int i = 0; i < A.length; i++)
			{
				int a = A[i];
				Guards.guardOpenRange(MIN_VALUE, a, MAX_VALUE);
				if (B[a - 1] != 0) {
					return 0;
				}
				B[a - 1] = a;
			}
			return isFull(B);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	private int isFull(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == 0) {
				return 0;
			}
		}
		return 1;
	}

}
