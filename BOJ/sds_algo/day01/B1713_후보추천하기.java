package BOJ.sds_algo.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1713_후보추천하기 {
	static class Node implements Comparable<Node>{
		int num;
		int cnt;
		int time;
		public Node(int num, int cnt, int time) {
			super();
			this.num = num;
			this.cnt = cnt;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", cnt=" + cnt + ", time=" + time + "]";
		}
		@Override
		public int compareTo(Node o) {
			if(this.cnt==o.cnt) {
				return this.time-o.time;
			}else
				return this.cnt-o.cnt;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();	 int K=sc.nextInt();
		PriorityQueue<Node> pq=new PriorityQueue<>();
		
		boolean[] check=new boolean[101];
		for(int i=0; i<K; i++) {
			int num=sc.nextInt();
			//cnt[num]++;
			
			if(check[num]) { // 이미 사진틀에 있다
				System.out.println("exist");
				Iterator<Node> it=pq.iterator();
				System.out.println(it);
				while(it.hasNext()) {
					
					Node tmp = it.next();
					System.out.println(tmp.toString());
					if(tmp.num==num) {
						tmp.cnt++;
						break;
					}
				}
			}else { // 없다
				
				if(pq.size()==N) { // 자리없다
					System.out.println("full");
					Node tmp=pq.poll();
					System.out.println(tmp.toString());
					check[tmp.num]=false;
				}
				pq.add(new Node(num, 1, i));
				check[num]=true;
			}
			
			System.out.println(pq);
		}
		int[] res=new int[N];
		int idx=0;
		int size=pq.size();
		for(int i=0; i<size; i++) {
			res[i]=pq.poll().num;
		}
		Arrays.sort(res);
		for(int r:res)
			System.out.print(r+" ");
	}

}
