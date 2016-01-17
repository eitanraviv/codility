package org.github.coding.lesson3_time_complexity;

import static org.junit.Assert.*;

import org.junit.Test;

import org.github.coding.generic.Array;
import org.github.coding.generic.Maths;


public class MissingElement
{
	@Test
	public void test()
	{
		MissingElement e = new MissingElement();
		assertEquals(3, e.solution(new int[] {1,2,4,5}));
		assertEquals(1, e.solution(new int[] {}));
		assertEquals(1, e.solution(new int[] {2}));
		
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++)
		{
			arr[i] = i + 1;
		}
		arr[5000] = 100001;
		assertEquals(5001, e.solution(arr));
		
	}
	
	public int solution(int[] A)
	{
		if (A.length == 0)
		{
			return 1;
		}
		long sum = Array.sum(A);
		long desiredSum = Maths.sumOfArithmeticSequence(1, A.length + 1, 1);
		int missing = (int) (desiredSum - sum);
		return missing;
	}
}
