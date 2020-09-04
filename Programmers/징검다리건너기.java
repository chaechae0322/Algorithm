package Programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/*
 * Deque
 */
public class 징검다리건너기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
		System.out.println(solution(new int[] {5, 10, 22, 1, 223, 35, 446, 122 ,30 ,5, 67, 99}, 3));
	}
	public static int solution(int[] stones, int k) {
        int answer = 0;
        Deque<Integer> dq=new LinkedList<>();

        for(int i=0; i<stones.length; i++) {
        	if(!dq.isEmpty() && i>=dq.peekFirst()+k) dq.pollFirst();
        	while(!dq.isEmpty() && stones[dq.peekLast()]<stones[i]) dq.pollLast();
        	dq.add(i);
        	if(i<k) answer=Math.max(answer, stones[i]);
        	else {
        		answer=Math.min(stones[dq.peekFirst()], answer);
        	}
        }
        return answer;
    }
}
