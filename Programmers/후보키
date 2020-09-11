package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
 * 조합 + (Map/Set)
 * for문 + (Map/Set)으로 풀이가능
 * 비트필드 이용 
 */
public class 후보키 {

	public static void main(String[] args) {
		System.out.println(6&1);
		String[][] relation = {
				//{"100","ryan","music","2"},{"200","apeach","math","2"},
				//{"300","tube","computer","3"},{"400","con","computer","4"},
				//{"500","muzi","music","3"},{"600","apeach","music","2"}
				//{"1","2","3"},{"4","5","6"},{"7","8","9"}
				
				{"a","a","a"},{"a","b","d"},{"e","c","c"},{"a","c","c"}
		};
		System.out.println(solution(relation));

	}
	static ArrayList<Integer> key;
	static boolean[] visited;
	static int n;
	static String[][] rel;
    public static int solution(String[][] relation) {
        int answer = 0;
        n=relation[0].length; rel=relation;
        key=new ArrayList<>();
        visited=new boolean[n+1];
        sb=new StringBuilder();
        for(int i=1; i<=n; i++) {
        	Arrays.fill(visited, false);
        	combi(1,0,i);
        }
        answer=key.size();
        return answer;
    }
	private static void combi(int idx, int cnt, int limit) {
		if(cnt==limit) {
			if(check()) {
				int num=tonum();
				key.add(num);
			}
			return;
		}
		if(idx>n) return;
		visited[idx]=true;
		combi(idx+1, cnt+1, limit);
		visited[idx]=false;
		combi(idx+1, cnt, limit);
	}
	static StringBuilder sb;
	private static boolean check() {
		int num=tonum();
		boolean dup;
		for(int i=0; i<key.size(); i++) {
			int t=key.get(i);
			dup=true;
			for(int j=0; j<n; j++) {
				if((t&(1<<j))>0 && (num&(1<<j))==0) {
					dup=false; break;
				}
			}
			if(dup) return false;
		}
		HashMap<String, Integer> map=new HashMap<>();
		
		for(int i=0; i<rel.length; i++) {
			sb.delete(0, sb.length());
			for(int j=1; j<=n; j++) {
				if(visited[j]) {
					sb.append(rel[i][j-1]);
				}
			}
			String k=sb.toString();
			if(map.containsKey(k)) return false;
			else {
				map.put(k, 1);
			}
		}
		return true;
	}
	
	public static int tonum() {
		int num=0;
		for(int i=n; i>0; i--) {
			if(visited[i]) {
				num+=Math.pow(2, n-i);
			}
		}
		return num;
	}

}
