package org.github.coding.lesson8_primes_composites;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import org.github.coding.generic.GetFactorsAscending;

/**
	A non-empty zero-indexed array A consisting of N integers is given.
	A peak is an array element which is larger than its neighbors. 
	More precisely, it is an index P such that 0 < P < N - 1,  A[P - 1] < A[P] and A[P] > A[P + 1].
	For example, the following array A:
	    A[0] = 1
	    A[1] = 2
	    A[2] = 3
	    A[3] = 4
	    A[4] = 3
	    A[5] = 4
	    A[6] = 1
	    A[7] = 2
	    A[8] = 3
	    A[9] = 4
	    A[10] = 6
	    A[11] = 2
	has exactly three peaks: 3, 5, 10.
	We want to divide this array into blocks containing the same number of elements. 
	More precisely, we want to choose a number K that will yield the following blocks:
	A[0], A[1], ..., A[K - 1],
	A[K], A[K + 1], ..., A[2K - 1],
	...
	A[N - K], A[N - K + 1], ..., A[N - 1].
	What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K - 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).
	The goal is to find the maximum number of blocks into which the array A can be divided.
	Array A can be divided into blocks as follows:
	one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
	two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
	three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. 
	Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
	However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain
	a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].
	The maximum number of blocks that array A can be divided into is three.
	Write a function: int solution(int A[]);
	that, given a non-empty zero-indexed array A consisting of N integers, returns the maximum number of blocks into which A can be divided.
	If A cannot be divided into some number of blocks, the function should return 0.
	For example, given:
	    A[0] = 1
	    A[1] = 2 
	    A[2] = 3 
	    A[3] = 4 
	    A[4] = 3 
	    A[5] = 4 
	    A[6] = 1 
	    A[7] = 2 
	    A[8] = 3 
	    A[9] = 4 
	    A[10] = 6 
	    A[11] = 2
	the function should return 3, as explained above.
	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [0..1,000,000,000].
	Complexity:
	expected worst-case time complexity is O(N*log(log(N)));
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified. *
 */
public class Peaks
{
	
	@Test
	public void test() 
	{
		Peaks p = new Peaks();
		assertEquals(0, p.solution(new int[] {}));
		assertEquals(0, p.solution(new int[] {0}));
		assertEquals(0, p.solution(new int[] {1}));
		assertEquals(0, p.solution(new int[] {1,1}));
		assertEquals(0, p.solution(new int[] {1,2}));
		assertEquals(0, p.solution(new int[] {2,1}));
		assertEquals(1, p.solution(new int[] {1,2,1}));
		assertEquals(0, p.solution(new int[] {1,2,2}));
		assertEquals(0, p.solution(new int[] {1,2,2,2}));
		assertEquals(0, p.solution(new int[] {2,2,2,2,2,2,2}));
		assertEquals(0, p.solution(new int[] {1,2,3,4,5,6,7}));
		assertEquals(1, p.solution(new int[] {1,2,3,4,5,1000,7}));
		assertEquals(1, p.solution(new int[] {1,2,1,2}));
		assertEquals(2, p.solution(new int[] {1,2,1,2,1,2,1,2}));
		assertEquals(3, p.solution(new int[] {1,2,1,2,1,2,1,2,1}));
		assertEquals(3, p.solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
	}
	
    public int solution(int[] a) 
    {
    	if (a.length < 3) {
    		return 0;
    	}
    	Integer[] peaks = findPeaks(a);
    	if (peaks.length == 0) {
    		return 0;
    	}
    	int[] factors = new GetFactorsAscending().solution(a.length);
    	int indexForMaxNumOfBlocks = Arrays.binarySearch(factors, peaks.length);
    	int factorsIndex = indexForMaxNumOfBlocks < 0 ? factors.length - 1 : indexForMaxNumOfBlocks;
    	boolean success = true;
    	while (factorsIndex >= 0)
    	{
    		success = true;
	    	int blockSize = a.length / factors[factorsIndex];
	    	for (int countBlocks = 1; countBlocks <= factors[factorsIndex]; countBlocks++)
	    	{
	    		int lowerBlockIndex = (blockSize * (countBlocks - 1));
	    		int upperBlockIndex = blockSize * countBlocks - 1;
	    		int peaksIndex = adjustForInsertionPoint(Arrays.binarySearch(peaks, lowerBlockIndex));
	    		if (peaksIndex == peaks.length || peaks[peaksIndex] < lowerBlockIndex || peaks[peaksIndex] > upperBlockIndex)
	    		{
	    			success = false;
	    			break;
	    		}
	    		
	    	}
	    	if (success) {
	    		break;
	    	}
	    	factorsIndex--;
    	}
    	return success ? factors[factorsIndex] : 0;
    }
    
    private int adjustForInsertionPoint(int idx)
    {
    	if (idx >= 0) {
    		return idx;
    	}
    	return -(idx + 1);
    }
    
    private Integer[] findPeaks(int[] a)
    {
    	List<Integer> peaks = new ArrayList<Integer>();
    	for (int i = 1 ; i < a.length - 1; i++)
    	{
    		if (a[i-1] < a[i] && a[i] > a[i+1]) {
    			peaks.add(i);
    		}
    	}
    	return peaks.toArray(new Integer[] {});
    }
}