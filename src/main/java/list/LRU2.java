package list;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRU2<K, V> implements Cache<K, V>{
	private Map<K, MyNode<K, V>> map = new ConcurrentHashMap<>();
	private int capacity;
	private MyNode<K, V> head;
	private MyNode<K, V> mruNode;
	private Lock writeLock;
	private Lock readLock;
	
	public LRU2(int capacity) {
		this.capacity = capacity;
		head = new MyNode<>(null, null);
		mruNode = head;
		ReadWriteLock lock = new ReentrantReadWriteLock();
		readLock = lock.readLock();
		writeLock = lock.writeLock();
	}

	@Override
	public void add(K key, V value) {
		if(map.containsKey(key)) {
			updateValue(key, value);
			return;
		}
		if(map.size() == capacity) {
			removeLRUNode();
		}
		MyNode<K, V> node = new MyNode<>(key, value);
		attachMruNode(node);
		map.put(key, node);
	}
	
	private void updateValue(K key, V value) {
		MyNode<K, V> currentNode = map.get(key);
		currentNode.value = value;
		updateMruNode(currentNode);
	}
	
	private void removeLRUNode(){
		writeLock.tryLock();
		try {
			MyNode<K, V> topNode = head.next;
			head.next = topNode.next;
			map.remove(topNode.key);
			head.next.previous = head;
		} finally{
			writeLock.unlock();
		}
	}

	private void attachMruNode(MyNode<K, V> node){
		writeLock.tryLock();
		try {
			mruNode.next = node;
			node.previous = mruNode;
			mruNode = node;
			mruNode.next = null;
		} finally{
			writeLock.unlock();
		}
	}
	
	private void updateMruNode(MyNode<K, V> currentNode){
		writeLock.tryLock();
		try {
			MyNode<K, V> previousNode = currentNode.previous;
			MyNode<K, V> nextNode = currentNode.next;
			previousNode.next = nextNode;
			nextNode.previous = previousNode;
			attachMruNode(currentNode);
		} finally{
			writeLock.unlock();
		}
	}
	
	@Override
	public V get(K key) {
		if(map.containsKey(key)) {
			MyNode<K, V> node = map.get(key);
			if(node != mruNode) {
				updateMruNode(node);
			}
			return node.value;
		}
		return null;
	}

	@Override
	public void print() {
		System.out.println("=============Start============");
		MyNode<K, V> node = head.next;
		while(node != null) {
			System.out.println("Key == " + node.key + ", value ==" + node.value);
			node = node.next;
		}
		System.out.println("=============End============");
	}
	
	public static void main(String[] args) {
		Cache<String, String> cache = new LRU2<>(2);
		cache.add("k1", "v1");
		cache.add("k2", "v2");
		cache.print();
		System.out.println("Key == k1 , value ==" + cache.get("k1"));
		System.out.println("Key == k3 , value ==" + cache.get("k3"));
		cache.print();
		System.out.println("Key == k2 , value ==" + cache.get("k2"));
		cache.print();
		cache.add("k3", "v3");
		cache.add("k2", "v4");
		cache.print();
		cache.add("k3", "v3-1");
		cache.print();
	}
}
