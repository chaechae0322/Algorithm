package sds_algorithm.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3860_할로윈묘지 {
	static int[][] dist;
	static Node[][] map;
	static class Node{
		int val;
		boolean isMyo;
		int tx, ty, cost;
		
		@Override
		public String toString() {
			return "Node [val=" + val + ", isMyo=" + isMyo + ", tx=" + tx + ", ty=" + ty + ", cost="+cost+"]";
		}
		
	}
	static int W,H,G,E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		W=Integer.parseInt(token.nextToken()); H=Integer.parseInt(token.nextToken());
		G=Integer.parseInt(br.readLine());
		for(int i=0; i<G; i++) {
			token = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(token.nextToken()); int y=Integer.parseInt(token.nextToken());
			
		}

	}

}
