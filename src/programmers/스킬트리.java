package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리 {

	public static void main(String[] args) {

		solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});

	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		boolean[] check=new boolean[26];
		for(int i=0; i<skill.length(); i++) {
			check[skill.charAt(i)-'A']=true;
		}

		int idx=0;
		boolean flag=true;
		for(int i=0; i<skill_trees.length; i++) {
			String tmp = skill_trees[i];
			System.out.println("tmp:"+tmp);
			idx=0; flag=true;
			for(int j=0; j<tmp.length(); j++) {
				if(!check[tmp.charAt(j)-'A']) continue;
				
				if(skill.charAt(idx)!=tmp.charAt(j)) {
					flag=false;
					break;
				}
				else {
					idx++;
				}
			}
			if(flag) answer++;
		}
		System.out.println(answer);
		return answer;
	}

}
