package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/optimal-account-balancing/
 * 
 * A group of friends went on holiday and sometimes lent each other money. 
 * For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. 
 * We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. 
 * Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), 
 * the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.

 * @author Administrator
 *
 */
class Result{
	int count = Integer.MAX_VALUE;
}
public class OptimalAccountBalancing {
	public int minTransfers(int[][] transactions) {
		Map<Integer, Integer> balances =new HashMap<>();
		for (int[] is : transactions) {
			int a = is[0];
			int b = is[1];
			int amount = is[2];
			balances.put(a, balances.getOrDefault(a, 0) - amount);
			balances.put(b, balances.getOrDefault(b, 0) + amount);
		}
		
		List<Integer> positives = new ArrayList<>();
		List<Integer> negatives = new ArrayList<>();
		for (Integer key : balances.keySet()) {
			if(balances.get(key)==0)continue;
			if(balances.get(key) > 0) {
				positives.add(balances.get(key));
			} else {
				negatives.add(-balances.get(key));
			}
		}
		Result result = new Result();
		dfs(result, positives, negatives, 0, 0);
		return result.count;
	}
	
	private void dfs(Result result, List<Integer> positives, List<Integer> negatives, int start, int count) {
		if(start == positives.size()) {
			result.count = Math.min(result.count, count);
			return;
		}
		
		int balance = positives.get(start);
		for (int i = 0; i < negatives.size(); i++) {
			if(negatives.get(i) == 0) {
				continue;
			}
			int toPay = negatives.get(i);
			if(balance > toPay) {
				negatives.set(i, 0);
				positives.set(start, balance - toPay);
				dfs(result, positives, negatives, start, count+1);
				positives.set(start, balance);
				negatives.set(i, toPay);
			} else {
				negatives.set(i, toPay - balance);
				positives.set(start,  0);
				dfs(result, positives, negatives, start+1, count+1);
				positives.set(start, balance);
				negatives.set(i, toPay);
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] positions = {{0,1,10},{2,0,5}};
		System.out.println(new OptimalAccountBalancing().minTransfers(positions));
	}
}
