package treeDS;

public class Trie_Array {

	public static void main(String[] args) {
		Trie_Ar tr = new Trie_Ar();
		tr.insert("antman");
		tr.insert("ant");
		tr.insert("batman");
		tr.insert("bat");
		tr.insert("batball");
		tr.insert("pranay");
		tr.insert("anu");
		tr.insert("test");
		tr.insert("testing");
		System.out.println(tr.search("hello"));
		System.out.println(tr.search("ant"));
		System.out.println(tr.search("bat"));
		System.out.println(tr.search("antman"));
		System.out.println(tr.search("pranay"));
		System.out.println(tr.startsWith("an"));
		System.out.println(tr.startsWith("prana"));
		System.out.println(tr.startsWith("bat"));
		// checking delete function
		System.out.println(tr.search("ant"));
		tr.delete("ant");
		System.out.println(tr.search("ant"));
	}

}

class Trie_Ar {

	class Node {
		char data;
		Node next[];
		int count; // this will keep the count for the no. of words formed using particular character
		boolean isEnd;

		public Node(char data) {
			this.data = data;
			next = new Node[26];
			isEnd = false;
			count = 0;
		}
	}

	Node root;

	public Trie_Ar() {
		root = new Node('\0');
	}

	public void insert(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null)
				curr.next[c - 'a'] = new Node(c);
			curr.next[c - 'a'].count++;
			curr = curr.next[c - 'a'];
		}
		curr.isEnd = true; //this marks the end of the word, so now the word exists in the trie
	}

	public boolean search(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null)
				return false;
			curr = curr.next[c - 'a'];
		}
		return curr.isEnd;
	}

	// return true if any word with "prefix" is present in trie
	public boolean startsWith(String prefix) {
		Node curr = root;
		for (char c : prefix.toCharArray()) {
			if (curr.next[c - 'a'] == null)
				return false;
			curr = curr.next[c - 'a'];
		}
		System.out.println("No. of string formed using prefix - '" + prefix + "' is = " + curr.count);
		return true;
	}

	public void delete(String word) {
		if (search(word)) {
			Node curr = root;
			for (char c : word.toCharArray()) {
				curr = curr.next[c - 'a'];
			}
			curr.isEnd = false; //this unmarks the end of word, so now the entire word is non-existent in the trie
			System.out.println("Deleted");
		}
		
		else {
			System.out.println("Word not fount");
			return;
		}
	}
}
