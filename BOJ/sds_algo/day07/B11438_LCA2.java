
package BOJ.sds_algo.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *  LCA with DP + distance infomation
 *  그냥 LCA로 하면 최악의 경우 O(N)
 *  DP로 하면 O(logN)
 */
public class B11438_LCA2 {
	static int N, M;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		//M=Integer.parseInt(token.nextToken());
		tree=new ArrayList[N+1];
		int p=0;
		while(Math.pow(2, p)<N) {
			p++;
		} 
		lca=new int[p+1][N+1];
		level=new int[N+1];
		for(int i=0; i<=N; i++) tree[i]=new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			tree[a].add(b); tree[b].add(a); // both direction
		}
		dfs(1, 0); // 현재 노드, 부모 노드  root=1 
		
		M=Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			System.out.println(find(a,b));
		}
	}
	private static int find(int a, int b) {
		if(level[a]<level[b]) {	
			int t=a; a=b; b=t;
		}
		// depth 맞추기 b가 더크게
		for(int i=lca.length-1; i>=0; i--) { // 반씩내려가다가
			if((1<<i)<=level[a]-level[b]) {
				//System.out.println(i);
				a=lca[i][a];
			}
		}
		if(b==a) return a;
		// 이제 나랑 depth 같아졌으니까 조상찾기
		int pos=0;
		for(int i=lca.length-1; i>=0; i--) {
			if(lca[i][a]!=lca[i][b]) {
				pos=i;
				a=lca[i][a]; b=lca[i][b];
			}
		}
		return lca[0][a];
	}
	static int[][] lca;
	static int[] level;
	private static void dfs(int cu, int pa) { // 나 노드, 부모노드
		for(int i=0; i<tree[cu].size(); i++) {
			int tmp = tree[cu].get(i); // 여기 노드에서 갈수있는것들
			if(tmp==pa) continue;
			level[tmp]=level[cu]+1;
			lca[0][tmp]=cu; // 내 자식의 첫번째 노드는 나 
			for(int j=1; j<lca.length; j++) {
				lca[j][tmp]=lca[j-1][lca[j-1][tmp]];
				if(lca[j][tmp]==0) break;
			}
			dfs(tmp, cu);
		}
		
	}

}
