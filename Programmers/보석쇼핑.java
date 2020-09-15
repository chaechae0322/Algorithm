package Programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
/*
 *  슬라이딩 윈도우 (Deque)
 *  (투포인터)
 */
public class 보석쇼핑 {

	public static void main(String[] args) {
		solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"});

	}
	static class Node{
		String b;
		int idx;
		public Node(String b, int idx) {
			super();
			this.b = b;
			this.idx = idx;
		}
		@Override
		public String toString() {
			return "Node [b=" + b + ", idx=" + idx + "]";
		}
	}
    public static int[] solution(String[] gems) {
        int[] answer = {};
        HashMap<String, Integer> m=new HashMap<>();
        int bosuck=0;
        for(int i=0; i<gems.length; i++) {
        	if(!m.containsKey(gems[i])) {
        		m.put(gems[i], bosuck);
        		bosuck++;
        	}
        }
        m.clear();
        Deque<Node> dq=new LinkedList<Node>();
        int st=0, ed=Integer.MAX_VALUE;
        for(int i=1; i<=gems.length; i++) {
        	if(!m.containsKey(gems[i-1])) {
        		m.put(gems[i-1], 1);
        	}else {
        		int t=m.get(gems[i-1]);
        		m.put(gems[i-1], t+1);
        	}
        	dq.add(new Node(gems[i-1],i));
        	while(!dq.isEmpty() && m.get(dq.peekFirst().b)>1) {
        		int t=m.get(dq.peekFirst().b);
        		m.put(dq.peekFirst().b, t-1);
        		dq.pollFirst();
        	}
        	
        	if(m.size()>=bosuck) {
        		if(dq.peekLast().idx-dq.peekFirst().idx < ed-st) {
        			st=dq.peekFirst().idx; ed=dq.peekLast().idx;
        		}
        	}
        	
        }
        
        answer=new int[2];
        answer[0]=st; answer[1]=ed;
        return answer;
    }

}
