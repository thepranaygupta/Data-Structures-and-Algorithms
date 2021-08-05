package treeDS;

import java.util.*;

// Trie using HashMap give you the edge in inserting any string containing any character over Trie using Array.
public class Trie_HashMap {

	public static void main(String[] args) {
		Trie_Hash tr = new Trie_Hash();
		tr.insert("antman");
		tr.insert("ant");
		tr.insert("anty");
		tr.insert("anu");
		tr.insert("batman");
		tr.insert("bat");
		tr.insert("pranay/");
		System.out.println(tr.search("hello"));
		System.out.println(tr.search("ant"));
		System.out.println(tr.search("bat"));
		System.out.println(tr.search("antman"));
		System.out.println(tr.search("vikash"));
		System.out.println(tr.search("pranay/"));
		System.out.println(tr.startsWith("an"));
		// checking delete function
		System.out.println(tr.search("ant"));
		tr.delete("ant");
		System.out.println(tr.search("ant"));
	}

}

class Trie_Hash {

	class Node {
		Map<Character, Node> next;
		boolean isEnd;
		int count;// this will keep the count for the no. of words formed using particular
		// character.

		public Node() {
			next = new HashMap<>();
			isEnd = false;
			count = 0;
		}
	}

	Node root;

	public Trie_Hash() {
		root = new Node();
	}

	public void insert(String wrd) {
		Node curr = root;

		for (char c : wrd.toCharArray()) {
			if (curr.next.get(c) == null)
				curr.next.put(c, new Node());
			curr.next.get(c).count++;
			curr = curr.next.get(c);
		}

		curr.isEnd = true;
	}

	public boolean search(String wrd) {
		Node curr = root;

		for (char c : wrd.toCharArray()) {
			if (curr.next.get(c) == null)
				return false;
			curr = curr.next.get(c);
		}
		return curr.isEnd;
	}

	// return true if any word with "prefix" is present in trie
	public boolean startsWith(String prefix) {
		Node curr = root;

		for (char c : prefix.toCharArray()) {
			if (curr.next.get(c) == null)
				return false;
			curr = curr.next.get(c);
		}
		System.out.println("No. of string formed using prefix - '" + prefix + "' is " + curr.count);
		return true;
	}

	public void delete(String wrd) {
		if (search(wrd)) {
			Node curr = root;

			for (char c : wrd.toCharArray()) {
				curr = curr.next.get(c);
			}
			curr.isEnd = false;
			System.out.println("deleted");
		} else {
			System.out.println("word not found");
		}
	}
}
