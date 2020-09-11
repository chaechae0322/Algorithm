package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
 * Trie
 */
public class B5052_전화번호목록 {
	static class Node{
		char ch;
		boolean end;
		Node[] child=new Node[10];
		public Node(char ch) {
			this.ch=ch;
		}
		public boolean isChild(char ch) {
			return child[ch-'0']!=null;
		}
		public Node getChild(char ch) {
			return child[ch-'0'];
		}
	}
	static Node root;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n=Integer.parseInt(br.readLine());
			String[] in=new String[n];
			root=new Node('\u0000');
			boolean res=true;
			for(int i=0; i<n; i++) in[i]=br.readLine();
			Arrays.sort(in, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.length()-o2.length();
				}
			});
			for(int i=0; i<n; i++) {
				//System.out.println("insert "+in[i]);
				res=insert(in[i]);
				if(!res) {
					break;
				}
			}
			if(!res) System.out.println("NO");
			else System.out.println("YES");
		}
	}
	private static boolean insert(String in) {
		Node cur=root;
		for(int i=0; i<in.length(); i++) {
			char ch=in.charAt(i);
			if(!cur.isChild(ch)) {
				cur.child[ch-'0']=new Node(ch);
			}
			cur=cur.getChild(ch);
			if(cur.end) {
				return false;
			}
		}
		cur.end=true;
		return true;
	}

}
