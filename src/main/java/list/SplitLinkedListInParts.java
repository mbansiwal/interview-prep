package list;

public class SplitLinkedListInParts
{
	public ListNode[] splitListToParts(ListNode root, int k)
	{
		ListNode node = root;
		int length = 0;
		while (node != null)
		{
			node = node.next;
			length++;
		}
		int width = length / k;
		int remainder = length % k;
		ListNode[] listNodes = new ListNode[k];
		ListNode current = root;
		for (int i = 0; i < k; i++)
		{
			ListNode head = current;

			for (int j = 0; j < width + (i < remainder ? 1 : 0); j++)
			{
				if (current != null)
				{
					current = current.next;
				}
			}
			if (current != null)
			{
				ListNode previous = current;
				current = current.next;
				previous.next = null;
				listNodes[i] = head;
			}
		}
		return listNodes;
	}

	public static void main(String[] args)
	{

	}
}
