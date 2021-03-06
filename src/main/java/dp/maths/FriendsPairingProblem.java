package dp.maths;

/**
 * Given n friends, each one can remain single or can be paired up with some
 * other friend. Each friend can be paired only once. Find out the total number
 * of ways in which friends can remain single or can be paired up.
 * 
 * Examples:
 * 
 * Input : n = 3 Output : 4 Explanation {1}, {2}, {3} : all single {1}, {2,3} :
 * 2 and 3 paired but 1 is single. {1,2}, {3} : 1 and 2 are paired but 3 is
 * single. {1,3}, {2} : 1 and 3 are paired but 2 is single. Note that {1,2} and
 * {2,1} are considered same.
 *
 * https://www.geeksforgeeks.org/friends-pairing-problem/
 *
 * @author mbansiwal
 *
 */
public class FriendsPairingProblem
{
	public static void pairFriends(int noOfFriends)
	{
		int[] table = new int[noOfFriends + 1];

		table[1] = 1;
		table[2] = 2;
		for (int i = 3; i < table.length; i++)
		{
			table[i] = table[i - 1] + (i - 1) * table[i - 2];
		}

		System.out.println(table[noOfFriends]);
	}

	//solution using fibonacci
	public static void pairFriends2(int noOfFriends){
		int a = 1;
		int b = 2;
		int c = 0;
		for (int i = 3; i <= noOfFriends; ++i){
			c = b + a*(i-1);
			a = b;
			b = c;
		}

		System.out.println(c);
	}

	public static void main(String[] args)
	{
		pairFriends(3);
		pairFriends2(3);
		pairFriends(4);
		pairFriends2(4);
	}
}
