package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/accounts-merge Given a list accounts, each
 * element accounts[i] is a list of strings, where the first element
 * accounts[i][0] is a name, and the rest of the elements are emails
 * representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some email that is common to both accounts. Note
 * that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Example 1: Input: accounts = [["John", "johnsmith@mail.com",
 * "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John",
 * "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'], ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]] Explanation: The first and third John's are the same person
 * as they have the common email "johnsmith@mail.com". The second John and Mary
 * are different people as none of their email addresses are used by other
 * accounts. We could return these lists in any order, for example the answer
 * [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John',
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would
 * still be accepted.
 * 
 * @author Administrator
 *
 */
class Account {
	String name;
	Integer id;
	public Account(Integer id, String name) {
		super();
		this.name = name;
	}
	Set<String> emails = new TreeSet<>();
	
	
}
public class AccountsMerge {
	public List<List<String>> accountsMerge2(List<List<String>> accounts) {
		int count = 0;
		Map<String, Account> accountMap = new HashMap<>();
		for (List<String> list : accounts) {
			count++;
			Iterator<String> itr = list.iterator();
			String name = itr.next();
			Account account = new Account(count, name);
			while(itr.hasNext()) {
				String email = itr.next();
				if(accountMap.containsKey(email)) {
					account = accountMap.get(email);
					break;
				}
			}
			itr = list.iterator();
			itr.next();
			while(itr.hasNext()) {
				String email = itr.next();
				accountMap.put(email, account);
				account.emails.add(email);
			}
		}
		List<List<String>> ans = new ArrayList<>();
		new HashSet<>(accountMap.values()).forEach(account -> {
			List<String> result = new ArrayList<>();
			result.add(account.name);
			result.addAll(account.emails);
			ans.add(result);
		});
		return ans;
	}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap();
		Map<String, ArrayList<String>> graph = new HashMap();
		for (List<String> account : accounts) {
			String name = "";
			for (String email : account) {
				if (name == "") {
					name = email;
					continue;
				}
				graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
				graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
				emailToName.put(email, name);
			}
		}

		Set<String> seen = new HashSet();
		List<List<String>> ans = new ArrayList();
		for (String email : graph.keySet()) {
			if (!seen.contains(email)) {
				seen.add(email);
				Stack<String> stack = new Stack();
				stack.push(email);
				List<String> component = new ArrayList();
				while (!stack.empty()) {
					String node = stack.pop();
					component.add(node);
					for (String nei : graph.get(node)) {
						if (!seen.contains(nei)) {
							seen.add(nei);
							stack.push(nei);
						}
					}
				}
				Collections.sort(component);
				component.add(0, emailToName.get(email));
				ans.add(component);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
		accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
		accounts.add(Arrays.asList("Mary", "mary@mail.com"));
		System.out.println(new AccountsMerge().accountsMerge(accounts));
//		System.out.println(new AccountsMerge().accountsMerge2(accounts));
		
		List<List<String>> accounts2 = new ArrayList<>();
		accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
		accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
		accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
		accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
		accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
		System.out.println(new AccountsMerge().accountsMerge2(accounts2));
	}
}
