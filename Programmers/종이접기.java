package Programmers;

import java.util.Arrays;

public class 종이접기 {

	public static void main(String[] args) {
		solution(3);

	}

	public static int[] solution(int n) {
		int[] answer = {};
		int len=(int) Math.pow(2, n); //8
		int[] res=new int[len];
		boolean[] visited=new boolean[len];
		int div=2;
		
		int flag=0; //0: v, 1: ^
		for(int i=1; i<=n; i++) {
			
			int interval=len/div; //4->2->1
			int idx=interval;
			flag=0;
			
			while(idx<len) {
				
				if(visited[idx]) {
					idx+=interval;
					continue;
				}
				
				if(flag==0) {
					visited[idx]=true;
					res[idx]=0;
					flag=1;
				}
				else {
					visited[idx]=true;
					res[idx]=1;
					flag=0;
				}
				idx+=interval;
			}
			div*=2; //2->4->8
		}
		
		answer=new int[len-1]; //8..?
		for(int i=1; i<len; i++)
			answer[i-1]=res[i];
		return answer;
	}

}
