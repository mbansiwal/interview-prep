package list;

public class NthNodeFromList
{
	static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		if (head == null)
		{
			return null;
		}
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode forwardNode = dummyNode;
		ListNode backwardNode = dummyNode;

		for (int i = 1; i <= n + 1 && forwardNode != null; i++)
		{
			forwardNode = forwardNode.next;
		}

		while (forwardNode != null)
		{
			forwardNode = forwardNode.next;
			backwardNode = backwardNode.next;
		}
		backwardNode.next = backwardNode.next.next;

		return dummyNode.next;
	}

	public static void main(String[] args)
	{
		ListNode rootNode = new ListNode(1);
		ListNode listNode = rootNode;
		listNode.next = new ListNode(2);
		listNode = listNode.next;
		listNode.next = new ListNode(3);
		listNode = listNode.next;
		listNode.next = new ListNode(4);
		listNode = listNode.next;
		listNode.next = new ListNode(5);
		ListNode newHead = new NthNodeFromList().removeNthFromEnd(rootNode, 2);
		while (newHead != null)
		{
			System.out.print(newHead.val + ",");
			newHead = newHead.next;
		}
		System.out.println();
		ListNode rootNode2 = new ListNode(1);
		ListNode newHead2 = new NthNodeFromList().removeNthFromEnd(rootNode2, 1);
		while (newHead2 != null)
		{
			System.out.print(newHead2.val + ",");
			newHead2 = newHead2.next;
		}
		System.out.println();
		ListNode rootNode3 = new ListNode(1);
		rootNode3.next = new ListNode(2);
		ListNode newHead3 = new NthNodeFromList().removeNthFromEnd(rootNode3, 1);
		while (newHead3 != null)
		{
			System.out.print(newHead3.val + ",");
			newHead3 = newHead3.next;
		}
		System.out.println();
	}
}
