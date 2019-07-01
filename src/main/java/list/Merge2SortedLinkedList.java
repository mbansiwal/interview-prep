package list;

public class Merge2SortedLinkedList
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

	public ListNode merge2Lists(ListNode list1, ListNode list2)
	{
		ListNode head = new ListNode(0);
		ListNode mList = head;

		while (list1 != null && list2 != null)
		{
			if (list1.val < list2.val)
			{
				mList.next = list1;
				list1 = list1.next;
			} else if (list1.val > list2.val)
			{
				mList.next = list2;
				list2 = list2.next;
			} else
			{
				mList.next = list1;
				list1 = list1.next;
				mList = mList.next;

				mList.next = list2;
				list2 = list2.next;
			}

			mList = mList.next;
		}

		while (list1 != null)
		{
			mList.next = list1;
			list1 = list1.next;
			mList = mList.next;
		}

		while (list2 != null)
		{
			mList.next = list1;
			list1 = list1.next;
			mList = mList.next;
		}
		return head.next;
	}

	public static void main(String[] args)
	{
		ListNode rootNode1 = createList(1, 2, 4);
		ListNode rootNode2 = createList(1, 3, 4);

		ListNode mergedList = new Merge2SortedLinkedList().merge2Lists(rootNode1, rootNode2);

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
