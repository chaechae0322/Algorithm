package BOJ.sds_algo.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1339_단어수학 {
	static int N;
	static char[][] word;
	static class Node{
		char ch;
		int value;
		public Node(char ch, int value) {
			this.ch=ch;
			this.value=value;
		}
		public char getCh() {
			return ch;
		}
		public void setCh(char ch) {
			this.ch = ch;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [ch=" + ch + ", value=" + value + "]";
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		word = new char[N][8];
		int idx=8;
		int maxlen=0;

		int[] alpha=new int[26];
		for(int i=0; i<N; i++) {
			idx=7;
			String input = br.readLine();
			int p=1;
			maxlen=Math.max(input.length(), maxlen);
			for(int j=input.length()-1; j>=0; j--) {
				word[i][idx]=input.charAt(j);
				alpha[word[i][idx]-'A']+=p;
				idx--;
				p*=10;
			}
		}

		PriorityQueue<Node> pq= new PriorityQueue<>(Comparator.comparing(Node::getValue).reversed());
		for(int i=0; i<26; i++) {
			if(alpha[i]!=0) {
				pq.add(new Node((char)(i+'A'), alpha[i]));
			}
		}

		int[] num=new int[26];
		int tmp=9;
		while(!pq.isEmpty()) {
			num[pq.poll().ch-'A']=tmp--;
		}

		int res=0; int p=1;
		for(int j=7; j>=8-maxlen; j--) {
			for(int i=0; i<N; i++) {
				if(word[i][j]!='\u0000') {
					res+= (num[word[i][j]-'A']*p);
				}
			}
			p*=10;
		}


		System.out.println(res);

	}

}
