package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * 펠린드롬
 * Memoization
 */
public class B10962_팰린드롬 {
	static int n, arr[]; static boolean[][] mem; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		n=Integer.parseInt(br.readLine());
		arr=new int[n]; mem=new boolean[n+1][n+1];
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		int m=Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			token = new StringTokenizer(br.readLine());
			int s=Integer.parseInt(token.nextToken())-1;
			int e=Integer.parseInt(token.nextToken())-1;
			bw.append(pelin(s,e));
			
		}
		bw.flush();
		bw.close();
	}
	private static String pelin(int s, int e) {
		int l=s, r=e;
		while(l<r) {
			if(mem[l][r]) return "1\n";
			if(arr[l]!=arr[r]) return "0\n";
			l++; r--;
		}
		mem[s][e]=true;
		return "1\n";
	}

}
