package Programmers.lineTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution6 {

	public static void main(String[] args) {
		//String[] c= {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
		//String[] a= {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
		String[] c= {"A abc 2", "Z zba 1"};
		String[] a= {"a AB 1", "b AB 1", "z AZ 2"};
		solution(c,a);

	}
	static class Com{
		char[] app;
		int n;
		public Com(char[] app, int n) {
			super();
			this.app = app;
			this.n = n;
		}
		@Override
		public String toString() {
			return "Com [app=" + Arrays.toString(app) + ", n=" + n + "]";
		}

	}
	static class App{
		char[] com;
		int want, r;
		public App(char[] com, int want, int r) {
			super();
			this.com = com;
			this.want = want;
			this.r = r;
		}
		@Override
		public String toString() {
			return "App [com=" + Arrays.toString(com) + ", want=" + want + ", r=" + r + "]";
		}

	}
	public static String[] solution(String[] companies, String[] applicants) {
		String[] answer = {};
		Com[] com=new Com[26];
		App[] app=new App[26];
		ArrayList<Character> ref=new ArrayList<>();
		int cnt=applicants.length;
		for(int i=0; i<companies.length; i++) {
			String[] s=companies[i].split(" ");
			com[s[0].charAt(0)-'A']=new Com(s[1].toCharArray(), Integer.parseInt(s[2]));

		}
		for(int i=0; i<applicants.length; i++) {
			String[] s=applicants[i].split(" ");
			app[s[0].charAt(0)-'a']=new App(s[1].toCharArray(), Integer.parseInt(s[2]), 0);
			ref.add(s[0].charAt(0));
		}

		ArrayList<Character>[] comlist = new ArrayList[26];
		for(int i=0; i<26; i++) comlist[i]=new ArrayList<Character>();
		while(ref.size()>0) {
			boolean[] check=new boolean[26];
			for(int i=0; i<ref.size(); i++) {
				char tmp=ref.get(i);
				if(app[tmp-'a'].want==app[tmp-'a'].r) { // 더이상 지원 x
					continue; 
				}

				comlist[app[tmp-'a'].com[app[tmp-'a'].r]-'A'].add(tmp); // 지원
			}
			for(int i=0; i<26; i++) {
				if(com[i]!=null) {
					System.out.println(comlist[i]);
				}
			}
			ref.clear();

			for(int i=0; i<26; i++) {
				if(com[i]!=null && comlist[i].size()>com[i].n) { // 지원자가 인원보다 많으면
					int count=0;
					for(int j=0; j<com[i].app.length; j++) { // 선호 지원자
						if(comlist[i].contains(com[i].app[j])) {
							check[com[i].app[j]-'a']=true;

							count++;
							if(count==com[i].n) {
								break;
							}
						}
					}
					for(int j=comlist[i].size()-1; j>=0; j--) {
						if(!check[comlist[i].get(j)-'a']) {
							ref.add(comlist[i].get(j));
							app[comlist[i].get(j)-'a'].r++;
							comlist[i].remove(j);
						}
					}
				}
			}


		}
		StringBuilder sb=new StringBuilder();
		ArrayList<String> ans=new ArrayList<String>();
		for(int i=0; i<26; i++) {
			if(com[i]!=null) {
				sb.delete(0, sb.length());
				sb.append((char)(i+'A')); sb.append("_");
				if(comlist[i].size()>0) {
					Collections.sort(comlist[i]);
					for(char t:comlist[i]) {
						sb.append(t);
					}
				}
				ans.add(sb.toString());
			}
		}
		answer=new String[ans.size()];
		for(int i=0; i<ans.size(); i++) {
			answer[i]=ans.get(i);
		}
		return answer;
	}
}
