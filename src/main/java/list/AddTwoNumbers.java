package list;

public class AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode head = new ListNode(0);
		ListNode top = head;
		int carry = 0;
		while (l1 != null || l2 != null)
		{
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			sum = sum % 10;
			head.next = new ListNode(sum);
			head = head.next;
			if (l1 != null)
			{
				l1 = l1.next;
			}

			if (l2 != null)
			{
				l2 = l2.next;
			}
		}
		if (carry > 0)
		{
			head.next = new ListNode(carry);
			head = head.next;
		}
		return top.next;
	}

	public static void main(String[] args)
	{

	}
}
