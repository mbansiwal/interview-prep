public class Test {

	public static void main(String[] args) {
		// byte[] bitField = new byte [0xFFFFFFF/8];
		// System.out.println(bitField.length);
		// System.out.println(17 % 8) ;
		// System.out.println(1 << (21 % 8) );
		// int n = 21;
		// bitField [n / 8] = (byte)(1 << (n % 8));
		//
		// for(int i = 0 ; i < bitField.length; i++)
		// {
		// for (int j = 0; j < 8; j++)
		// {
		// if ((bitField[i] & (1 << j)) == 0)
		// {
		// System.out.println (i * 8 + j);
		// }
		// }
		// }

		Test test = new Test();


		test.addTwoNumbers();
	}

	class ListNode
	{
		int val;
		ListNode next;

		public ListNode(int x)
		{
			val = x;
		}
	}

	public void addTwoNumbers()
	{
		// ListNode listNode = new ListNode(2);
		// listNode.next = new ListNode(4);
		// listNode.next.next = new ListNode(3);
		//
		// ListNode listNode2 = new ListNode(5);
		// listNode2.next = new ListNode(6);
		// listNode2.next.next = new ListNode(4);

		ListNode listNode = new ListNode(1);

		ListNode listNode2 = new ListNode(9);
		listNode2.next = new ListNode(9);

		addTwoNumbers(listNode, listNode2);
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode result = null;

		ListNode prev = null;
		int carry = 0;
		while (l1 != null || l2 != null)
		{
			int temp = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

			if (l1 != null)
			{
				l1 = l1.next;
			}

			if (l2 != null)
			{
				l2 = l2.next;
			}

			carry = (temp > 9 ? 1 : 0);
			temp = temp % 10;
			ListNode tempNode = new ListNode(temp);
			if (result == null)
			{
				result = tempNode;
			} else
			{
				prev.next = tempNode;
			}

			prev = tempNode;
		}

		if (carry == 1)
		{
			prev.next = new ListNode(1);
		}

		while (result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}

		return result;
	}
}
