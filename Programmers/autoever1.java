package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class autoever1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub [500, 1000, -300, 200, -400, 100, -100]
		int[] tmp = solution(new int[] {500, -500});
		System.out.println(Arrays.toString(tmp));
	}
	public static int[] solution(int[] deposit) {
		int[] answer= {};
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<deposit.length; i++) {
			if(deposit[i]>0) {
				st.add(deposit[i]);
			}else {
				int sum=0;
				while(!st.isEmpty()) {
					sum += st.pop();
					if(sum >= (-1)*deposit[i]) {
						sum += deposit[i];
						break;
					}
				}
				if(sum>0) {
					st.add(sum);
				}
			}
		}
		answer=new int[st.size()];
		int size=st.size()-1;
		while(!st.isEmpty()) {
			answer[size--]=st.pop();
		}
		return answer;
	}

}
