package codility.generic;

public class Maths
{

	public static long sumOfArithmeticSequence(int a0, int n, int d)
	{
		long first = 2 * a0 + (n - 1) * d;
		double f = n % 2 == 0 ? n / 2 : (n-1) / 2 + 0.5;
		return (long) (f * first);
	}

	public static int maxAbs(int[] arr)
	{
		int max = 0;
		int abs;
	   	for (int i = 0; i < arr.length; i++) 
		{
	   		abs = Math.abs(arr[i]);
			if (abs > max) {
				max = abs;
			}
		}
	   	return max;
	}
}
