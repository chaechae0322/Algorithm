package Programmers;

import java.util.Arrays;
import java.util.HashMap;
/*
 *  트라이 + DFS
 *  HashMap으로 Memoization
 */
public class 가사검색 {
	
	public static void main(String[] args) {
		String[] i= {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] q= {"fro??", "????t", "fr???", "fro???", "pro?"};
//		String[] i= {"abab", "a", "b", "c", "ab", "acb"};
//		String[] q= {"a?", "b?", "b", "a???", "?"};
		solution(i,q);
	}
	static HashMap<String, Integer> mem;
	static class Node{
		Node[] child=new Node[26];
		char ch;
		boolean end;

		public Node(char ch) {
			super();
			this.ch = ch;
		}
		public boolean hasChild(char ch) {
			return child[ch-'a'] != null;
		}
		public Node getChild(char ch) {
			return child[ch-'a'];
		}
		@Override
		public String toString() {
			return "Node [ch=" + ch + ", end=" + end + "]";
		}

	}
	static Node froot, broot;
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		froot = new Node('\u0000');
		broot = new Node('\u0000');
		mem = new HashMap<String, Integer>();
		for(int i=0; i<words.length; i++) {
			makeword(words[i], 1);
			makeword(words[i], 2);
		}
		for(int i=0; i<queries.length; i++) {
			answer[i]=search(queries[i]);
		}
		return answer;
	}
	private static int search(String word) {
		if(mem.containsKey(word)) {
			return mem.get(word);
		}
		int res=0;
		if(word.charAt(word.length()-1)=='?') {
			res=dfs(word, 0, 1, froot);
		}else {
			res=dfs(word, word.length()-1, 2, broot);
		}
		mem.put(word, res);
		return res;
	}
	private static int dfs(String word, int pos, int sel, Node cur) {
		if((sel==1 && pos==word.length() && cur.end) || (sel==2 && pos<0 && cur.end)) return 1;
		if(pos==word.length() || pos<0) return 0;
		
		int res=0;
		if(word.charAt(pos)=='?') {
			for(int i=0; i<26; i++) {
				if(cur.hasChild((char)(i+'a'))) {	
					res += dfs(word, sel==1?pos+1:pos-1, sel, cur.getChild((char)(i+'a')));
				}
			}
		}else {
			if(cur.hasChild(word.charAt(pos)))
				res += dfs(word, sel==1?pos+1:pos-1, sel, cur.getChild(word.charAt(pos)));
		}
		return res;
	}
	private static void makeword(String word, int sel) {
		Node cur = sel==1?froot:broot;
		if(sel==1) {
			for(int i=0; i<word.length(); i++) {
				char tmp=word.charAt(i);
				if(!cur.hasChild(tmp)) {
					cur.child[tmp-'a']=new Node(tmp);
				}
				cur=cur.getChild(tmp);
			}
			cur.end=true;
		}else {
			for(int i=word.length()-1; i>=0; i--) {
				char tmp=word.charAt(i);
				if(!cur.hasChild(tmp)) {
					cur.child[tmp-'a']=new Node(tmp);
				}
				cur=cur.getChild(tmp);
			}
			cur.end=true;
		}

	}

}
