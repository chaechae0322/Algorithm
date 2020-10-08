package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1119_그래프 {
	static int n, p[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p=new int[n];
		boolean[] visited=new boolean[n];
		for(int i=0; i<n; i++) p[i]=i;
		
		int edge=0, over=0;
		visited[0]=true; 
		for(int i=0; i<n; i++) {
			String t=br.readLine();
			for(int j=i; j<n; j++) {
				if(t.charAt(j)=='Y') {
					if(!visited[j]) {
						visited[j]=true;
						edge++;
						//union find
						union(i,j);
					}else {
						over++;
					}
				}
			}
		}
		System.out.println(Arrays.toString(p));
		if(edge+over<n-1) {
			System.out.println(-1);
		}else {
			int group=1;
			int pre=find(0);
			for(int i=1; i<n; i++) {
				if(pre!=find(i)) {
					group++;
					pre=find(i);
				}
			}
			if(group-1<=over) {
				System.out.println((group-1));
			}else {
				System.out.println(-1);
			}
		}
	}
	private static void union(int x, int y) {
		if(x>y) {
			int t=x;
			x=y;
			y=t;
		}
		
		x=find(x);
		y=find(y);
		p[y]=x;
	}
	private static int find(int x) {
		if(x==p[x]) return x;
		return p[x]=find(p[x]);
	}

}
