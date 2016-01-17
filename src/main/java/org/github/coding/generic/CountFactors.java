package org.github.coding.generic;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
Write a function:
int solution(int N);
that, given a positive integer N, returns the number of its factors.
For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
Assume that:
N is an integer within the range [1..2,147,483,647].
Complexity:
expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).
 */
public class CountFactors
{
	int numFactors = 0;

	@Test
	public void test() {
		CountFactors p = new CountFactors();
		assertEquals(0, p.solution(0));
		assertEquals(1, p.solution(1));
		assertEquals(2, p.solution(2));
		assertEquals(2, p.solution(3));
		assertEquals(3, p.solution(4));
		assertEquals(2, p.solution(5));
		assertEquals(4, p.solution(6));
		assertEquals(2, p.solution(7));
		assertEquals(4, p.solution(8));
		assertEquals(3, p.solution(9));
		assertEquals(5, p.solution(16));
		assertEquals(2, p.solution(17));
		assertEquals(8, p.solution(24));
		assertEquals(3, p.solution(25));
		assertEquals(3, p.solution(49));
		assertEquals(9, p.solution(100));
		assertEquals(2, p.solution(101));
		assertEquals(2, p.solution(Integer.MAX_VALUE));
	}
	
    public int solution(int n) 
    {
    	if (n == 0) {
    		return 0;
    	}
    	int numFactors = 0;
    	int stopLoop = n < Integer.MAX_VALUE ? 1 : 0;
    	for (int divisor = 1; divisor < n / divisor + stopLoop; divisor++)
    	{
    		if (n % divisor == 0) 
    		{
    			numFactors += 1;
    			if (n / divisor != divisor) {
    				numFactors += 1;
    			}
    		}
    	}
    	return numFactors;
    }
}
