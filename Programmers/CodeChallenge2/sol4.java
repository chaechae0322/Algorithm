package Programmers.CodeChallenge2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class sol4 {

	public static void main(String[] args) {
		System.out.println(solution("baby"));

	}	
    public static long solution(String s) {
        long answer = -1;
        map=new HashMap<>(); set=new HashSet<String>();
        answer = dfs(s);
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
        	String ss = iter.next();
            answer -= map.get(ss);
        }
        return answer;
    }
    static HashMap<String, Long> map;
    static HashSet<String> set;
	private static long dfs(String s) {
		
		if(s.length()==1) {
			return 0;
		}
		if(map.containsKey(s)) {
			if(s.length()==2 && (set.isEmpty()||!set.contains(s))) {
				set.add(s);
			}
			return map.get(s);
		}
		
		long res=0;
		res += dfs(s.substring(0,s.length()-1)) + dfs(s.substring(1,s.length()));
		if(s.charAt(0)!=s.charAt(s.length()-1)) {
			res+=s.length()-1;
		}
		
		map.put(s, res);
		return res;
	}
}
