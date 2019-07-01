package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	Node root;
	Map<Integer, List<Integer>> orderMap = new TreeMap<>();
	
	public void createDataMap(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();

		queue.offer(node);
		int horizontalDistance = 0;
		while (!queue.isEmpty()) 
		{
			Node localNode = queue.poll();
			horizontalDistance = localNode.level;			
			if(!orderMap.containsKey(horizontalDistance))
			{
				orderMap.put(horizontalDistance, new ArrayList<>());
			}
			orderMap.get(horizontalDistance).add(localNode.data);
			
			if (localNode.left != null) 
			{
				localNode.left.level = horizontalDistance - 1;
				queue.offer(localNode.left);
			}
			
			if (localNode.right != null) 
			{
				localNode.right.level = horizontalDistance + 1;
				queue.offer(localNode.right);
			}
		}
	}
	
	public void verticalOrder() {
		System.out.println("Vertical Order");
		orderMap.forEach((level,elements)->{
			System.out.println("Level = "+level);
			elements.forEach(element->System.out.print(element+" "));
			System.out.println();
		});
	}

	public void topView() {
		System.out.println("Top View");
		orderMap.forEach((level,elements)->{
			System.out.println("Level = "+level+",Element= "+elements.get(0));
		});
	}
	
	public void bottomView() {
		System.out.println("Bottom View");
		orderMap.forEach((level,elements)->{
			System.out.println("Level = "+level+",Element= "+elements.get(elements.size()-1));
		});
	}
	
	public void verticalSum() {
		System.out.println("Vertical Sum");
		orderMap.forEach((level,elements)->{
			int total = elements.stream().reduce((sum,n)->sum+n).get();
			System.out.println("Level = "+level+",Total= "+total);
		});
	}

	public static void main(String[] args) {
		VerticalOrderTraversal tree = new VerticalOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		
		tree.root.right.right.left = new Node(10);
		tree.root.right.right.left.right = new Node(11);
		tree.root.right.right.left.right.right = new Node(12);
		
		tree.createDataMap(tree.root);
		tree.verticalOrder();
		tree.verticalSum();
		tree.topView();
		tree.bottomView();
		
	}
}
