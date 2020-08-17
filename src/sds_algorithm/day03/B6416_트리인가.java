package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B6416_트리인가 {
	static ArrayList<Integer>[] outg;
	static ArrayList<Integer>[] comeg;
	static boolean[] exist;
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int u=0, v=0, time=0;
		outg=new ArrayList[15];
		comeg=new ArrayList[15];
		exist=new boolean[15];
		loop : while(true) {
			token = new StringTokenizer(br.readLine());
			while(token.hasMoreTokens()) {
				u=Integer.parseInt(token.nextToken());
				v=Integer.parseInt(token.nextToken());
				
				if(v==-1 && v==-1) {
					break loop;
				}
				
				if(u!=0 && !exist[u]) {
					exist[u]=true;
					len++;
				}
				if(v!=0 && !exist[v]) {
					exist[v]=true;
					len++;
				}
				//System.out.print("("+u+" "+v+")");
				if(v==0 && v==0) {
					//System.out.println();
					int res = solve(++time);
					if(res==0) {
						System.out.println("Case "+time+" is not a tree.");
					}else {
						System.out.println("Case "+time+" is a tree.");
					}
					outg=new ArrayList[15];
					comeg=new ArrayList[15];
					exist=new boolean[15];
					len=0;
					break;
				}
				
				if(outg[u]==null||comeg[u]==null) {
					outg[u]=new ArrayList<>();
					comeg[u]=new ArrayList<>();
				}
				outg[u].add(v);
				if(comeg[v]==null||outg[v]==null) {
					outg[v]=new ArrayList<>();
					comeg[v]=new ArrayList<>();
				}
				comeg[v].add(u);
			}
			if(v==-1 && v==-1) {
				break;
			}
			
		}

	}
	private static int solve(int time) {
		for(int i=0; i<15; i++) {
			if(outg[i]!=null) {
				System.out.println("node:"+i);
				System.out.println(outg[i]);
			}
				
		}
		// 루트 노드가 존재하고 하나만 있는지
		int rootcnt=0;
		int rootidx=0;
		for(int i=1; i<15; i++) {
			if(exist[i]) {
				System.out.println("어디? i:"+i);
				if(comeg[i].size()==0) {
					rootcnt++;
					rootidx=i;
				}
				else if(comeg[i].size()>=2) { // 들어오는간선이 2개이상
					System.out.println("간선 2개");
					return 0;
				}
			}
		}
		if(rootcnt!=1) {
			System.out.println("루트 없어");
			if(len==0) return 1;
			return 0;
		}
		
		boolean[] visited=new boolean[15];
		visited[rootidx]=true;
		travers(rootidx, visited);
		
		
		for(int i=1; i<15; i++) {
			if(exist[i] && !visited[i]) {
				System.out.println("루트에서 갈수없숴");
				return  0;
			}
		}
		
		return 1;
	}
	private static void travers(int pos, boolean[] visited) {
		System.out.println("pos:"+pos+" visited:"+Arrays.toString(visited));

		for(int i=0; i<outg[pos].size(); i++) {
			int tmp=outg[pos].get(i);
			if(!visited[tmp]) {
				visited[tmp]=true;
				travers(tmp, visited);
				//visited[tmp]=false;
			}
		}
	}

}
