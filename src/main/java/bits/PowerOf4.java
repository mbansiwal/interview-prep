package bits;

public class PowerOf4
{
	public boolean powerOf4(int number)
	{
		int n = number & (number - 1);
		int evenBits = (number & 0XAAAAAAAA);
		return number != 0 && n == 0 && (evenBits == 0);
	}

	public static void main(String[] args)
	{
		System.out.println(new PowerOf4().powerOf4(2));
		System.out.println(new PowerOf4().powerOf4(4));
		System.out.println(new PowerOf4().powerOf4(16));
		System.out.println(new PowerOf4().powerOf4(8));
	}
}
