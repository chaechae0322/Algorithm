package sds_algorithm.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11404_플로이드 {
	static int[][] map;
	static int N,M;
	static int INF = 10000000+1; // 최대경로보다 더 커야하되 오버플로우 되면 안돼지라~
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine()); M=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			Arrays.fill(map[i],  INF);
			map[i][i]=0;
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			map[a][b]=Math.min(map[a][b], c);
		}

		//fluid-warshell
		fluid();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]==INF) System.out.print(0+" "); 
				else System.out.print(map[i][j]+" "); 
			}
			System.out.println();
		}
	}
	private static void fluid() {
		for(int k=1; k<=N; k++) {//
			for(int x=1; x<=N; x++) {
				for(int y=1; y<=N; y++) {
					map[x][y]=Math.min(map[x][y], map[x][k]+map[k][y]);
				}
			}
			
		}
		
	}

}
