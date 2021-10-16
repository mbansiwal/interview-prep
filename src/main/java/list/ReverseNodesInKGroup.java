package list;

public class ReverseNodesInKGroup
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode current = head;
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
		ListNode reverse = null;
		while (current != null && count < k)
		{
			ListNode next = current.next;
			current.next = reverse;
			reverse = current;
			current = next;
			++count;
		}

		if (current != null)
		{
			head.next = reverseKGroup(current, k);
		}

		return reverse;
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
