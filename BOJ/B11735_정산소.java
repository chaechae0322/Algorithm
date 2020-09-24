package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 수학
 * 등차수열 합
 */
public class B11735_정산소 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(token.nextToken()), q=Integer.parseInt(token.nextToken());
		long rsum=0, rcnt=0, csum=0, ccnt=0, t=0;
		boolean[][] check=new boolean[2][n+1]; // 0:R, 1:C
		for(int i=0; i<q; i++) {
			token = new StringTokenizer(br.readLine());
			char c=token.nextToken().charAt(0);
			int idx=Integer.parseInt(token.nextToken());
			if (c=='R') {
				if(check[0][idx]) {
					t=0;	
				}else {
					t=sum(idx, n+idx);
					t-=(csum+idx*ccnt);
					rcnt++;
					rsum+=idx;
					check[0][idx]=true;
				}
			}else {
				if(check[1][idx]) {
					t=0;
				}else {
					t=sum(idx, n+idx);
					t-=(rsum+idx*rcnt);
					ccnt++;
					csum+=idx;
					check[1][idx]=true;
				}
			}
			System.out.println(t);
		}
	}

	private static long sum(long start, long end) {
		return (end)*(end+1)/2 - (start)*(start+1)/2;
	}

}
