package programmers;

import java.util.Arrays;

public class problem2_11¹ø°¡ {

	public static void main(String[] args) {
		int[][] money= {{2500,3},{700,5}};
		
		int len=0;
		for(int i=0; i<money.length; i++) {
			len+=money[i][1];
		}
		boolean[] visited = new boolean[len];
		int[] don = new int[len];
		len=0;
		for(int i=0; i<money.length; i++) {
			for(int j=0; j<money[i][1]; j++) {
				don[len]=money[i][0];
				len++;
			}
		}
		System.out.println(Arrays.toString(don));
		
		min=Integer.MAX_VALUE;
		dfs(0,visited,don);
		System.out.println(min);

	}
	static int first, second, min;
	private static void dfs(int idx, boolean[] visited, int[] don) {
		if(idx==visited.length) {
			first=0; second=0;
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) first+=don[i];
				else second+=don[i];
			}
			System.out.println("first:"+first+" second:"+second);
			min=Math.min(Math.abs(first-second), min);
			return;
		}
		
		visited[idx]=true;
		dfs(idx+1, visited, don);
		visited[idx]=false;
		dfs(idx+1, visited, don);
		
	}

}
