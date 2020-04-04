package programmers;

import java.util.Arrays;

public class 쿠팡2 {

	public static void main(String[] args) {
		solution(new int[] {1,2,3,2},2,2);

	}
	
	
	public static int solution(int arr[], int k, int t) {
		int answer=0;
		
		boolean[] visited=new boolean[arr.length];
		dfs(arr,0,0,0,k,t,visited);
		answer=ans;
		System.out.println(answer);
		return answer;
	}
	
	static int ans;
	public static void dfs(int[] arr, int idx, int cnt, int sum, int k, int t, boolean[] visited) {
		//System.out.println("idx:"+idx+" cnt:"+cnt+" sum:"+sum);
		//System.out.println(Arrays.toString(visited));
		
		/*if(cnt>=k) {
			System.out.println("cnt k");
			System.out.println(Arrays.toString(visited));
			
			ans++;
			//return;
		}*/
		if(idx==arr.length) {
			if(cnt<k) return;
			if(sum<=t) {
				ans++;
			}
			return;
		}
		
		if(sum+arr[idx]<=t) {
			visited[idx]=true;
			dfs(arr, idx+1, cnt+1, sum+arr[idx], k, t, visited);
		}
		visited[idx]=false;
		dfs(arr, idx+1, cnt, sum, k, t, visited);
	}

}
