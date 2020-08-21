package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17471_게리맨더링 {
	static int n;
	static int[] vote;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		vote=new int[n];
		graph=new int[n][n];
		
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			vote[i]=Integer.parseInt(token.nextToken());
		}
		
		int num=0,s=0,d=0;
		boolean iszero=false;
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			num=Integer.parseInt(token.nextToken());
			/*if(num==0) {
				iszero=true;
			}*/
			for(int j=0; j<num; j++) {
				d=Integer.parseInt(token.nextToken());
				graph[i][d-1]=1;
				graph[d-1][i]=1;
			}
		}//
		
		/*if(iszero) {
			System.out.println("-1");
			return;
		}*/
		
		ans=Integer.MAX_VALUE;
		boolean[] visited=null;
		for(int i=1; i<=n/2; i++) {
			
			visited=new boolean[n];
			
			combination(0,0,i,visited);
		}
		
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);
		

	}
	static int ans;
	private static void combination(int depth, int pos, int k, boolean[] visited) {
		if(depth==k) {
			
			if(check(visited)) {
				int ca=0, cb=0;
				for(int i=0; i<n; i++) {
					if(visited[i]) ca+=vote[i];
					else cb+=vote[i];
				}
				ans=Math.min(ans, Math.abs(ca-cb));
			}
		}
		
		for(int i=pos; i<n; i++) {
			if(!visited[i]) {
				visited[i]=true;
				combination(depth+1, i, k, visited);
				visited[i]=false;
			}
		}
		
	}
	private static boolean check(boolean[] visited) {
		ArrayList<Integer> A=new ArrayList<>();
		ArrayList<Integer> B=new ArrayList<>();
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) A.add(i);
			else B.add(i);
		}
			
		
		boolean[] visited2=new boolean[n];
		Stack<Integer> st=new Stack<>(); 
		
		st.add(A.get(0));
		visited2[st.peek()]=true;
		
		while(!st.isEmpty()) {
			int tmp=st.pop();
			
			for(int i=0; i<n; i++) {
				if(graph[tmp][i]==1 && !visited2[i] && A.contains(i)) {
					visited2[i]=true;
					st.add(i);
				}
			}
		}
		
		for(int i=0; i<A.size(); i++) {
			if(!visited2[A.get(i)])
				return false;
		}
		
		visited2=new boolean[n];
		st.clear(); 
		
		st.add(B.get(0));
		visited2[st.peek()]=true;
		
		while(!st.isEmpty()) {
			int tmp=st.pop();
			
			for(int i=0; i<n; i++) {
				if(graph[tmp][i]==1 && !visited2[i] && B.contains(i)) {
					visited2[i]=true;
					st.add(i);
				}
			}
		}
		
		for(int i=0; i<B.size(); i++) {
			if(!visited2[B.get(i)])
				return false;
		}
		
		return true;
	}

}