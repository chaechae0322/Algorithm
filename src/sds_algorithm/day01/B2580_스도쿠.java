package sds_algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2580_스도쿠 {

	static int[][] map;
	static int zeros;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		map=new int[9][9];

		for(int i=0; i<9; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
				if(map[i][j]==0) {
					zeros++;
				}
			}
		}

		isEnd=false;

		loop:for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(map[i][j]==0) {
					dfs(j,i,0);
					break loop;
				}
			}
		}

	}

	static boolean isEnd;
	static int recurcnt;
	private static void dfs(int x, int y, int cnt) {
		if(isEnd) return;
		boolean[] copy = new boolean[10];
		
		// horizen
		for(int i=0; i<9; i++) {
			if(i==x) continue;

			copy[map[y][i]]=true;

		}
		// vertical
		for(int i=0; i<9; i++) {
			if(i==y) continue;
			
			//if(map[y][x].check[map[i][x].num]) return; 
			copy[map[i][x]]=true;

		}

		// matrix
		
		for(int i=y/3*3; i<3*(y/3+1); i++) {
			for(int j=x/3*3; j<3*(x/3+1); j++) {
				
				copy[map[i][j]]=true;
			}
		}

		//isEnd=true;
		loop: for(int i=y; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i==y && j<=x) continue;
				if(map[i][j]==0) {
					//isEnd=false;
					for(int k=1; k<=9; k++) {
						if(!copy[k]) {
							copy[k]=true;
							map[y][x]=k;
							dfs(j,i,cnt+1);
							map[y][x]=0;
							copy[k]=false;
						}
					}
					
					break loop;
				}
			}
		}
		
		if(cnt==zeros-1) {
			isEnd=true;

			for(int k=1; k<=9; k++) {
				if(!copy[k]) map[y][x]=k;
			}
			
			for(int ii=0; ii<9; ii++) {
				for(int jj=0; jj<9; jj++) {
					System.out.print(map[ii][jj]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		return;
	}


}
