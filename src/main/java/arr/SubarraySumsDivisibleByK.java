package arr;

public class SubarraySumsDivisibleByK
{
	public int subarraysDivByK(int[] A, int K)
	{
		int N = A.length;
		int[] P = new int[N + 1];
		for (int i = 0; i < N; ++i)
		{
			P[i + 1] = P[i] + A[i];
		}

		int[] count = new int[K];
		for (int x : P)
		{
			count[(x % K + K) % K]++;
		}

		int ans = 0;
		for (int v : count)
		{
			ans += v * (v - 1) / 2;
		}
		return ans;
	}

	public int subarraysDivByK2(int[] A, int K)
	{
		int[] map = new int[K];
		map[0] = 1;
		int count = 0, sum = 0;
		for (int a : A)
		{
			sum = (sum + a) % K;
			if (sum < 0)
			{
				sum += K; // Because -1 % 5 = -1, but we need the positive mod 4
			}
			count += map[sum];
			map[sum]++;
		}
		return count;
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				4, 5, 0, -2, -3, 1
		};
		System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(arr, 5));
	}
}
