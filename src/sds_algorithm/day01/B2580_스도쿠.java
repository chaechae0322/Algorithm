package sds_algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2580_스도쿠 {

	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i=0; i<9; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
				map[i][j]=Integer.parseInt(token.nextToken());
		}

		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(map[i][j]==0) {
					dfs(j, i);
				}
			}
		}
	}
	private static void dfs(int x, int y) {
		//가로 세로
		boolean[] check=new boolean[10];
		int cnt=0;
		boolean find=false;
		for(int i=0; i<9; i++) {
			if(map[y][i]>0) {
				check[map[y][i]]=true;
				cnt++;
			}
		}
		if(cnt==8) {
			for(int i=1; i<10; i++) {
				if(!check[i]) {
					map[y][x]=i;
					find=true;
					break;
				}
			}
		}
		
	}

}
