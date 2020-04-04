package programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2_¿£Áöºñ {
	static ArrayList<Integer>[] tree;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		int M=Integer.parseInt(token.nextToken());
		
		tree=new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<Integer>(); 
		}

		
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			//System.out.println(Integer.parseInt(token.nextToken()));
			tree[Integer.parseInt(token.nextToken())].add(i+1); 
		}
		
		int ans=0;
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int inchild=Integer.parseInt(token.nextToken());
			int outchild=Integer.parseInt(token.nextToken());
			//System.out.println(inchild+" "+outchild);
			
			int[] node=new int[N+1];
			
			boolean[] incheck= bfs(inchild);
			boolean[] outcheck= bfs(outchild);
			incheck[inchild]=false;
			outcheck[outchild]=false;
			//System.out.println(Arrays.toString(incheck));
			//System.out.println(Arrays.toString(outcheck));
			
			for(int j=1; j<=N; j++) {
				if(incheck[j]) {
					node[j]++;
				}
				if(outcheck[j]) {
					node[j]++;
				}
			}
			
			int cnt=0;
			for(int j=0; j<=N; j++) {
				if(node[j]==1) cnt++;
			}
			ans+=cnt;
			
			
		}
		System.out.println(ans);

	}

	private static boolean[] bfs(int inchild) {
		
		boolean[] visited=new boolean[N+1];
		visited[inchild]=true;
		Queue<Integer> q=new LinkedList<>();
		q.add(inchild);
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			//System.out.println("tmp: "+tmp);
			for(int i=0; i<tree[tmp].size(); i++) {
				if(!visited[tree[tmp].get(i)]) {
					visited[tree[tmp].get(i)]=true;
					q.add(tree[tmp].get(i));
				}
			}
		}
		
		return visited;
	}

}
