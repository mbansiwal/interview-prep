package bits;

public class SwapAllOddAndEvenBits
{
	static int swapBits(int x)
	{
		int evenBits = x & 0xAAAAAAAA;
		int oddBits = x & 0x55555555;
		
		System.out.println(0xAAAAAAAA);
		System.out.println(0x55555555);
		evenBits >>= 1;
		oddBits <<= 1;
		return evenBits | oddBits;
	}

	public static void main(String[] args)
	{
		System.out.println(swapBits(23));
	}

}
