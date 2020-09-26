package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 재귀
 * 트리 
 * 너무 어렵게 푼듯.. 더 빠른방법이 있다
 */
public class B2263_트리의순회 {
	static int n, in[], post[], info[][], g[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		n=Integer.parseInt(br.readLine());
		in=new int[n]; post=new int[n]; g=new int[n+1][2];
		for(int i=0; i<=n; i++) {
			g[i][0]=-1; g[i][1]=-1;
		}
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			in[i]=Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			post[i]=Integer.parseInt(token.nextToken());
		}

		idx=n;
		solve(0, n-1, -1, -1);
		preorder(post[n-1]);
	}
	private static void preorder(int x) {
		if(x==-1) return;
		visit(x);
		preorder(g[x][0]);
		preorder(g[x][1]);
	}
	private static void visit(int x) {
		if(x==-1) return;
		System.out.print(x+" ");
	}
	static int cnt, idx;
	private static void solve(int l, int r, int p, int sel) {
		if(l>r) return;
		
		int pivot = post[--idx];
		for(int i=l; i<=r; i++) {
			if(in[i]==pivot) {
				solve(i+1, r, pivot, 1);
				solve(l, i-1, pivot, 0);
			}
		}
		if(sel==0) g[p][0]=pivot;
		else if(sel==1) g[p][1]=pivot;
	}
}
