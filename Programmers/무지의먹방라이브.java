package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * 구현
 * 정렬후 작은수부터 고려
 */
public class 무지의먹방라이브 {

	public static void main(String[] args) {
		int[] food_times= {10,3,9,3};
		//int[] food_times= {3,1,2};
		//int[] food_times= {3,2,1,1,1,1,9};
		//for(int k=0; k<=18; k++) {
			System.out.println(solution(food_times, 20));
		//}

	}
	static class Node{
		int idx, time;

		Node(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", time=" + time + "]";
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}
		
	}
	
    public static int solution(int[] food_times, long k) {
        int answer = 0, n=food_times.length;
        boolean [] del=new boolean[n+1];
        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(Node::getTime));	
        for(int i=0; i<n; i++) {
        	pq.add(new Node(i+1, food_times[i]));
        }
        
        long turn=0, size=0;
        loop: while(!pq.isEmpty()) {
        	size=pq.size();
        	Node t=pq.peek();
        	if(k/size>=(t.time-turn)) { // 초과
        		k-=(t.time-turn)*size;
        		while(!pq.isEmpty() && t.time==pq.peek().time) {
        			del[pq.poll().idx]=true;
        		}
        		if(pq.size()==0) { // 다빠져
        			return -1;
        		}
        		turn+=(t.time-turn);
        	}else {
        		k%=size; int cnt=0;
        		for(int i=1; i<=n ;i++) {
        			if(!del[i]) {
        				if(cnt==k) {
        					answer=i; break loop;
        				}
        				cnt++;
        			}
        		}
        		answer=-1;
        	}
        }
        return answer;
    }

}
