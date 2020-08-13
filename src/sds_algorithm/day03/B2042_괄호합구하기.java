package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2042_괄호합구하기 {
	static int N, M, K;
	static long[] nums;
	static long[] tree;
	static int leafNode;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		K=Integer.parseInt(token.nextToken());

		nums=new long[N];
		for(int i=0; i<N; i++) {
			nums[i]=Long.parseLong(br.readLine());
		}

		// make tree
		int depth = -1;
		
		while(Math.pow(2, ++depth) < N); 
		int leafSize = (int) Math.pow(2, depth);
		System.out.println(depth);

		tree=new long[(int) Math.pow(2, depth+1)];
		System.out.println(Arrays.toString(tree));

		makeTree(1, 1, leafSize );

		long a=0, b=0, c=0;
		for(int i=0; i<M+K; i++) {
			token = new StringTokenizer(br.readLine());
			a=Long.parseLong(token.nextToken());
			b=Long.parseLong(token.nextToken());
			c=Long.parseLong(token.nextToken());
			if(a==1) { // update

				update(1, 1, leafSize , (int)b, c-nums[(int)b-1]);
				nums[(int)b-1]=c;
			}else { // query
				System.out.println(query(1, 1, leafSize , (int)b, (int)c));
			}
		}
	}
	private static long query(int node, int left, int right, int qLeft, int qRight) {
		if(left>qRight || right<qLeft) return 0;
		else if(qLeft<=left && qRight>=right) return tree[node];
		else { // through
			int mid = (left+right)/2;
			return query(node*2, left, mid, qLeft, qRight)+
					query(node*2+1, mid+1, right, qLeft, qRight);
		}
	}
	private static void update(int node, int left, int right, int index, long diff) {
		if(index < left || index > right) return;

		/*if(left==right) {
			tree[node]+=diff;
			return;
		}*/
		tree[node]+=diff;
		if(left!=right) {
			int mid=(left+right)/2;
			update(node*2, left, mid, index, diff);
			update(node*2+1, mid+1, right, index, diff);
		}

	}
	private static long makeTree(int node, int left, int right) {
		System.out.println(node+" "+left+" "+right);
		if(left == right) {
			if(left>N) tree[node] = 0;
			else tree[node] = nums[left-1];

			System.out.println(Arrays.toString(tree));
			return tree[node];
		}
		int mid = (left+right)/2;
		tree[node]=makeTree(node*2, left, mid);
		tree[node]+=makeTree(node*2+1, mid+1, right);
		return tree[node];
	}

}
