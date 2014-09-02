package codility.generic;

import java.util.Arrays;


public class Array
{
	/**
	 * Initialize an array to a given value
	 * @param n length of array to initialize
	 * @param num value to initialize all array elements with
	 * @return a new array or null if n < 0
	 */
	public int[] init(int n, int num)
	{
		if (n < 0) {
			return null;
		}
		if (n == 0) {
			return new int[] {};
		}
		if (num == 0) {
			return new int[n];
		}
		
		int[] arr = new int[n];
		Arrays.fill(arr, num);
		return arr;
	}

	public static boolean isEmpty(int[] arr) {
		return arr.length == 0;
	}

	public static int[] calcDiffrerences(int[] a)
	{
		int d[] = new int[a.length -1];
		for (int i = 0; i < a.length - 1; i++)
		{
			d[i] = a[i+1] - a[i];
		}
		return d;
	}

	public static long sum(int[] arr)
	{
		long sum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		return sum;
	}

}
