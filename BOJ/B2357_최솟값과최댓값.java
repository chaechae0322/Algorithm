package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * indexed tree
 */
public class B2357_최솟값과최댓값 {
	static int N,M,num[],leaf,min,max;
	static class Node {
		int min, max;

		public Node(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Node [min=" + min + ", max=" + max + "]";
		}
	}
	static Node[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken()); M=Integer.parseInt(token.nextToken());
		tree=new Node[N*4]; num=new int[N+1];
		leaf=1;
		while(leaf<N) {
			leaf*=2;
		}
		for(int i=1; i<=N; i++) {
			num[i]=Integer.parseInt(br.readLine());
		}
		makeTree(1,1,leaf);
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken()); int b=Integer.parseInt(token.nextToken());
			min=Integer.MAX_VALUE; max=0;
			query(1, a,b,1,leaf);
			System.out.println(min+" "+max);
		}
	}
	static int cnt;
	private static void query(int node, int ql, int qr, int l,int r) {
		if(r<ql || l>qr) { // 아닐때 
			return;
		}
		else if(l>=ql && r<=qr) { // 속해있을때
			min=Math.min(min, tree[node].min);
			max=Math.max(max, tree[node].max);
		}
		else { // 걸쳐있을때
			int mid=l+(r-l)/2;
			query(node*2, ql, qr, l, mid);
			query(node*2+1, ql, qr, mid+1, r);
		}

	}

	private static void makeTree(int node, int l, int r) {
		if(l==r) {
			if(l<=N) {
				tree[node]=new Node(num[l], num[l]);
			}else {
				tree[node]=new Node(Integer.MAX_VALUE, 0);
			}
		}else {
			int mid = l+(r-l)/2;
			makeTree(node*2, l, mid);
			makeTree(node*2+1, mid+1, r);
			int min=Integer.MAX_VALUE, max=0;
			
			min=Math.min(min, tree[node*2].min);
			max=Math.max(max, tree[node*2].max);
			min=Math.min(min, tree[node*2+1].min);
			max=Math.max(max, tree[node*2+1].max);
			tree[node]=new Node(min,max);
		}
	}


}
