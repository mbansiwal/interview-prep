package dp.lis;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}

public class OddEvenLinkedList
{
	public ListNode oddEvenList2(ListNode head)
	{
		if (head == null)
		{
			return null;
		}
		ListNode odd = head;
		ListNode evenHead = head.next;
		ListNode even = evenHead;
		while (even != null && even.next != null)
		{
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		ListNode start = head;
		head.next = new ListNode(2);
		head = head.next;

		head.next = new ListNode(3);
		head = head.next;

		head.next = new ListNode(4);
		head = head.next;

		head.next = new ListNode(5);
		head = head.next;

		ListNode updatedList = new OddEvenLinkedList().oddEvenList2(start);
		while (updatedList != null)
		{
			System.out.println(updatedList.val);
			updatedList = updatedList.next;
		}
	}
}
