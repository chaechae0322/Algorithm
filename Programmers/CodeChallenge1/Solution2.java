package Programmers.CodeChallenge1;

import java.util.Arrays;
/*
 * 시뮬레이션
 */
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(7)));

	}
    public static int[] solution(int n) {
    	int len = (n+1)*(n/2);
    	if(n%2==1) len+=(n+1)/2;
        int[] answer = new int[len];
        int cnt=1, idx=0;
        
        int loop=2, loop2=n, off=1, offloop=1;
        l: while(cnt<=len) {
        	off=offloop;
        	while(true) {
        		if(idx>=len ||answer[idx]!=0) break;
        		answer[idx]=cnt++;
        		idx+=off;
        		off++;
        		if(cnt>len) break l;
        	}
        	idx-=(off-1);
        	off=1;
        	idx+=1;
        	while(true) {
        		if(idx>=len ||answer[idx]!=0) break;
        		answer[idx]=cnt++;
        		idx+=1;
        		if(cnt>len) break l;
        	}
        	if(idx>=len) idx=len-1;
        	else idx-=1;
        	off=loop2;
        	idx-=off;
        	off-=1;
        	while(true) {
        		if(idx<0 || answer[idx]!=0) break;
        		answer[idx]=cnt++;
        		idx-=off;
        		off--;
        		if(cnt>len) break l;
        	
        	}
        	idx+=(off+1);
        	idx+=loop;
        	loop+=2;
        	loop2-=1;
        	offloop+=2;
        }
        return answer;
    }

}
