package list;

public class SortList
{
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode tortoise = head;
		ListNode hare = head;

		ListNode previous = null;
		while (hare != null && hare.next != null)
		{
			previous = tortoise;
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		previous.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(tortoise);
		return merge(l1, l2);
	}

	private ListNode merge(ListNode list1, ListNode list2)
	{
		if (list1 == null)
		{
			return list2;
		}
		if (list2 == null)
		{
			return list1;
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (list1 != null && list2 != null)
		{
			if (list1.val < list2.val)
			{
				head.next = list1;
				list1 = list1.next;
			} else
			{
				head.next = list2;
				list2 = list2.next;
			}
			head = head.next;
		}

		if (list1 != null)
		{
			head.next = list1;
		}
		if (list2 != null)
		{
			head.next = list2;
		}
		return dummy.next;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(5);
		node.next = new ListNode(1);
		node.next.next = new ListNode(10);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next = new ListNode(6);

		ListNode head = new SortList().sortList(node);
		while (head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
}
