package codility.lesson4_sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import codility.generic.Guards;

public class FindTriangle
{
	private static final int MAX_LEN = 1000 * 1000;

	@Test
	public void test() 
	{
		FindTriangle p = new FindTriangle();
		assertEquals(0, p.solution(new int[] {}));
		assertEquals(0, p.solution(new int[] {1}));
		assertEquals(0, p.solution(new int[] {17,3}));
		assertEquals(1, p.solution(new int[] {2,3,4}));
		assertEquals(0, p.solution(new int[] {2,8,5}));
		assertEquals(1, p.solution(new int[] {10,2,5,1,8,20}));
		assertEquals(0, p.solution(new int[] {-10,-2,-5,-1,-8,-20}));
		assertEquals(1, p.solution(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE / 2 + 1, 3*(Integer.MAX_VALUE / 4)}));
		assertEquals(0, p.solution(new int[] {-1,-3,-4,-2}));
		
		int m = 100000;
		int[] H = new int[m];
		for (int i = 0; i < m; i++)
		{
			H[i] = i + 1;
		}
		assertEquals(1, p.solution(H));
	}
	
	public int solution(int[] A)
	{
		try
		{
			if (A.length < 3) {
				return 0;
			}
			Guards.guardLessThanEquals(A.length, MAX_LEN);
			Arrays.sort(A);
			return searchTriangles(A);
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	private int searchTriangles(int[] a)
	{
		for (int i = 0; i < a.length - 2; i++)
		{
			if (isTriangle(a, i)) {
				return 1;
			}
		}
		return 0;
	}

	private boolean isTriangle(int[] a, int i) {
		return a[i] > 0 && a[i] >= a[i+2] - a[i];
	}

}
