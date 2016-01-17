package org.github.coding.lesson1_iterations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

 For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

 Write a function:

 class Solution { public int solution(int N); }

 that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

 For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

 Assume that:

 N is an integer within the range [1..2,147,483,647].
 Complexity:

 expected worst-case time complexity is O(log(N));
 expected worst-case space complexity is O(1).

 * @author eitanraviv
 * @since 12 Jan 2016
 */
public class BinaryGap
{
	@Test
	public void test()
	{
		BinaryGap p = new BinaryGap();

		assertEquals(0, p.solution(0));
		assertEquals(0, p.solution(1));
		assertEquals(0, p.solution(2));
		assertEquals(0, p.solution(4));
		assertEquals(1, p.solution(5));
		assertEquals(0, p.solution(6));
		assertEquals(2, p.solution(9));
		assertEquals(4, p.solution(529));
		assertEquals(5, p.solution(1041));
	}

	public int solution(int N)
	{
		if (N < 0 || N > Integer.MAX_VALUE)
		{
			return 0;
		}
		boolean inGap = false;
		int n = N;
		int maxGap = 0;
		int currGap = 0;


		while (n > 0)
		{
			if (!inGap && startGap(N, n))
			{
				inGap = true;
				currGap = 0;
			}
			else if (inGap && endGap(N, n))
			{
				inGap = false;
				currGap++;
				if (currGap > maxGap)
				{
					maxGap = currGap;
				}
			}
			else if (isGap(N, n))
			{
				currGap++;
			}
			n = n / 2;
		}
		return maxGap;
	}

	private boolean endGap(int N, int n)
	{
		System.out.println(String.format("endGap: N=%d n=%d [n / 2 %% 2]=%d", N, n, n / 2 % 2));
		if (n < N && n % 2 == 0 && n / 2 % 2 == 1)
			return true;
		return false;
	}

	private boolean startGap(int N, int n)
	{
		System.out.println(String.format("startGap: N=%d n=%d [n / 2 %% 2]=%d", N, n, n / 2 % 2));
		if (n > 1 && n % 2 == 1 && n / 2 % 2 == 0)
			return true;
		return false;
	}

	private boolean isGap(int N, int n)
	{
		System.out.println(String.format("isGap: N=%d n=%d [n / 2 %% 2]=%d", N, n, n / 2 % 2));
		if (n < N && n % 2 == 0)
			return true;
		return false;
	}
}