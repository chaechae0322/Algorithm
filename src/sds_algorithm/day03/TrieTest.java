package sds_algorithm.day03;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.insert("ABC");
		System.out.println(t.checkWord("ABC"));
		System.out.println(t.checkWord("ABCD"));
	}


}

class Trie{
	TrieNode root = new TrieNode();
	void insert(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(!current.hasChild(c)) {
				current.children[c-'A']=new TrieNode();
				current = current.getChild(c);
			}
		}
		current.isEnd=true;
	}
	
	boolean checkWord(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(!current.hasChild(c)) return false;
			
			current = current.getChild(c);
			
		}
		return current.isEnd;
	}
	

}

class TrieNode{
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;
	
	TrieNode getChild(char c) {
		return children[c-'A'];
	}
	
	boolean hasChild(char c) {
		return children[c-'A']!=null;
	}
}
