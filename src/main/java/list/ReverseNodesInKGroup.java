package list;

public class ReverseNodesInKGroup
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		int count = 0;
		while (current != null && count < k)
		{
			current = current.next;
			count++;
		}
		if (count != k)
		{
			return head;
		}
		current = head;
		count = 0;
		while (current != null && count < k)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			++count;
		}

		if (next != null)
		{
			head.next = reverseKGroup(next, k);
		}

		return previous;
	}

	public ListNode reverseAList(ListNode head)
	{
		ListNode dummyList = new ListNode(0);
		while(head != null){
			ListNode next = head.next;
			ListNode previous = dummyList.next;
			dummyList.next = head;
			head.next = previous;
			head = next;
		}
		return dummyList.next;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);

		ListNode head = new ReverseNodesInKGroup().reverseKGroup(node, 4);
		while (head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
}
