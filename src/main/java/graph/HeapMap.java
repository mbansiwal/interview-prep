package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class HeapMap {
	private TreeSet<HeapMapNode> treeMap;
	private Map<Vertex<Integer>, HeapMapNode> vertexSet = new HashMap<>();

	public HeapMap() {
		treeMap = new TreeSet<HeapMapNode>((obj1, obj2) -> {
			if(obj1.getVertex().equals(obj2.getVertex())) {
				return 0;
			}
			if(obj1.getWeight() >= obj2.getWeight()) {
				return 1;
			} else {
				return -1;
			}
		});
	}
	
	public void add(HeapMapNode node) {
		treeMap.add(node);
		vertexSet.put(node.getVertex(), node);
	}
	
	public boolean contains(Vertex<Integer> vertex) {
		return vertexSet.containsKey(vertex);
	}
	
	public HeapMapNode extractMin() {
		HeapMapNode node = treeMap.pollFirst();
		vertexSet.remove(node.getVertex());
		return node;
	}
	
	public void set(Vertex<Integer> vertex, int weight) {
		HeapMapNode node = vertexSet.get(vertex);
		treeMap.remove(node);
		vertexSet.remove(node.getVertex());
		node = new HeapMapNode(vertex, weight);
		treeMap.add(node);
		vertexSet.put(node.getVertex(), node);
	}
	
	public boolean isEmpty() {
		return treeMap.isEmpty();
	}
	
	public boolean isNotEmpty() {
		return !isEmpty();
	}
	
	public int getWeight(Vertex<Integer> vertex) {
		return vertexSet.get(vertex).getWeight();
	}
}
