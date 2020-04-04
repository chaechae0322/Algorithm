package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 쿠팡3 {

	public static void main(String[] args) {
		int[][] delivery = {
				{1,5},
				{8,3},
				{4,2},
				{2,3},
				{3,1},
				{3,2},
				{4,2},
				{5,2},
				{4,1}
		};
		solution(3,delivery);

	}
	
	static class Node{
		int x,y,tip,sec;
		boolean[][] visited;

		public Node(int x, int y, int tip, int sec, boolean) {
			super();
			this.x = x;
			this.y = y;
			this.tip = tip;
			this.sec=sec;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", tip=" + tip + ", sec=" + sec + "]";
		}

		
		
	}
	
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static int solution(int r, int[][] delivery) {
		int answer=0;
		
		boolean[][][] visited=new boolean[r][r][4*64];
		/*for(int i=0; i<r; i++) {
			for(int j=0; j<r; j++) {
				Arrays.fill(visited[i][j], 20);
			}
		}*/
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, delivery[0][1],0));
		//visited[0][0][0]=delivery[0][1];
		visited[0][0]=true;
		visited[0][1]=true;
		visited[0][2]=true;
		visited[0][3]=true;
		
		int tx=0, ty=0;
		
		int cnt=0;
		while(!q.isEmpty()) {
			//cnt++;
			//if(cnt>10) break;
			
			Node tmp=q.poll();
			System.out.println(tmp.toString());
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				
				if(tx<0||tx>=r||ty<0||ty>=r) continue;
				if(tmp.visited[ty*r+tx][i]) continue; //이미지났을때
				if(tmp.sec+1>16) continue; //16보다 많은경우
				
				if(delivery[ty*r+tx][0]<tmp.sec+1) { //제한시간지났을경우 지나가기만
					System.out.println("제한시간지남");
					boolean[][] copy = new boolean[r*r][4];
					for(int j=0; j<r*r; j++) {
						copy[j]=tmp.visited[j].clone();
					}
					copy[ty*r+tx][i]=true;
					q.add(new Node(tx, ty, tmp.tip, tmp.sec+1, copy));
					
				}
				
				else { //제한시간안지났을때 안지나간곳
					boolean[][] copy = new boolean[r*r][4];
					for(int j=0; j<r*r; j++) {
						copy[j]=tmp.visited[j].clone();
					}
					copy[ty*r+tx][i]=true;
					q.add(new Node(tx, ty, tmp.tip+delivery[ty*r+tx][1], tmp.sec+1, copy));
					answer=Math.max(answer, tmp.tip+delivery[ty*r+tx][1]);
				}
				
				/*else if(visited[ty][tx][tmp.sec]<(tmp.tip)) { //제한시간안지났고 지나갈수있을때 지나갈수있고 다시 방문체크
					System.out.println("기존값 visited:"+visited[ty][tx][tmp.sec+1]);
					System.out.println("새로운 visited:"+(delivery[ty*r+tx][1]+tmp.tip));
					q.add(new Node(tx, ty, (delivery[ty*r+tx][1]+tmp.tip), tmp.sec+1));
					visited[ty][tx][tmp.sec+1]=(delivery[ty*r+tx][1]+tmp.tip);
					answer=Math.max(answer, tmp.tip+delivery[ty*r+tx][1]);
				}*/
				
				
			}
		}
		
		System.out.println(answer);
		
		
		return answer;
	}

}
