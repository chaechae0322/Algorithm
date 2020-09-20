package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 수식최대화 {

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		

	}
	static int op[][]= {{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}};
    public static long solution(String expression) {
    	long answer=0;
    	for(int i=0; i<op.length; i++) {
    		answer = solve(expression, op[i]);
    	}
        
        return answer;
    }
	private static int solve(String ex, int[] order) {
		String[] nums=ex.split("\\+|\\-|\\*");
		
		String opers=ex.replaceAll("[0-9]", " ");
		
		System.out.println(Arrays.toString(nums)+" "+opers);
		Queue<Integer> nq=new LinkedList<>();
		Queue<Character> opq=new LinkedList<>();
		nq.add(Integer.parseInt(nums[0]));
		int ni=1, oi=0;
		for(int i=0; i<nums.length; i++) {
			char tmp=opers.charAt(i);
			// oper
			if(!opq.isEmpty() && order[(tmp=='+'?0:tmp=='-'?1:2)] < opq.peek()) { // 지금 들어오는애 우선순위가 더 낮다 
				
			}
			
			// su
		}
		return 0;
	}


}
