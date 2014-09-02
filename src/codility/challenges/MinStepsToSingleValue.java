package codility.challenges;

import static org.junit.Assert.*;

import org.junit.*;

import codility.generic.Array;
import codility.generic.Maths;


public class MinStepsToSingleValue
{
	@Test
	public void test() {
		assertEquals(0, new MinStepsToSingleValue().solution(new int[] {}));
    	assertEquals(0, new MinStepsToSingleValue().solution(new int[] {1}));
    	assertEquals(0, new MinStepsToSingleValue().solution(new int[] {1,1}));
    	assertEquals(4, new MinStepsToSingleValue().solution(new int[] {1,5}));
    	assertEquals(1, new MinStepsToSingleValue().solution(new int[] {1,2}));
    	assertEquals(4, new MinStepsToSingleValue().solution(new int[] {5,1}));
		assertEquals(0, new MinStepsToSingleValue().solution(new int[] {1,1,1}));
		assertEquals(1, new MinStepsToSingleValue().solution(new int[] {1,2,1}));
		assertEquals(1, new MinStepsToSingleValue().solution(new int[] {1,2,1}));
		assertEquals(1, new MinStepsToSingleValue().solution(new int[] {1,1,2}));
		assertEquals(4, new MinStepsToSingleValue().solution(new int[] {1,1,5}));
		assertEquals(4, new MinStepsToSingleValue().solution(new int[] {5,5,1}));
		assertEquals(4, new MinStepsToSingleValue().solution(new int[] {1,5,2}));
		assertEquals(5, new MinStepsToSingleValue().solution(new int[] {1,6,2}));
	}

	public int solution(int[] a) 
    {
    	int steps = 0;
    	
    	if (a.length < 2) {
    		return 0;
    	}
    	
    	int[] d = Array.calcDiffrerences(a);
    	int maxDifference = Maths.maxAbs(d);
    	for (int i = 0; i < d.length; i++) 
    	{
    		steps = maxDifference;
    	}
    	
    	return steps;
    }
}
