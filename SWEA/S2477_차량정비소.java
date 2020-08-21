
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2477_��������� {
	static class Node implements Comparable<Node>{
		int id, time, sel;
		int[] nums;

		public Node(int id, int time, int sel, int[] nums) {
			super();
			this.id = id;
			this.time = time;
			this.sel = sel;
			this.nums = nums;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", time=" + time + ", sel=" + sel + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}

	}
	static int N, M, K, A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			K=Integer.parseInt(token.nextToken());
			A=Integer.parseInt(token.nextToken())-1;
			B=Integer.parseInt(token.nextToken())-1;


			PriorityQueue<Node> man=new PriorityQueue<>();
			PriorityQueue<Node>[] n = new PriorityQueue[N];
			PriorityQueue<Node>[] m = new PriorityQueue[M];
			int[] ninfo=new int[N];
			int[] minfo=new int[M];
			token = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				n[i]=new PriorityQueue<>();
				ninfo[i]=Integer.parseInt(token.nextToken());
			}
			token=new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				m[i]=new PriorityQueue<>();
				minfo[i]=Integer.parseInt(token.nextToken());
			}
			token=new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				man.add(new Node(i+1, Integer.parseInt(token.nextToken()), 0, new int[] {0,0}));
			}


			int time=0; 
			Node tmp=null;
			int ans=0;
			boolean[] isdone=new boolean[K];
			boolean flag=true;
			for(int tt=0;tt<30;tt++) {
				//m poll
				for(int i=0; i<M; i++) {
					if(!m[i].isEmpty() && m[i].peek().time == time) {
						tmp=m[i].poll();
						tmp.nums[1]=i+1;
						isdone[tmp.id-1]=true;
						if(tmp.nums[0]==A && tmp.nums[1]==B) {
							ans+=tmp.id;
						}
					}
				}
				flag=true;
				for(int i=0; i<K; i++) {
					flag &= isdone[i];
				}
				if(flag) break;
				
				System.out.println("time:"+time+" flag:"+flag); 
				//n poll
				for(int i=0; i<N; i++) {
					if(!n[i].isEmpty() && n[i].peek().time == time) {
						tmp=n[i].poll();
						tmp.nums[0]=i+1;

						for(int j=0; j<M; j++) {
							if(m[i].size()==0) {
								tmp.time += minfo[j];
								m[i].add(tmp);
								break;
							}
						}
					}
				}

				//man poll
				for(int i=0; i<K; i++) {

					if(!man.isEmpty() &&man.peek().time <= time) {

						for(int j=0; j<N; j++) {
							if(n[j].size()==0) {
								tmp=man.poll();
								tmp.time += ninfo[j];
								n[j].add(tmp);
								break;
							}
						}
					}
				}


				time++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}
