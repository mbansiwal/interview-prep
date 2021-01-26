package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-
 * borrowed-money/
 * 
 * Given a number of friends who have to give or take some amount of money from
 * one another. Design an algorithm by which the total cash flow among all the
 * friends is minimized.
 * 
 * Example: Following diagram shows input debts to be settled. cashFlow
 * 
 * Above debts can be settled in following optimized way cashFlow
 * 
 * Recommended: Please try your approach on {IDE} first, before moving on to the
 * solution.
 * 
 * The idea is to use Greedy algorithm where at every step, settle all amounts
 * of one person and recur for remaining n-1 persons. How to pick the first
 * person? To pick the first person, calculate the net amount for every person
 * where net amount is obtained by subtracting all debts (amounts to pay) from
 * all credits (amounts to be paid). Once net amount for every person is
 * evaluated, find two persons with maximum and minimum net amounts. These two
 * persons are the most creditors and debtors. The person with minimum of two is
 * our first person to be settled and removed from list. Let the minimum of two
 * amounts be x. We pay ‘x’ amount from the maximum debtor to maximum creditor
 * and settle one person. If x is equal to the maximum debit, then maximum
 * debtor is settled, else maximum creditor is settled.
 * 
 * The following is detailed algorithm.
 * 
 * Do following for every person Pi where i is from 0 to n-1. 1) Compute the net
 * amount for every person. The net amount for person ‘i’ can be computed be
 * subtracting sum of all debts from sum of all credits.
 * 
 * 2) Find the two persons that are maximum creditor and maximum debtor. Let the
 * maximum amount to be credited maximum creditor be maxCredit and maximum
 * amount to be debited from maximum debtor be maxDebit. Let the maximum debtor
 * be Pd and maximum creditor be Pc.
 * 
 * 3) Find the minimum of maxDebit and maxCredit. Let minimum of two be x. Debit
 * ‘x’ from Pd and credit this amount to Pc
 * 
 * 4) If x is equal to maxCredit, then remove Pc from set of persons and recur
 * for remaining (n-1) persons.
 * 
 * 5) If x is equal to maxDebit, then remove Pd from set of persons and recur
 * for remaining (n-1) persons.
 * 
 * @author mbansiwal
 *
 */
public class MinimizeCashFlow
{
	int getMin(int arr[])
	{
	    int minInd = 0;
	    for (int i=1; i < arr.length; i++)
		{
			if (arr[i] < arr[minInd])
			{
				minInd = i;
			}
		}
	    return minInd;
	}
	 
	// A utility function that returns index of maximum value in arr[]
	int getMax(int arr[])
	{
	    int maxInd = 0;
	    for (int i=1; i < arr.length; i++)
		{
			if (arr[i] > arr[maxInd])
			{
				maxInd = i;
			}
		}
	    return maxInd;
	}
	 

	 
	public static void main(String[] args)
	{
		int graph[][] =
		{
				{0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}
		};
		new MinimizeCashFlow().minimizeCashFlow(graph);
		
		int[][] transactions= {{0,1,10}, {2,0,5}};
		new MinimizeCashFlow().minimizeCashFlow(transactions);
	}

	public void minimizeCashFlow(int[][] graph){
		int N = graph.length;
		int[] amounts = new int[N];

		for (int p1=0; p1 < N; ++p1){
			for (int p2=0; p2 < N; ++p2){
				amounts[p1] += graph[p2][p1] - graph[p1][p2];
			}
		}
		transferMoney(amounts);
	}

	public void transferMoney(int[] amounts){
		int maxCreditsIndex = getMax(amounts);
		int maxDebitsIndex = getMin(amounts);

		if(amounts[maxCreditsIndex] == 0 && amounts[maxDebitsIndex] ==0){
			return;
		}

		int amountToTransfer = Math.min(-amounts[maxDebitsIndex], amounts[maxCreditsIndex]);

		amounts[maxCreditsIndex] -= amountToTransfer;
		amounts[maxDebitsIndex] += amountToTransfer;

		System.out.println("person " + maxDebitsIndex +" gives person " +maxCreditsIndex +" amount "+
				amountToTransfer);

		transferMoney(amounts);
	}
}
