package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * indexed tree
 */
public class B2357_최솟값과최댓값 {
	static int N,M,num[], leaf;
	static class Node{
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
		tree=new Node[N*4+1]; num=new int[N+1];
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
			Node res = qeury(1,a,b,1,leaf);
			System.out.println(res.min+" "+res.max);
		}
	}
	private static Node makeTree(int n, int l, int r) {
		if(l==r) {
			tree[n]=new Node(num[n-leaf/2], num[n]);
		}else {
			int mid = l+(r-l)/2;
			Node le=makeTree(n*2, l, mid);
			Node ri=makeTree(n*2+1, mid+1, r);
			tree[n]=new Node(le.min<ri.min?le.min:ri.min, le.max>ri.max?le.max:ri.max);
		}
		return tree[n];
	}
	

}
