package map;

import java.util.ArrayList;

public class MyHashMap<K, V> {

	ArrayList<MapNode<K, V>> buckets;
	int size; // number of entries
	int numBuckets; // number of buckets

	public MyHashMap() {
		numBuckets = 5;
		buckets = new ArrayList<>();
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
	}

	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}

	public int size() {
		return size;
	}

	public double loadFactor() {
		return (double) size / numBuckets;
	}

	private void rehash() {
		System.out.println("\nNumber of Entries = " + size + "\nNumber of Buckets = " + numBuckets + "\nLoad Factor = "
				+ (double) size / numBuckets);
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		for (int i = 0; i < 2 * numBuckets; i++) {
			buckets.add(null);
		}
		size = 0;
		numBuckets *= 2;
		for (int i = 0; i < temp.size(); i++) {
			MapNode<K, V> curr = temp.get(i);
			while (curr != null) {
				K key = curr.key;
				V value = curr.value;
				insert(key, value);
				curr = curr.next;
			}
		}
	}

	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> curr = buckets.get(bucketIndex); // curr is a pointer which will be used to traverse the
														// LinkedList

		// traverse through the LinkedList, if the key is found then update it's value
		while (curr != null) {
			if (curr.key.equals(key)) {
				curr.value = value;
				return;
			}
			curr = curr.next;
		}
		// if the control comes here, this means that the key is not present in the Map,
		// so we will create a new MapNode
		curr = buckets.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
		newElementNode.next = curr;
		buckets.set(bucketIndex, newElementNode);
		size++;

		double loadFactor = (double) size / numBuckets;
		if (loadFactor > 0.7)
			rehash();
	}

	public boolean containsKey(K key) {
		int index = getBucketIndex(key);
		MapNode<K, V> curr = buckets.get(index); // this is a pointer which will traverse
		while (curr != null) {
			// here equals method can be override if you want to use your using your own
			// class object else Wrapper class like INTEGER, DOUBLE..have their own equals()
			if (curr.key.equals(key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> curr = buckets.get(bucketIndex); // curr is a pointer which will be used to traverse the
														// LinkedList

		// traverse through the LinkedList, if the key is found then return its value
		while (curr != null) {
			if (curr.key.equals(key)) {
				return curr.value;
			}
			curr = curr.next;
		}
		return null;
	}

	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		// curr is a pointer which will be used to traverse the LinkedList
		MapNode<K, V> curr = buckets.get(bucketIndex);
		// prev is another pointer which will be used to store the location of the
		// previous node
		MapNode<K, V> prev = null;

		// traverse through the LinkedList, if the key is found then return its value
		while (curr != null) {
			if (curr.key.equals(key)) {
				if (prev == null)
					buckets.set(bucketIndex, curr.next);
				else
					prev.next = curr.next;

				size--;
				return curr.value;
			}
			prev = curr;
			curr = curr.next;
		}
		return null;
	}

	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		for (int i = 1; i <= 20; i++) {
			map.insert("abc" + i, i);
			System.out.println("For Entry " + i + " LoadFactor = " + map.loadFactor());
		}
		System.out.println(map.containsKey("abc5"));
		map.remove("abc8");
		map.remove("abc9");
		map.remove("abc8");

		for (int i = 0; i < map.size(); i++) {
			System.out.println("abc" + i + ":" + map.getValue("abc" + i));
		}
	}

}

class MapNode<K, V> {

	K key;
	V value;
	MapNode<K, V> next;

	public MapNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
