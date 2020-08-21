package Programmers;

import java.util.Arrays;

public class 썸머코딩1 {

	public static void main(String[] args) {
		System.out.println(solution(2015));

	}
	
	public static int solution(int p) {
        int answer = 0;
        
        boolean[] num = new boolean[10];
        for(int i=p+1; ; i++) {
        	num[(i%10000)/1000] = true;
        	num[(i%1000)/100] = true;
        	num[(i%100)/10] = true;
        	num[i%10] = true;
        	
        	int cnt=0;
        	for(int j=0; j<10; j++) {
        		if(num[j]) cnt++;
        	}
        	if(cnt==4) {
        		answer = i;
        		break;
        	}
        	Arrays.fill(num, false);
        }

        return answer;
    }

}
