package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B2263_트리의순회 {
	static int n, in[], post[], info[][];
	static List<Integer>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		n=Integer.parseInt(br.readLine());
		in=new int[n]; post=new int[n]; g=new ArrayList[n+1];
		info=new int[n][2];
		for(int i=0; i<=n; i++) g[i]=new ArrayList<>();
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			in[i]=Integer.parseInt(token.nextToken());
			info[i][0]=i; info[i][1]=in[i];
		}
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			post[i]=Integer.parseInt(token.nextToken());
		}
		Arrays.sort(info, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		solve(0, n-1);
		preorder(post[n-1]);
	}
	private static void preorder(int x) {
		visit(x);
		for(int i=0; i<g[x].size(); i++) {
			preorder(g[x].get(i));
		}
	}
	private static void visit(int x) {
		System.out.print(x+" ");
	}
	static int cnt;
	private static int solve(int l, int r) {
		cnt++;
		if(cnt>=10) System.exit(0);
		
		int pivot = post[r];
		System.out.println("l:"+l+" r:"+r+" pivot:"+pivot);
		for(int i=l; i<r; i++) {
			if(in[i]==pivot) {
				g[pivot].add(solve(l, i-1));
				g[pivot].add(solve(i+1, r));
			}
		}
		return in[l];
	}
}
