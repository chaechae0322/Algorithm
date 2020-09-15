package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;
/*
 * 투 포인터
 */
public class B15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n, d, k, c, arr[];
		n=Integer.parseInt(token.nextToken());
		d=Integer.parseInt(token.nextToken());
		k=Integer.parseInt(token.nextToken());
		c=Integer.parseInt(token.nextToken());
		arr=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int cnt=0, ans=0;
		int[] check=new int[d+1];
		
		for(int i=0; i<k; i++) {
			if(check[arr[i]]==0) {
				check[arr[i]]=1;
				cnt++;
			}else {
				check[arr[i]]++;
			}
		}
		if(check[c]==0) {
			ans=Math.max(ans, cnt+1);
		}else {
			ans=Math.max(ans, cnt);
		}
		ans=Math.max(ans, cnt);
		for(int i=k; i<n+k; i++) {
			check[arr[i-k]]-=1;
			if(check[arr[i-k]]==0) {
				cnt--;
			}
			check[arr[i%n]]++;
			if(check[arr[i%n]]==1) {
				cnt++;
			}
			if(check[c]==0) {
				ans=Math.max(ans, cnt+1);
			}else {
				ans=Math.max(ans, cnt);
			}
		}
		System.out.println(ans);
	}


}
