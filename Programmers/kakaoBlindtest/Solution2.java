package Programmers.kakaoBlindtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution2 {

	public static void main(String[] args) {
		//String[] o= {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] o= {"XYZ", "XWY", "WXA"};
		int[] c= {2,3,4};
		solution(o,c);
	}
	static boolean[] al;
	static ArrayList<Node> list;
	static class Node{
		String s;
		int count;
		public Node(String s, int count) {
			super();
			this.s = s;
			this.count = count;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "Node [s=" + s + ", count=" + count + "]";
		}

	}
	static String[] or;
	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		ArrayList<String> ans=new ArrayList<String>();
		al=new boolean[26]; or=orders;
		for(int i=0; i<orders.length; i++) {
			String t=orders[i];
			for(int j=0; j<t.length(); j++) {
				al[t.charAt(j)-'A']=true;
			}
		}
		System.out.println(Arrays.toString(al));
		list=new ArrayList<>(); visited=new boolean[26];
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<course.length; i++) {
			System.out.println("limit: "+course[i]);
			Arrays.fill(visited, false);
			list.clear();
			sb.delete(0, sb.length());
			combi(0,0,course[i], sb);

			if(list.size()>0) {
				Collections.sort(list, Comparator.comparingInt(Node::getCount).reversed());
				Node first=list.get(0);
				ans.add(first.s);
				for(int k=1; k<list.size(); k++) {
					if(list.get(k).count == first.count) {
						ans.add(list.get(k).s);
					}else {
						break;
					}
				}
			}
		}
		Collections.sort(ans);
		answer=new String[ans.size()];
		for(int i=0; i<ans.size(); i++) {

			answer[i]=ans.get(i);
			System.out.println(answer[i]);
		}
		return answer;
	}
	static boolean[] visited;
	static int cc;
	private static void combi(int pos, int cnt, int limit, StringBuilder sb) {
		System.out.println("pos:"+pos+" cnt:"+cnt+" limit:"+limit+" sb:"+sb.toString());
		//cc++;
		//if(cc==30) return;
		if(cnt==limit) {
			System.out.println(sb.toString());
			int count=check();
			System.out.println("count:"+count);
			if(count>=2) {
				list.add(new Node(sb.toString(), count));
			}
			return;
		}
		if(pos>=26) return;
		if(al[pos]) {
			visited[pos]=true;
			sb.append((char)(pos+'A'));
			combi(pos+1, cnt+1, limit, sb);
			visited[pos]=false;
			if(sb.length()>=1) sb.deleteCharAt(sb.length()-1);
			combi(pos+1, cnt, limit, sb);
		}
		else {
			combi(pos+1, cnt, limit, sb);
		}
	}
	private static int check() {
		int cnt=0; boolean yes;
		loop:for(String s: or) {
			for(int i=0; i<26; i++) {
				if(visited[i]) {
					yes=false;
					for(int j=0; j<s.length(); j++) {
						if(s.charAt(j)-'A'==i) {
							yes=true;
							break;
						}
					}
					if(!yes) {
						continue loop;
					}
				}
			}
			cnt++;	
		}
		return cnt;
	}


}
