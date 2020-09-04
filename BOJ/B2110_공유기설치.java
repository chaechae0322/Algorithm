package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2110_공유기설치 {
	static int N,C, home[];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in=br.readLine().split(" ");
		N=Integer.parseInt(in[0]); C=Integer.parseInt(in[1]);
		home=new int[N]; visited=new boolean[N];
		for(int i=0; i<N; i++) {
			home[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		System.out.println(Arrays.toString(home));
		visited[0]=true; visited[N-1]=true;
		if(C==2) {
			System.out.println(home[N-1]-home[0]);
			return;
		}
		int l=0, r=N-1, mid=0;
		ans=2000000;
		System.out.println(l+" "+r);
		for(int i=C-1; i>1; i--) {
			int v=(home[r]-home[l])/i;
			System.out.println("to find:"+(home[l]+v));
			mid=binary(l, r, home[l]+v);
			ans=Math.min(Math.min(home[r]-home[mid], home[mid]-home[l]), ans);
			l=mid;
			System.out.println("home["+mid+"]= "+home[mid]);
			System.out.println("new "+l+" "+r);
			
		}
		System.out.println(ans);
	}
	static int ans;
	private static int binary(int l, int r, int x) {
		int mid = 0;
		while(l<=r) {
			mid=(int)((long)(l+r)/2);
			if(home[mid]==x) {
				return mid;
			}else if(home[mid]>x) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		if(visited[r]) return l;
		if(x-home[r]<home[l]-x) {
			return r;
		}else {
			return l;
		}
	}

}
