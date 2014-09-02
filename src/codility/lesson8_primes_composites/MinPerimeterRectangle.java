package codility.lesson8_primes_composites;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * An integer N is given, representing the area of some rectangle.
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
 * For example, given integer N = 30, rectangles of area 30 are:
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function: int solution(int N);
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 * For example, given an integer N = 30, the function should return 22, as explained above.
 * Assume that:
 * N is an integer within the range [1..1,000,000,000].
 * Complexity:
 * expected worst-case time complexity is O(sqrt(N));
 * expected worst-case space complexity is O(1).
 */
public class MinPerimeterRectangle
{
	
	@Test
	public void test() 
	{
		MinPerimeterRectangle p = new MinPerimeterRectangle();
		assertEquals(0, p.solution(0));
		assertEquals(4, p.solution(1));
		assertEquals(6, p.solution(2));
		assertEquals(8, p.solution(3));
		assertEquals(8, p.solution(4));
		assertEquals(12, p.solution(5));
		assertEquals(10, p.solution(6));
		assertEquals(16, p.solution(7));
		assertEquals(12, p.solution(8));
		assertEquals(12, p.solution(9));
		assertEquals(36, p.solution(17));
		assertEquals(20, p.solution(24));
		assertEquals(20, p.solution(25));
		assertEquals(28, p.solution(49));
		assertEquals(40, p.solution(100));
		assertEquals(204, p.solution(101));
	}
	
    public int solution(int area) 
    {
    	if (area == 0) {
    		return 0;
    	}
    	int minPerim = Integer.MAX_VALUE;
    	int stopLoop = area < Integer.MAX_VALUE ? 1 : 0;
    	for (int i = 1; i < area / i + stopLoop; i++)
    	{
    		if (area % i == 0) 
    		{
    			int currPerim = 2 * i + 2 * (area / i);
				if (currPerim < minPerim) {
					minPerim = currPerim;
				}
    		}
    	}
     	return minPerim;
    }
}
