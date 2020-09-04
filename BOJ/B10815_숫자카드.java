package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10815_숫자카드 {
	static int N,M,num[],in[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		N=Integer.parseInt(br.readLine());
		num=new int[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) num[i]=Integer.parseInt(token.nextToken());
		Arrays.sort(num);
		
		M=Integer.parseInt(br.readLine());
		in=new int[M];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			in[i]=Integer.parseInt(token.nextToken());
			sb.append(binary(in[i])); sb.append(" ");
		}
		
		bw.append(sb.toString());
		bw.flush(); bw.close(); br.close();
	}
	private static int binary(int x) {
		int left =0, right=N-1, mid=0;;
		
		while(left<=right) {
			mid=(left+right)/2;
			if(num[mid]==x) {
				return 1;
			}else if(num[mid]<x) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return 0;
	}

}
