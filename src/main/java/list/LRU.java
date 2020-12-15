package list;

import java.util.HashMap;
import java.util.Map;

class MyNode<K, T> {
	K key;
	T value;
	MyNode<K, T> previous;
	MyNode<K, T> next;
	public MyNode(K key, T value) {
		super();
		this.key = key;
		this.value = value;
	}
	public MyNode() {
		super();
	}
	
	
}

interface Cache<K, V> {
	public void add(K key, V value);

	public V get(K key);

	public void print();
}

public class LRU<K, V> implements Cache<K, V> {
	private Map<K, MyNode<K, V>> cache;
	private MyNode<K, V> lastMyNode;
	private int size;
	private MyNode<K, V> firstMyNode;

	public LRU(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size should be greater than zero");
		}
		this.size = size;
		this.cache = new HashMap<>();
		this.firstMyNode = new MyNode<>();
	}

	public void add(K key, V value) {
		MyNode<K, V> MyNode = new MyNode<>();
		MyNode.value = value;
		MyNode.key = key;

		if (cache.size() >= size) {
			MyNode<K, V> temp = firstMyNode.next;
			firstMyNode.next = temp.next;
			temp.next.previous = firstMyNode;
			temp.next = null;
			temp.previous = null;
			cache.remove(temp.key);
		}

		if (cache.isEmpty()) {
			MyNode.previous = firstMyNode;
			firstMyNode.next = MyNode;
		} else {
			lastMyNode.next = MyNode;
			MyNode.previous = lastMyNode;
		}
		lastMyNode = MyNode;
		cache.put(key, MyNode);

	}

	public V get(K key) {
		if (cache.containsKey(key)) {
			MyNode<K, V> MyNode = cache.get(key);
			if (MyNode.previous != firstMyNode && MyNode.next != null) {
				MyNode.previous.next = MyNode.next;
				lastMyNode.next = MyNode;
				MyNode.next = null;
			}

			return MyNode.value;
		}
		return null;
	}

	public void print() {
		System.out.println("=========================");
		for (MyNode MyNode : cache.values()) {
			System.out.println("Key == " + MyNode.key + ", value ==" + MyNode.value);
		}
	}


	public static void main(String[] args) {
		    Cache<String, String> cache = new LRU<String, String>(2);
		    cache.add("key1", "value1");
		    cache.add("key2", "value2");
		    
		    cache.print();
		    cache.add("key3", "value3");
		    cache.print();
		    cache.add("key4", "value4");
//		    
		    cache.print();
		    System.out.println("key1= "+cache.get("key1"));
		    System.out.println("key3= "+cache.get("key3"));
		    System.out.println("key4= "+cache.get("key4"));
		    cache.add("key5", "value5");
		    System.out.println("key3= "+cache.get("key3"));
		    cache.print();		    
//		    cache.add("key4", "value4");

//		    
//		    System.out.println("key1= "+cache.get("key1"));
//		    System.out.println("key2= "+cache.get("key2"));
//		    System.out.println("key4= "+cache.get("key4"));
//		    System.out.println("key4= "+cache.get("key3"));
//		    cache.add("key5", "value5");
//		    System.out.println("key5= "+cache.get("key5"));
//		    System.out.println("key3= "+cache.get("key3"));
//		    System.out.println("key4= "+cache.get("key4"));
//		    System.out.println("key5= "+cache.get("key5"));
		    
		    cache.add("key4", "value4");
		    System.out.println("key4= "+cache.get("key4"));
		    System.out.println("key1= "+cache.get("key1"));
		    System.out.println("key2= "+cache.get("key2"));
		    System.out.println("key3= "+cache.get("key3"));
		    cache.add("key5", "value5");
		    cache.print();
		    System.out.println("key4= "+cache.get("key4"));
		    System.out.println("key5= "+cache.get("key5"));
		    System.out.println("key3= "+cache.get("key3"));
		    System.out.println("key4= "+cache.get("key4"));
		  }
	}
