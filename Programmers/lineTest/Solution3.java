package Programmers.lineTest;

import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution(1000));
	}
	static int[] mem;
    public static int[] solution(int n) {
        int[] answer = new int[2];
        mem=new int[10];
        Arrays.fill(mem, 11);
        dfs(0,n);
        answer[0]=ans; answer[1]=ansn;
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    static int ans=Integer.MAX_VALUE, ansn;
	private static void dfs(int cnt, int n) {
		
		if(n<10) {
			if(ans>cnt) {
				ans=cnt;
				ansn=n;
			}
			return;
		}
		
		String num=Integer.toString(n);
		if(mem[cnt]<num.length()) return;
		
		if(mem[cnt]>num.length()) {
			mem[cnt]=num.length();
		}
		
		String one="", two="";
		for(int i=0; i<num.length()-1; i++) {
			one=num.substring(0,i+1);
			two=num.substring(i+1, num.length());
			if(two.length()>1 && two.charAt(0)=='0') {
				continue;
			}
			dfs(cnt+1, Integer.parseInt(one)+Integer.parseInt(two));
		}
		
	}

}
