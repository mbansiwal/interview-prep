package list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeNSortedLinkedList
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

	public ListNode mergeKLists(ListNode[] lists)
	{
		ListNode head = new ListNode(0);
		ListNode mList = head;

		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>()
		{
			@Override
			public int compare(ListNode o1, ListNode o2)
			{
				return o1.val - o2.val;
			}
		});

		if (lists == null || lists.length == 0)
		{
			return head.next;
		}
		for (ListNode listNode : lists)
		{
			queue.offer(listNode);
		}

		while (!queue.isEmpty())
		{
			ListNode node = queue.poll();
			mList.next = node;
			mList = mList.next;
			if (node.next != null)
			{
				queue.offer(node.next);
			}
		}

		return head.next;
	}

	public static void main(String[] args)
	{
		ListNode rootNode1 = createList(1, 4, 5);
		ListNode rootNode2 = createList(1, 3, 4);
		ListNode rootNode3 = createList(2, 6);

		ListNode mergedList = new MergeNSortedLinkedList().mergeKLists(new ListNode[]
		{
				rootNode1, rootNode2, rootNode3
		});

		while (mergedList != null)
		{
			System.out.print(mergedList.val + ",");
			mergedList = mergedList.next;
		}
	}

	private static ListNode createList(int... x)
	{
		/**
		 * 1->4->5, 1->3->4, 2->6
		 */
		ListNode head = new ListNode(x[0]);
		ListNode root = head;
		for (int i = 1; i < x.length; i++)
		{
			head.next = new ListNode(x[i]);
			head = head.next;
		}
		return root;
	}
}
