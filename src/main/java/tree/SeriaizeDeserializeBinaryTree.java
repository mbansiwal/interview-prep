package tree;

import java.util.Arrays;
import java.util.Iterator;

public class SeriaizeDeserializeBinaryTree 
{
	Node root;
	Node deserializedRoot;
	Iterator<String> dataList;
	
	public void inOrder(Node node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.data+" ");
		inOrder(node.left);
		
		inOrder(node.right);
	}
	
	public void serialize(Node node, StringBuilder sb)
	{
		if(node == null)
		{
			sb.append("; ");
			return;
		}
		
		sb.append(node.data+" ");
		serialize(node.left, sb);
		serialize(node.right, sb);
	}
	
	public void deSerialize(StringBuilder sb)
	{
		dataList = Arrays.asList(sb.toString().trim().split(" ")).iterator();
		deSerialize(true);
	}
	
	public Node deSerialize(boolean first)
	{
		if(!dataList.hasNext())
		{
			return null;
		}
		
		String element = dataList.next();
		if (!element.equals(";"))
		{
			Node root1 = new Node(Integer.parseInt(element));
			
			if(first)
			{
				deserializedRoot = root1;
				first = false;
			}
			root1.left = deSerialize(first);
			root1.right = deSerialize(first);
			return root1;
		}
		else
		{
			return null;
		}
	}
	
	public static void main(String[] args) {
		SeriaizeDeserializeBinaryTree tree = new SeriaizeDeserializeBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.inOrder(tree.root);
        StringBuilder sb = new StringBuilder();
        tree.serialize(tree.root, sb);
        System.out.println();
        System.out.println(sb.toString());
        tree.deSerialize(sb);
        System.out.println();
        tree.inOrder(tree.deserializedRoot);
        
	}
}
