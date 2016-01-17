package org.github.coding.lesson3_time_complexity;

import static org.junit.Assert.*;

import org.junit.Test;

import org.github.coding.generic.Array;

public class FindMinDiff
{

	@Test
	public void test() {
		FindMinDiff p = new FindMinDiff();
		assertEquals(11, p.solution(new int[] {-10, 5,-2,8}));
		assertEquals(1, p.solution(new int[] {-3,1,2,4,-3}));
		assertEquals(2000, p.solution(new int[] {1000,-1000}));
	}

	public int solution(int[] A)
	{
		int diff;
		int sum = (int) Array.sum(A);
		
		int min = Integer.MAX_VALUE;
		int cumm = 0;
		for (int i = 1; i < A.length; i++)
		{
			cumm += 2 * A[i-1];
			diff = Math.abs(cumm - sum);
			min = Math.min(diff, min);
		}
		return min;
	}
}
