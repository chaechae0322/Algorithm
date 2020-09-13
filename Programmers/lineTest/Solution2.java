package Programmers.lineTest;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

	public static void main(String[] args) {
		int[] ball= {11, 2, 9, 13, 1000000}, order= {9, 2, 13, 1000000, 11};
		solution(ball, order);

	}
    public static int[] solution(int[] ball, int[] order) {
        int[] answer = new int[order.length];
        Deque<Integer> dq=new LinkedList<>();
        boolean[] wait=new boolean[1000001];
        for(int i=0; i<ball.length; i++) {
        	dq.add(ball[i]);
        }
        System.out.println(dq);
        int idx=0, t=0;
        for(int i=0; i<order.length; i++) {
        	if(dq.peekFirst()==order[i]) {
        		
        		answer[idx++]=dq.pollFirst();
        		while(!dq.isEmpty() && wait[dq.peekFirst()]) {
        			t=dq.pollFirst();
        			
            		answer[idx++]=t;
            		wait[t]=false;
            		
            	}
        	}else if(dq.peekLast()==order[i]) {
        		
        		answer[idx++]=dq.pollLast();
        		while(!dq.isEmpty() && wait[dq.peekLast()]) {
        			t=dq.pollLast();
            		answer[idx++]=t;
            		wait[t]=false;
            	}
        	}else {
        		
        		wait[order[i]]=true;
        	}
        	
        	
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
