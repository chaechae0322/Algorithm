package Programmers;

import java.util.Arrays;

public class Line3 {

	public static void main(String[] args) {
		String road = "001100";
		int n= 6;
		char[] roadchar = road.toCharArray();
		
		dfs(0 ,roadchar, 0, n);
		System.out.println(ans);
		
	}

	static int ans;
	private static void dfs(int idx, char[] roadchar, int cnt, int n) {
		if(idx<roadchar.length && roadchar[idx]=='1') {

			dfs(idx+1, roadchar, cnt, n);
			return;
		}
		

		System.out.println("idx:"+idx+" cnt:"+cnt);
		System.out.println(Arrays.toString(roadchar));
		
		
		if(cnt>n) return;
		
		if(idx==roadchar.length) {
			System.out.println(Arrays.toString(roadchar));
			int count=0;
			for(int i=0; i<roadchar.length; i++) {
				if(roadchar[i]=='1') {
					count++;
					ans=Math.max(count, ans);
				}
				else {
					count=0;
				}
			}
			
			return;
		}
		
		roadchar[idx]='1';
		dfs(idx+1, roadchar, cnt+1, n);
		roadchar[idx]='0';
		dfs(idx+1, roadchar, cnt, n);
		
	}

}
