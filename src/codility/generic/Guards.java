package codility.generic;

public class Guards
{
	public static void guardLessThanEquals(int a, int upper)
	{
		if (a > upper) {
			throw new IllegalArgumentException(String.format("%d cannot be greater than %d", a, upper));
		}
	}

	public static void guardLessThan(int a, int upper)
	{
		if (a >= upper) {
			throw new IllegalArgumentException(String.format("%d cannot be greater than or equal to %d", a, upper));
		}
	}

	public static void guardOpenRange(int lower, int a, int upper)
	{
		if (a < lower || a > upper) {
			throw new IllegalArgumentException(String.format("%d cannot be outside the open range (%d..%d)", a, lower, upper));
		}
	}
}
