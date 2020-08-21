package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15961_RollingSushi {
	static int[] dishes;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(token.nextToken());
		int d=Integer.parseInt(token.nextToken());
		int k=Integer.parseInt(token.nextToken());
		int c=Integer.parseInt(token.nextToken());
		dishes=new int[n];
		for(int i=0; i<n; i++) {
			dishes[i]=Integer.parseInt(br.readLine());
		}
		int[] cnt=new int[d+1];
		int localans=0;
		int ans=0;
		int idx=0;
		boolean cflag=false;
		for(idx=0; idx<k; idx++) {
			if(cnt[dishes[idx]]==0) localans++;
			cnt[dishes[idx]]++;
		}
		if(cnt[c]==0) {
			cflag=true;
		}
		if(!cflag) ans=Math.max(ans, localans);
		else ans=Math.max(ans, localans+1);
		
		while(idx<n+k) {
			cflag=false;
			if(idx>=n) {
				if(cnt[dishes[idx-n]]==0) localans++;
				cnt[dishes[idx-n]]++;
				
				if(cnt[dishes[idx-k]]-1==0) localans--;
				cnt[dishes[idx-k]]--;
				
				if(cnt[c]==0) {
					cflag=true;
					if(localans+1==k+1) {
						ans=localans+1;
						break;
					}
				}
			}else {
				if(cnt[dishes[idx]]==0) localans++;
				cnt[dishes[idx]]++;
				
				if(cnt[dishes[idx-k]]-1==0) localans--;
				cnt[dishes[idx-k]]--;
				
				if(cnt[c]==0) {
					cflag=true;
					if(localans+1==k+1) {
						ans=localans+1;
						break;
					}
				}
			}
			if(!cflag) ans=Math.max(ans, localans);
			else ans=Math.max(ans, localans+1);
			idx++;
		}
		System.out.println(ans);
	}

}
