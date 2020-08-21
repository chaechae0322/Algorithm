package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  Indexed Tree
 */
public class B2243_사탕상자 {
	static int[] indextree;
	static int leafSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		// make tree space 1~1000000
		leafSize = 1000000;
		indextree= new int[1000000*4];


		int a, b, c=0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			a=Integer.parseInt(token.nextToken());
			if(a==1) {
				// 꺼내기
				b=Integer.parseInt(token.nextToken());
				int res = query(1, 1, leafSize, b); // node, left, right, n-th
				update(1, 1, leafSize, res, -1);

			}else {
				// 넣기
				b=Integer.parseInt(token.nextToken());
				c=Integer.parseInt(token.nextToken());
				update(1, 1, leafSize, b, c); // b에 c개 넣기 
			}
		}
	}
	private static int query(int node, int left, int right, int x) {
		if(indextree[node]==0 || indextree[node]<x || x<=0) {
			return 0;
		}
		if(left==right) {
			return left;
		}

		int mid= (left+right)/2;
		int res = query(node*2, left, mid, x); // 0
		res +=query(node*2+1, mid+1, right, x-indextree[node*2]);
		return res;
	}
	private static void update(int node, int left, int right, int index, int diff) {
		if(index<left || index>right) return;

		indextree[node]+=diff;
		if(left < right) {
			int mid = (left+right)/2;
			update(node*2, left, mid, index, diff);
			update(node*2+1, mid+1, right, index, diff);
		}

	}

}
