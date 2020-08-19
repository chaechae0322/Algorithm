package sds_algorithm.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 *  LCA with DP + distance infomation
 */
public class B3176_도로네트워크 {
	static int[][][] lcad;
	static int[] level;
	static int N,K;
	static ArrayList<Node>[] glist;
	static class Node{
		int dst, dist;

		public Node(int dst, int dist) {
			super();
			this.dst = dst;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [dst=" + dst + ", dist=" + dist + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		N=Integer.parseInt(br.readLine());
		glist=new ArrayList[N+1];
		level=new int[N+1];
		lcad=new int[18][N+1][3]; // k, v, 0: parent, 1: min, 2: max distance
		for(int i=0; i<18; i++) {
			for(int j=0; j<=1; j++) {
				lcad[i][j][1]=Integer.MAX_VALUE;
			}
		}
		for(int i=0; i<=N; i++) glist[i]=new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			glist[a].add(new Node(b, c));
			glist[b].add(new Node(a, c));
		}
		// root 아무데나 가능 .
		dfs(1,0);
		
		
		K=Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int[] t=find(a,b);
			bw.write(t[0]+" "+t[1]+"\n");
		}
		bw.flush();
        bw.close();
        br.close();
	}
	private static int[] find(int a, int b) {
		if(level[b]>level[a]) {
			int t=a; a=b; b=t;
		}
		int min=Integer.MAX_VALUE, max=0;
		for(int i=lcad.length-1; i>=0; i--) {
			if((1<<i)<=level[a]-level[b]) {
				min=Math.min(min, lcad[i][a][1]);
				max=Math.max(max, lcad[i][a][2]);
				a=lcad[i][a][0];
			}
		}
		if(a==b) {
			return new int[] {min, max};
		}
		
		// 최소조상찾기
		for(int i=lcad.length-1; i>=0; i--) {
			if(lcad[i][a][0]!=lcad[i][b][0]) {
				min=Math.min(min, Math.min(lcad[i][a][1], lcad[i][b][1]));
				max=Math.max(max, Math.max(lcad[i][a][2], lcad[i][b][2]));
				a=lcad[i][a][0]; b=lcad[i][b][0];
			}
		}
		min=Math.min(min, Math.min(lcad[0][a][1], lcad[0][b][1]));
		max=Math.max(max, Math.max(lcad[0][a][2], lcad[0][b][2]));
		return new int[] {min, max};
	}
	private static void dfs(int cu, int pa) {
		for(int i=0; i<glist[cu].size(); i++) {
			Node tmp = glist[cu].get(i);
			if(tmp.dst == pa) continue;
			
			level[tmp.dst]=level[cu]+1; // depth 정해주기
			lcad[0][tmp.dst][0] = cu; // 내 첫번째자식의 2^0번위의 조상은 나지
			lcad[0][tmp.dst][1] = tmp.dist; // 도로하나 중에 min은 그거
			lcad[0][tmp.dst][2] = tmp.dist; // 도로하나 중에 max는 그거
			for(int j=1; j<lcad.length; j++) {
				
				lcad[j][tmp.dst][1]=Math.min(lcad[j-1][tmp.dst][1], lcad[j-1][lcad[j-1][tmp.dst][0]][1]);
				lcad[j][tmp.dst][2]=Math.max(lcad[j-1][tmp.dst][2], lcad[j-1][lcad[j-1][tmp.dst][0]][2]);
				lcad[j][tmp.dst][0]=lcad[j-1][lcad[j-1][tmp.dst][0]][0];
				
				if(lcad[j][tmp.dst][0]==0) break;
			}
			
			dfs(tmp.dst, cu);

		}
		
	}

}
