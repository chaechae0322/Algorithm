package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 이분 탐색  upperBound
 * (누적합으로도 가능 - 더 빠름)
 */
public class B3020_개똥벌레 {
	static int N, H, down [], up [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken()); H=Integer.parseInt(token.nextToken());
		down = new int[N/2]; up=new int[N/2];
		for(int i=0; i<N/2; i++) {
			down[i]=Integer.parseInt(br.readLine()); 
			up[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(down); Arrays.sort(up);
		
		int res=0, ans=300000, cnt=0;
		for(int i=1; i<=H; i++) {
			res = upperbound(i-1, 0)+upperbound(H-i, 1);
			if(res<ans) {
				ans=res; cnt=1;
			}else if(res==ans) {
				cnt+=1;
			}
		}
		
		System.out.println(ans+" "+cnt);
		
	}
	private static int upperbound(int x, int sel) {
		System.out.println(x);
		int left=0, right=N/2, mid=0;
		while(left<right) {
			
			mid=(left+right)/2;
			int t = (sel==0?down[mid]:up[mid]);
			if(t<=x) {
				left=mid+1;
			}
			else {
				right=mid;
			}
		}
		return N/2-right;
	}

}
