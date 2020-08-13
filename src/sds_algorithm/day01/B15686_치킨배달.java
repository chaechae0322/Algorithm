package sds_algorithm.day01;

import java.util.ArrayList;
import java.util.Scanner;

public class B15686_치킨배달 {

	static int N, M;
	static int[][] map;
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	static ArrayList<Pos> store;
	static ArrayList<Pos> house;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		//map=new int[R][C];
		store= new ArrayList<>();
		house= new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int tmp=sc.nextInt();
				if(tmp==2) {
					store.add(new Pos(j, i));
				}else if(tmp==1) {
					house.add(new Pos(j, i));
				}
			}
		}
		visited=new boolean[store.size()];
		ans=Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(ans);
	}
	static boolean[] visited;
	static int ans;
	private static void dfs(int pos, int cnt) {
		if(cnt==M) {
			int totalDistance=0;
			
			for(int i=0; i<house.size(); i++) {
				int x=house.get(i).x;
				int y=house.get(i).y;
				int min=Integer.MAX_VALUE;
				for(int j=0; j<store.size(); j++) {
					if(!visited[j]) continue;
					min=Math.min(min, Math.abs(x-store.get(j).x)+Math.abs(y-store.get(j).y));
				}
				totalDistance+=min;
			}
			ans=Math.min(ans, totalDistance);
			return;
		}
		if(pos==store.size()) return;
		visited[pos]=true;
		dfs(pos+1, cnt+1);
		visited[pos]=false;
		dfs(pos+1, cnt);
	}

}
