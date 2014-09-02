package codility.challenges;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.generic.BucketOfDistinctArrayValues;

/**
 	Alpha2010
	-------------------
 	A non-empty zero-indexed array A consisting of N integers is given. 
 	The first covering prefix of array A is the smallest integer P such that 0<=P<N 
 	and such that every value that occurs in array A also occurs in sequence A[0], A[1], ..., A[P].
 	
	For example, the first covering prefix of the following 5-element array A:
	A[0] = 2  
	A[1] = 2  
	A[2] = 1
	A[3] = 0  
	A[4] = 1
	is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.
	Write a function
	int solution(int[] A);
	that, given a zero-indexed non-empty array A consisting of N integers, returns the first covering prefix of A.
	For example, given array A such that
	A[0] = 2  
	A[1] = 2  
	A[2] = 1
	A[3] = 0  
	A[4] = 1
	the function should return 3, as explained above.
	Assume that:
	N is an integer within the range [1..1,000,000];
	each element of array A is an integer within the range [0..N-1].
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
 */
public class FirstCoveringPrefix
{
	
	@Test
	public void test() 
	{
		FirstCoveringPrefix p = new FirstCoveringPrefix();
		assertEquals(0, p.solution(new int[] {}));
		assertEquals(0, p.solution(new int[] {0}));
		assertEquals(0, p.solution(new int[] {0,0}));
		assertEquals(1, p.solution(new int[] {0,1}));
		assertEquals(0, p.solution(new int[] {0,0,0}));
		assertEquals(1, p.solution(new int[] {0,1,1}));
		assertEquals(2, p.solution(new int[] {0,1,2}));
		assertEquals(2, p.solution(new int[] {0,2,1}));
		assertEquals(2, p.solution(new int[] {2,0,1}));
		assertEquals(0, p.solution(new int[] {2,2,2}));
		assertEquals(4, p.solution(new int[] {0,1,2,3,4}));
	}

    public int solution(int[] a) 
    {
    	if (a.length == 0) {
    		return 0;
    	}
    	int[] distinct = new BucketOfDistinctArrayValues().solution(a);
    	int firstCoveringIndex = testFromEndIfElementsAreRedundant(a, distinct);
    	return firstCoveringIndex;
    }

	private int testFromEndIfElementsAreRedundant(int[] a, int[] distinct)
	{
		int firstCoveringIndex = a.length - 1;
		int i = a.length - 1;
		while (i >= 0 && firstCoveringIndex > 0 && isElementRedundant(a, distinct, i))
		{
			firstCoveringIndex = i - 1;
			i--;
		}
		return firstCoveringIndex;
	}

	/**
	 * an element is redundant if it appears more than once in the array
	 * each time we pass such an element we subtract 1 from its bucket, so when we reach the first occurance
	 * of this element in the array we know we have to stop.
	 */
	private boolean isElementRedundant(int[] a, int[] distinct, int i) 
	{
		if (distinct[a[i]] > 1) {
			distinct[a[i]]--;
			return true;
		}
		return false;
	}
}
