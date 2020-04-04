import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class LunchTime {
	static int n;
	static int [][] map;
	static class pos implements Comparable<pos>{
		int x, y;
		int t;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(pos o) {
			return (this.t>o.t)? 1: -1;
		}
	}
	static ArrayList<pos> plist;
	static pos st1;
	static pos st2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			plist=new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
					if(map[i][j]==1) {
						plist.add(new pos(j,i));
					}
					else if(map[i][j] > 1) {
						if(st1==null) {
							st1=new pos(j,i);
							st1.t=map[i][j];
						}
						else {
							st2=new pos(j,i);
							st2.t=map[i][j];
						}
					}
				}
			}// 입력
			int psize=plist.size();
			
			boolean[] visited;

			ans=1001;
			for(int i=0; i<psize; i++) {
				
				System.out.println("조합 구하기  :"+ i);
				visited=new boolean[psize];
				
				solve(0, i, visited); // A B

			}
			System.out.println("#"+t+" "+ans);
		}

	}
	static int ans;
	private static void solve(int depth, int m, boolean[] visited) {
		if(depth == m) {
			System.out.println("조합결과: "+ Arrays.toString(visited));
			count(visited);
			return;
		}
		
		
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				solve(depth+1, m, visited);
				visited[i]=false;
			}
			
		}
		
	}
	private static void count(boolean[] visited) {
		Queue<Integer> stair1=new LinkedList<>();
		Queue<Integer> stair2=new LinkedList<>();
		
		PriorityQueue<pos> pq1=new PriorityQueue<>();
		PriorityQueue<pos> pq2=new PriorityQueue<>();
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i])
				pq1.add(plist.get(i));
			else {
				pq2.add(plist.get(i));
			}
		}
		
		int taketime1=0, taketime2=0;
		
		// 1
//		System.out.println("첫번째 계단 시작");
		while(!pq1.isEmpty()) {
			pos tmp=pq1.poll();
			
			
			while(!stair1.isEmpty() && stair1.peek() < tmp.t) {
				stair1.poll();
			}
//			System.out.println("지금 계단에 "+ stair1.size()+ "명 있다.");
			if(stair1.size() < 3) {
				tmp.t+=(1+st1.t);
				stair1.add(tmp.t);
//				System.out.println("x:"+tmp.x+" y:"+tmp.y+" 사람이 나올때의 시간은 :" +tmp.t);
			}
			else { // 계단 꽉 찼을때
				tmp.t=stair1.peek()+1+st1.t;
				stair1.poll();
				stair1.add(tmp.t);
//				System.out.println("x:"+tmp.x+" y:"+tmp.y+" 사람이 나올때의 시간은 :" +tmp.t);
			}
			
			taketime1=tmp.t;
		}
		
		System.out.println("두 번째 계단 시작");
		while(!pq2.isEmpty()) {
			pos tmp=pq2.poll();
			

			while(!stair2.isEmpty() && stair2.peek() < tmp.t) {
				stair2.poll();
			}
//			System.out.println("지금 계단에 "+ stair2.size()+ "명 있다.");
			
			if(stair2.size() < 3) {
				tmp.t+=(1+st2.t);
				stair2.add(tmp.t);
//				System.out.println("x:"+tmp.x+" y:"+tmp.y+" 사람이 나올때의 시간은 :" +tmp.t);
			}
			else { // 계단 꽉 찼을때
				tmp.t=stair2.peek()+1+st2.t;
				stair2.poll();
				stair2.add(tmp.t);
//				System.out.println("x:"+tmp.x+" y:"+tmp.y+" 사람이 나올때의 시간은 :" +tmp.t);
			}
			
			taketime2=tmp.t;
		}
		
		taketime1=Math.max(taketime1, taketime2);
		ans=Math.min(ans, taketime1);
		
	}

}
