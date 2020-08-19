package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		int p=1;
		while(p<N) {
			p*=2;
		}
		leafSize = p;
		indextree= new int[leafSize*4];
		
		
		int a, b, c=0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			a=Integer.parseInt(token.nextToken());
			if(a==1) {
				// 꺼내기
			}else {
				// 넣기
				b=Integer.parseInt(token.nextToken());
				c=Integer.parseInt(token.nextToken());
				insert(1, 1, leafSize, b, c);
				// 꺼내기 
			}
		}
	}
	private static void insert(int node, int left, int right, int index, int diff) {
		
		
	}

}
