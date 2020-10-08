package Programmers.CodeChallenge2;

import java.util.Stack;

public class sol1 {

	public static void main(String[] args) {
		System.out.println(solution(125));

	}
    public static int solution(int n) {
        int answer = 0;
        long p=1;
        while(p<=n) p*=3;
        Stack<Integer> st = new Stack<>();
        if(p>n) p/=3;
        while(true) {
        	for(int i=2; i>=0; i--) {
        		if(i*p<=n) {
        			st.add(i);
        			n-=i*p;
        			break;
        		}
        	}
        	if(p==1) break;
        	p/=3;
        }
        p= (long) Math.pow(3, st.size()-1);
        while(!st.isEmpty()) {
        	answer += st.pop()*p;
        	p/=3;
        }
        return answer;
    }

}
