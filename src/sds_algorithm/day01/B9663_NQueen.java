package sds_algorithm.day01;

import java.util.Scanner;

public class B9663_NQueen {

	static int[][] map;
	static int[] queen;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		queen=new int[N];

		dfs(0);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int row) {
		if(row==N) {
			ans++;
		}

		for(int j=0; j<N; j++) {
			if(check(row, j)) {
				queen[row]=j;
				dfs(row+1);
			}
		}


	}
	static int[] dx= {1,1,1,0,-1,-1,-1,0};
	static int[] dy= {-1,0,1,1,1,0,-1,-1};
	private static boolean check(int row, int pos) {
		for(int i=0; i<row; i++) { // 다른 여왕 
			
			if(queen[i]==pos) return false; //같은 열
			if(queen[i]>pos && row-i==queen[i]-pos) return false;
			if(queen[i]<pos && row-i==pos-queen[i]) return false;
		}
		return true;
	}

}
