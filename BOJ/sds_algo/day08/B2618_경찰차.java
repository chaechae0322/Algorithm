package BOJ.sds_algo.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B2618_경찰차 {
	static int N, W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		N=Integer.parseInt(br.readLine()); W=Integer.parseInt(br.readLine());
		for(int i=0; i<W; i++) {
			token = new StringTokenizer(br.readLine());
			int y=Integer.parseInt(token.nextToken());
			int x=Integer.parseInt(token.nextToken());
		}
	}

}
