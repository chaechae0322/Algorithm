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
	trieNode root = new trieNode();
	void insert(String word) {
		trieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(!current.hasChild(c)) {
				current.children[c-'A']=new trieNode();
				current = current.getChild(c);
			}
		}
		current.isEnd=true;
	}
	
	boolean checkWord(String word) {
		trieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(!current.hasChild(c)) return false;
			
			current = current.getChild(c);
			
		}
		return current.isEnd;
	}
}


class trieNode{
	trieNode[] children = new trieNode[26];
	boolean isEnd;
	
	trieNode getChild(char c) {
		return children[c-'A'];
	}
	
	boolean hasChild(char c) {
		return children[c-'A']!=null;
	}
}