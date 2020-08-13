package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1991_트리순회 {
	static class Node {
		int left=-1;
		int right=-1;
	}
	static int N;
	static Node[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		tree=new Node[26];
		char tmp='\u0000';
		int first = 0;
		int pos=1;
		
		System.out.println((int)Math.pow(2, 26));

		for(int i=1; i<=N; i++) {
			token = new StringTokenizer(br.readLine());
			tmp=token.nextToken().charAt(0);
			pos=tmp-'A';
			tree[pos]=new Node();
			if(i==1) {
				first = tmp-'A';
			}
			System.out.println("pos:"+pos);
			//tree[pos]=tmp;

			tmp=token.nextToken().charAt(0);
			if(tmp!='.') {
				tree[pos].left=tmp-'A';
			}
			tmp=token.nextToken().charAt(0);
			if(tmp!='.') {
				tree[pos].right=tmp-'A';
			}
		}
		//System.out.println(Arrays.toString(tree));
		preOrderTravers(first);
		System.out.println();
		inOrderTravers(first);
		System.out.println();
		postOrderTravers(first);
		System.out.println();
	}

	private static void postOrderTravers(int idx) {
		if(idx<0) return;
		postOrderTravers(tree[idx].left); // left
		postOrderTravers(tree[idx].right); // right
		visit(idx);
	}
	private static void visit(int idx) {
		if(idx<0) return;
		System.out.print((char)(idx+'A'));
		
	}

	private static void inOrderTravers(int idx) {
		if(idx<0) return;
		inOrderTravers(tree[idx].left); // left
		visit(idx);
		inOrderTravers(tree[idx].right); // right


	}
	private static void preOrderTravers(int idx) {
		if(idx<0) return;
		visit(idx);
		preOrderTravers(tree[idx].left); // left
		preOrderTravers(tree[idx].right); // right

	}

}
