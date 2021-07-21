package map;

import java.util.ArrayList;

public class MyHashMap<K, V> {

	ArrayList<MapNode<K, V>> buckets;
	int size; // number of entries
	int numBuckets; // number of buckets

	public MyHashMap() {
		numBuckets = 10;
		buckets = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}
	
	public void put(K key, V value) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
