package codility.generic;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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
public class GetFactorsDescending
{
	@Test
	public void more() {
		GetFactorsDescending gf = new GetFactorsDescending();
		assertArrayEquals((new int[] {0}), gf.solution(0));
		assertArrayEquals(new int[] {1}, gf.solution(1));
		assertArrayEquals(new int[] {2,1}, gf.solution(2));
		assertArrayEquals(new int[] {3,1}, gf.solution(3));
		assertArrayEquals(new int[] {4,2,1}, gf.solution(4));
		assertArrayEquals(new int[] {5,1}, gf.solution(5));
		assertArrayEquals(new int[] {6,3,2,1}, gf.solution(6));
		assertArrayEquals(new int[] {9,3,1}, gf.solution(9));
		assertArrayEquals(new int[] {16,8,4,2,1}, gf.solution(16));
		assertArrayEquals(new int[] {17,1}, gf.solution(17));
		assertArrayEquals(new int[] {24,12,8,6,4,3,2,1}, gf.solution(1*2*3*4));
		assertArrayEquals(new int[] {Integer.MAX_VALUE,1}, gf.solution(Integer.MAX_VALUE));
	}
	
    public int[] solution(int n) 
    {
    	if (n == 0) {
    		return new int[] {0};
    	}
    	CountFactors cf = new CountFactors();
    	int count = cf.solution(n);
    	int[] factors = new int[count];
    	int idx = 0;
    	int stopLoop = n < Integer.MAX_VALUE ? 1 : 0;
    	for (int divisor = 1; divisor < n / divisor + stopLoop; divisor++)
    	{
    		if (n % divisor == 0) 
    		{
    			factors[idx] = n / divisor;
    			if (n / divisor != divisor) {
    				factors[count - 1 - idx] = divisor;
    			}
    			idx++;
    		}
    	}
    	return factors;
    }
}
