package list;

public class SwapNodesInPairs
{
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}
		ListNode current = head.next;
		ListNode previous = head;
		head = current;
		while (true)
		{
			ListNode next = current.next;
			current.next = previous;

			if (next == null || next.next == null)
			{
				previous.next = next;
				break;
			}

			previous.next = next.next;
			previous = next;
			current = next.next;
		}

		return head;
	}


	public static void main(String[] args)
	{
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);

		ListNode head = new SwapNodesInPairs().swapPairs(node);
		while (head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
}
