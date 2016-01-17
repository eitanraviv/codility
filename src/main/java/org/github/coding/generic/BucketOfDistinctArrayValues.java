package org.github.coding.generic;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This object will set element i of an array to 1 if in the given array the value i appears.
 * All other elements of the returned array will be zero.
 * 
 * It is assumed that in a given array on length N, all values are within the range [0..N-1].
 *
 */
public class BucketOfDistinctArrayValues
{
	@Test
	public void test() {
		BucketOfDistinctArrayValues b = new BucketOfDistinctArrayValues();
		
		assertArrayEquals(new int[]{}, b.solution(new int[] {}));
		try
		{
			b.solution(new int[] {-1});
			b.solution(new int[] {3});
			b.solution(new int[] {1,2});
			b.solution(new int[] {2,1});
		}
		catch (Exception e)
		{
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertArrayEquals(new int[]{1}, b.solution(new int[] {0}));
		assertArrayEquals(new int[]{1,1}, b.solution(new int[] {0,1}));
		assertArrayEquals(new int[]{0,2}, b.solution(new int[] {1,1}));
		
		assertArrayEquals(new int[]{1,1,1}, b.solution(new int[] {0,1,2}));
		assertArrayEquals(new int[]{0,2,1}, b.solution(new int[] {1,2,1}));
		assertArrayEquals(new int[]{0,1,2}, b.solution(new int[] {1,2,2}));
		assertArrayEquals(new int[]{0,0,3}, b.solution(new int[] {2,2,2}));
	}

    public int[] solution(int[] a) 
    {
    	if (a.length == 0) {
    		return a;
    	}
    	int[] bucket = new int[a.length];
    	for (int i = 0; i < a.length; i++)
    	{
    		Guards.guardOpenRange(0, a[i], a.length - 1);
    		bucket[a[i]]++;
    	}
    	return bucket;
    }
}
