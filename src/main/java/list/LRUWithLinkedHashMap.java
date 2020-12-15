package list;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUWithLinkedHashMap<K, V> implements Cache<K, V> {
	private Map<K, V> cache;
	private ConcurrentLinkedDeque<K> queue;
	private int size;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock writeLock;
	private Lock readLock;

	public LRUWithLinkedHashMap(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size should be greater than zero");
		}
		this.size = size;
		this.cache = new ConcurrentHashMap<>();
		this.queue = new ConcurrentLinkedDeque<>();
		this.writeLock = lock.writeLock();
		this.readLock = lock.readLock();
	}

	@Override
	public void add(K key, V value) {
		writeLock.tryLock();
		try {
			if(cache.containsKey(key)) {
				queue.remove(key);
			}
			if(cache.size() == size) {
				cache.remove(queue.poll());
			}
			queue.add(key);
			cache.put(key, value);
		} finally{
			writeLock.unlock();
		}
	}

	@Override
	public V get(K key) {
		readLock.tryLock();
		try {
			if(cache.containsKey(key)) {
				queue.remove(key);
				queue.add(key);
				return cache.get(key);
			}
		} finally{
			readLock.unlock();
		}
		return null;
	}

	@Override
	public void print() {
		System.out.println("=========================");
		for (Object value : cache.values()) {
			System.out.println("Key == " + value + ", value ==" + value);
		}
	}
	
	public static void main(String[] args) {
		Cache<String, String> cache = new LRUWithLinkedHashMap<String, String>(2);
	    cache.add("key1", "value1");
	    cache.add("key2", "value2");
	    
	    cache.print();
	    System.out.println("key1= "+cache.get("key1"));
	    cache.add("key3", "value3");
	    cache.print();
	    cache.add("key4", "value4");
//	    
	    cache.print();
	    System.out.println("key1= "+cache.get("key1"));
	    System.out.println("key4= "+cache.get("key4"));
	    System.out.println("key3= "+cache.get("key3"));
	    cache.add("key5", "value5");
	    System.out.println("key3= "+cache.get("key3"));
	    cache.print();		    
	    
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
