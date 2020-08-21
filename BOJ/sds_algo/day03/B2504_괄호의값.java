package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504_괄호의값 {
	//static char[] enco= { '\u0000', '(', ')', '[', ']'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Integer> st = new Stack<>();
		
		int cnt1=0, cnt2=0;
		int res=0;
		for(int i=0; i<input.length(); i++) {
			res=0;
			char tmp = input.charAt(i);
			if(tmp=='(') {
				st.add(-1);
				cnt1++;
			}else if(tmp=='[') {
				st.add(-3);
				cnt2++;
			}else if(tmp==')') {
				while(!st.isEmpty()) {
					int t = st.pop();
					if(t==-3) {
						System.out.println(0);
						return;
					}
					if(t==-1) {
						break;
					}else {
						res+=t;
					}
				}
				if(res!=0) {
					st.add(2*res);
				}else 
					st.add(2);
				cnt1--;
				
			}else if(tmp==']') {
				while(!st.isEmpty()) {
					int t = st.pop();
					if(t==-1) {
						System.out.println(0);
						return;
					}
					if(t==-3) {
						break;
					}else {
						res+=t;
					}
				}
				if(res!=0) {
					st.add(3*res);
				}else
					st.add(3);
				cnt2--;
			}
			
			if(cnt1<0 || cnt2<0) {
				System.out.println(0);
				return;
			}
		}
		
		if(cnt1!=0 || cnt2!=0) {
			System.out.println(0);
			return;
		}
		
		res=0;
		while(!st.isEmpty()) {
			res+=st.pop();
		}
		System.out.println(res);
		
	}

}
