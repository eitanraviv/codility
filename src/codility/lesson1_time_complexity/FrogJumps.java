package codility.lesson1_time_complexity;

import static org.junit.Assert.*;

import org.junit.Test;

import codility.generic.Guards;

public class FrogJumps
{
	private static final int MAX_LEN = 1000000000;

	@Test
	public void test()
	{
		FrogJumps f = new FrogJumps();
		assertEquals(0, f.solution(1,1,1));
		assertEquals(1, f.solution(1,2,3));
		assertEquals(3, f.solution(10,85,30));
		assertEquals(9, f.solution(1, 10, 1));
		assertEquals(9, f.solution(2, 20, 2));
		assertEquals(MAX_LEN - 1, f.solution(1, MAX_LEN, 1));
	}
	
	public int solution(int X, int Y, int D) 
	{
		Guards.guardOpenRange(1, X, MAX_LEN);
		Guards.guardOpenRange(1, Y, MAX_LEN);
		Guards.guardOpenRange(1, D, MAX_LEN);
		Guards.guardLessThanEquals(X, Y);
		return calcJumps(X, Y, D);
	}

	private int calcJumps(int X, int Y, int D) {
		return (Y - X) % D == 0 ? (Y - X) / D : (Y - X) / D + 1;
	}
}
