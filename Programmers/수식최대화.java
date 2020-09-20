package Programmers;

import java.util.Stack;
/*
 * Stack 계산기
 */
public class 수식최대화 {

	public static void main(String[] args) {
		System.out.println(solution("50*6"));
	}
	static int op[][]= {{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}};
	public static long solution(String expression) {
		long answer=0;
		for(int i=0; i<op.length; i++) {
			long res = solve(expression, op[i]);
			answer=Math.max(answer, Math.abs(res));
		}

		return answer;
	}

	private static long solve(String ex, int[] order) {
		String[] nums=ex.split("\\+|\\-|\\*");
		String opers=ex.replaceAll("[0-9]", "");

		Stack<Long> nq=new Stack<>();
		Stack<Integer> opq=new Stack<>();
		nq.add(Long.parseLong(nums[0]));
		int oi=0;
		for(int i=1; i<nums.length; i++) {
			char tmp=opers.charAt(oi);
			// oper
			while(!opq.isEmpty() && order[(tmp=='+'?0:tmp=='-'?1:2)] <= order[opq.peek()]) { // 들어오는애 우선순위가 같거나 낮다 
				long s1=nq.pop(), s2=nq.pop();
				int tmpo=opq.pop();
				if(tmpo==0) {
					nq.add(s1+s2);
				}else if(tmpo==1) {
					nq.add(s2-s1);
				}else {
					nq.add(s1*s2);
				}
			}
			opq.add((tmp=='+'?0:tmp=='-'?1:2));
			nq.add(Long.parseLong(nums[i]));
			oi++;

		}
		while(!opq.isEmpty()) {
			long s1=nq.pop(), s2=nq.pop();
			int tmpo=opq.pop();
			if(tmpo==0) {
				nq.add(s1+s2);
			}else if(tmpo==1) {
				nq.add(s2-s1);
			}else {
				nq.add(s1*s2);
			}
		}
		return nq.peek();
	}


}
