package org.github.coding.challenges;

import org.junit.Test;

import static org.junit.Assert.*;


public class FindExtrema
{
	@Test
	public void underThreeElementsNoExtreme() {
		assertEquals(0, new FindExtrema().solution(new int[] {}));
		assertEquals(0, new FindExtrema().solution(new int[] {1}));
		assertEquals(0, new FindExtrema().solution(new int[] {1,1}));
		assertEquals(0, new FindExtrema().solution(new int[] {1,2}));
		assertEquals(0, new FindExtrema().solution(new int[] {2,1}));
	}
	
	@Test
	public void threeElements() {
		assertEquals(1, new FindExtrema().solution(new int[] {1,2,1}));
		assertEquals(1, new FindExtrema().solution(new int[] {2,1,2}));
		assertEquals(0, new FindExtrema().solution(new int[] {2,2,2}));
		assertEquals(0, new FindExtrema().solution(new int[] {1,2,3}));
		assertEquals(0, new FindExtrema().solution(new int[] {3,2,1}));
	}
		
	@Test
	public void fourElements() 
	{
		assertEquals(0, new FindExtrema().solution(new int[] {1,1,1,1}));
//		assertEquals(1, new FindExtrema().solution(new int[] {2,1,1,1}));
		assertEquals(1, new FindExtrema().solution(new int[] {1,2,1,1}));
		assertEquals(1, new FindExtrema().solution(new int[] {1,1,2,1}));
//		assertEquals(1, new FindExtrema().solution(new int[] {1,1,1,2}));
		assertEquals(2, new FindExtrema().solution(new int[] {1,2,1,2}));
		assertEquals(1, new FindExtrema().solution(new int[] {1,2,2,1}));
		assertEquals(2, new FindExtrema().solution(new int[] {2,1,2,1}));
//		assertEquals(1, new FindExtrema().solution(new int[] {2,2,2,1}));
//		assertEquals(1, new FindExtrema().solution(new int[] {1,2,2,2}));
		assertEquals(0, new FindExtrema().solution(new int[] {2,2,2,2}));
		
		assertEquals(1, new FindExtrema().solution(new int[] {1,2,3,1}));
		assertEquals(1, new FindExtrema().solution(new int[] {1,2,3,2}));
//		assertEquals(1, new FindExtrema().solution(new int[] {1,2,3,3}));
	}
	
	public void fiveElements() 
	{
		assertEquals(3, new FindExtrema().solution(new int[] {1,2,2,1,2,1}));
		assertEquals(0, new FindExtrema().solution(new int[] {1,2,2,1}));
	}
	
	int lastDistinct;
	
    public int solution(int[] a) 
    {
        int countExtrema = 0;
        
        if (a.length < 3) {
        	return 0;
        }
        lastDistinct = a[0];
        
        for (int i = 1; i < a.length - 1; i++)
        {
        	if (isMax(a, i)) {
        		countExtrema++;
        	}
        	else if (isMin(a, i)) {
        		countExtrema++;
        	}
        	if (a[i] != a[i+1]) {
        		lastDistinct = a[i];
        	}
        }
        return countExtrema;
    }

	private boolean isMax(int[] a, int i) {
		return a[i] > lastDistinct && a[i] > a[i+1];
	}
    
	private boolean isMin(int[] a, int i) {
		return a[i] < lastDistinct && a[i] < a[i+1];
	}
}
