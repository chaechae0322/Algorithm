package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * Trie
 */
public class B4358_생태학 {

	static TrieNode head;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		head=new TrieNode();

		while((input=br.readLine())!=null && input.length()!=0) {
			//System.out.println(input);
			//input = input.replace("\\", "");
			insert(input);
		}
		
		//System.out.println("total:"+total);
		travers(head, new StringBuilder());

	}
	private static void travers(TrieNode current, StringBuilder sb) throws IOException {
		if(current.isEnd) {
			//System.out.println();
			double percent = current.count*100.0 / total;// + 0.00005;
			System.out.printf("%s %.4f\n", sb.toString(), percent);
		}
		
		for(int i=0; i<96; i++) {
			char ch=(char)(i+' ');
			if(current.hasChild(ch)) {
				sb.append(ch);
				travers(current.getChild(ch), sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
		
	}
	static int total;
	private static void insert(String word) {
		TrieNode current = head;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			//System.out.println("char: "+ch+" number:"+(ch-' '));
			if(!current.hasChild(ch)) {
				current.children[ch-' ']=new TrieNode();
			}
			current=current.getChild(ch);
		}
		current.isEnd=true;
		current.count++;
		//System.out.println("count:"+current.count);
		total++;
	}
	
}

class TrieNode{
	char ch;
	int count;
	boolean isEnd;
	TrieNode[] children = new TrieNode[96]; 

	public boolean hasChild(char ch) {
		return children[ch-' ']!=null;
	}
	public TrieNode getChild(char ch) {
		return children[ch-' '];
	}
	
}