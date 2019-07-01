package arr;

public class FirstBadVersion
{
	public int firstBadVersion(int n)
	{
		int low = 0;
		int high = n - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid))
			{
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return low;
	}

	private boolean isBadVersion(int n)
	{
		if (n > 3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new FirstBadVersion().firstBadVersion(5));
	}
}
