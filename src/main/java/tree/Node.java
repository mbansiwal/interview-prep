package tree;

public class Node {
	public int data;
	public Node left, right;
	public int level;
	public boolean isThreaded = false;

	 public Node(int item)
	 {
		 data = item;
	     left = right = null;
	 }
}
