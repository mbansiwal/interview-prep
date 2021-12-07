package list;

public class RotateList
{
	public ListNode rotateRightOptimum(ListNode head, int k)
	{
		if (head == null)
		{
			return null;
		}
		if (k == 0)
		{
			return head;
		}
		ListNode tortoise = head;
		ListNode hare = head;
		int count = 1;
		while (count <= k && hare.next != null)
		{
			hare = hare.next;
			count++;
		}

		if (hare.next == null)
		{
			for (int i = 1; i < (count - k % count); i++)
			{
				tortoise = tortoise.next;
			}
		}

		while (hare.next != null)
		{
			hare = hare.next;
			tortoise = tortoise.next;
		}

		hare.next = head;
		ListNode lastPointer = tortoise.next;
		tortoise.next = null;

		return lastPointer;
	}

	public ListNode rotateRight(ListNode head, int k)
	{
		if (head == null)
		{
			return null;
		}

		if (k == 0)
		{
			return head;
		}

		ListNode tortoise = head;
		ListNode hare = head;
		int count = 1;
		while (hare.next != null)
		{
			hare = hare.next;
			count++;
		}

		for (int i = 1; i < (count - k % count); i++)
		{
			tortoise = tortoise.next;
		}

		hare.next = head;
		ListNode newHead = tortoise.next;
		tortoise.next = null;

		return newHead;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ListNode head = new RotateList().rotateRightOptimum(node, 2);
		while (head != null)
		{
			System.out.print(head.val + ",");
			head = head.next;
		}

		ListNode node1 = new ListNode(0);
		node1.next = new ListNode(1);
		node1.next.next = new ListNode(2);

		System.out.println();
		head = new RotateList().rotateRightOptimum(node1, 4);
		while (head != null)
		{
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
}
