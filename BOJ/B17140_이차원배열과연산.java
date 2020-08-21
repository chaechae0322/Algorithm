package BOJ;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B17140_이차원배열과연산 {
	static class Item implements Comparable<Item>{
		int su;
		int time;

		public Item(int su, int time) {
			super();
			this.su = su;
			this.time = time;
		}


		@Override
		public String toString() {
			return "Item [su=" + su + ", time=" + time + "]";
		}


		@Override
		public int compareTo(Item o) {
			if(o.time == this.time) return this.su-o.su;
			else return this.time - o.time;
		}
	}

	static int[][] map;
	static int r,c,k;
	static int row=3, col=3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map=new int[101][101];
		
		r=sc.nextInt(); c=sc.nextInt(); k=sc.nextInt();
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				map[i][j]=sc.nextInt();
		
		int turn=0;
		boolean flag = false;
		
		while(turn<101) {
			if(map[r-1][c-1]==k) {
				flag= true;
				break;
			}
			
			if(row>=col) { // R연산
				//System.out.println("R연산");
				rcalc();
			}else { // C연산
				//System.out.println("C연산");
				ccalc();
			}
			
			
			turn++;
			/*System.out.println("turn:"+turn);
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}*/
			
			
		}
		
		if(flag) System.out.println(turn);
		else System.out.println(-1);
	}
	private static void ccalc() {
		PriorityQueue<Item> q= new PriorityQueue<>();
		int[] check = new int[101];
		
		int nrow=0;
		int idx=0;
		int cnt=0;
		
		for(int j=0; j<col; j++) {
			//System.out.println("j:"+j);
			idx=0;
			cnt=0;
			Arrays.fill(check, 0);
			
			for(int i=0; i<row; i++) {
				if(map[i][j]!=0)
					check[map[i][j]]++;
			}
			
			for(int i=0; i<=100; i++) {
				if(check[i]!=0)
					q.add(new Item(i, check[i]));
			}
			nrow = Math.max(nrow, q.size()*2);
			
			//System.out.println("qsize:"+q.size());
			
			for(int i=0; i<101; i++)
				map[i][j]=0;
			
			while(!q.isEmpty()) {
				if(cnt==50) {
					//System.out.println("100??");
					nrow=100;
					while(!q.isEmpty()) q.poll();
					break;
				}
				Item tmp = q.poll();
				
				//System.out.println(tmp.toString());
				
				map[idx++][j]=tmp.su;
				map[idx++][j]=tmp.time;
				
				cnt++;
			}
		}
		
		//System.out.println("nrow:"+nrow);
		row = nrow;
		
	}
	private static void rcalc() {
		PriorityQueue<Item> q= new PriorityQueue<>();
		int[] check = new int[101];
		
		int ncol=0;
		int idx=0;
		int cnt=0;
		for(int i=0; i<row; i++) {
			//System.out.println("i:"+i);
			idx=0;
			cnt=0;
			Arrays.fill(check, 0);
			
			for(int j=0; j<col; j++) {
				if(map[i][j]!=0)
					check[map[i][j]]++;
			}
			
			for(int j=0; j<=100; j++) {
				if(check[j]!=0)
					q.add(new Item(j, check[j]));
			}
			ncol = Math.max(ncol, q.size()*2);
			
			Arrays.fill(map[i], 0);
			//System.out.println("qsize:"+q.size());
			while(!q.isEmpty()) {
				if(cnt==50) {
					//System.out.println("100??");
					ncol=100;
					while(!q.isEmpty()) q.poll();
					break;
				}
				Item tmp = q.poll();
				
				//System.out.println(tmp.toString());
				
				map[i][idx++]=tmp.su;
				map[i][idx++]=tmp.time;
				
				cnt++;
			}
		}
		
		//System.out.println("ncol:"+ncol);
		col = ncol;
		
	}

}
