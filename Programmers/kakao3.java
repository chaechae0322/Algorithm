package Programmers;

import java.util.HashMap;

public class kakao3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(solution(gems));
	}
	
	public static int[] solution(String[] gems) {
		int[] answer = {};
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<gems.length; i++) {
			if(!map.containsKey(gems[i])) {
				map.put(gems[i],1);
			}
		}
		
		for (int i=0; i<gems.length; i++) {
			
		}
		
		return answer;
	}

}
