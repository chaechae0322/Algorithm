package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * binary search
 */
public class B2110_공유기설치 {
	static int N,C,h[],mem[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in=br.readLine().split(" ");
		N=Integer.parseInt(in[0]); C=Integer.parseInt(in[1]);
		h=new int[N]; mem=new int[C];
		int min=Integer.MAX_VALUE, max=0;
		for(int i=0; i<N; i++) {
			h[i]=Integer.parseInt(br.readLine());
			min=Math.min(min, h[i]); max=Math.max(max, h[i]);
		}
		Arrays.sort(h);
		mem[0]=h[0];
		binary(1, max-min+1);
		System.out.println(ans);
	}
	static int ans;
	private static void binary(int l, int r) {
		if(l>=r) return;
		
		int mid=(l+r)/2;
		int ref=mem[0]+mid, cnt=1, tmp=Integer.MAX_VALUE;
		for(int i=1; i<N; i++) {
			if(h[i]>=ref) {
				tmp=Math.min(h[i]-mem[cnt-1], tmp);
				mem[cnt++]=h[i];
				ref=h[i]+mid;
				if(cnt==C) break;
			}
		}
		
		if(cnt>=C) {
			ans=Math.max(tmp, ans);
			l=mid+1;
		}else {
			r=mid;
		}
		binary(l,r);
	}

}
