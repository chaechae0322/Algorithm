package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 길찾기게임 {

	public static void main(String[] args) {
		int[][] nodeinfo= {
				{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
		};
		solution(nodeinfo);

	}
	static class Node implements Comparable<Node>{
		int x, y, num;
		
		Node(){
			x=-1; y=-1;
		}

		Node(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", num=" + num + "]";
		}
		@Override
		public int compareTo(Node o) {
			if(this.y==o.y) {
				return this.x-o.y;
			}
			return o.y-this.y;
		}
		
	}
	static int g[][] ,n, answer[][], idx;
	static Node pos[], root;
    public static int[][] solution(int[][] nodeinfo) {
        //int[][] answer = {};
        n=nodeinfo.length;
        g=new int[n+1][2]; pos=new Node[n+1];
        for(int i=0; i<=n; i++) {
        	g[i][0]=-1; g[i][1]=-1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<nodeinfo.length; i++) {
        	pq.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        root=pq.poll();
        pos[root.num]=new Node(root.x, root.y, root.num);
        g[0][1]=root.num;
        while(!pq.isEmpty()) {
        	Node t=pq.poll();
        	maketree(t);
        }
        for(int i=0; i<=n; i++) System.out.println(i+": "+Arrays.toString(g[i]));
        
        answer=new int[2][n+1];
        preorder(root.num);
        System.out.println();
        idx=0;
        postorder(root.num);
        
        System.out.println(Arrays.toString(answer[0]));
        System.out.println(Arrays.toString(answer[1]));
        return answer;
    }
	private static void preorder(int v) {
		if(v==-1) return;
		visit(v, 0);
		preorder(g[v][0]);
		preorder(g[v][1]);
	}
	private static void visit(int v, int sel) {
		answer[sel][idx++]=v;
	}
	private static void postorder(int v) {
		if(v==-1) return;
		preorder(g[v][0]);
		preorder(g[v][1]);
		visit(v,1);
	}
	private static void maketree(Node t) {
		System.out.println(t.toString());
		int cu=root.num;
		while(true) {
			System.out.println(cu);
			if(pos[cu].x>t.x) {
				if(g[cu][0]==-1) {
					g[cu][0]=t.num;
					pos[t.num]=t;
					break;
				}
				cu=g[cu][0];
			}else {
				if(g[cu][1]==-1) {
					g[cu][1]=t.num;
					pos[t.num]=t;
					break;
				}
				cu=g[cu][1];
			}
		}
		
	}

}
