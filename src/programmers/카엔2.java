package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 카엔2 {
	static class Info{
		int vic;
		int set;
		
		public Info() {
			
		}
		public Info(int vic, int set) {
			super();
			this.vic = vic;
			this.set = set;
		}

		public int getVic() {
			return vic;
		}

		public void setVic(int vic) {
			this.vic = vic;
		}

		public int getSet() {
			return set;
		}

		public void setSet(int set) {
			this.set = set;
		}
		@Override
		public String toString() {
			return "Info [vic=" + vic + ", set=" + set + "]";
		}
		
	}
	

	static class Node implements Comparable<Node>{
		String name;
		int vic, set;
		public Node(String name, int vic, int set) {
			super();
			this.name = name;
			this.vic = vic;
			this.set = set;
		}
		@Override
		public String toString() {
			return "Node [name=" + name + ", vic=" + vic + ", set=" + set + "]";
		}
		@Override
		public int compareTo(Node o) {
			if(o.vic == this.vic) {
				if(o.set == this.set) {
					return this.name.compareTo(o.name);
				}
				else return o.set-this.set;
			}
			return o.vic-this.vic;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		Map<String, Info> map = new HashMap<>();
		
		int N = Integer.parseInt(token.nextToken());
		String t1="", t2="";
		int s1=0, s2=0;
		
		int tmpset=0, tmpvic=0;
		for(int i=0; i<N*(N-1); i++) {
			token = new StringTokenizer(br.readLine());
			
			t1=token.nextToken();
			s1=Integer.parseInt(token.nextToken());
			t2=token.nextToken();
			s2=Integer.parseInt(token.nextToken());
			
			//System.out.println(t1+" "+s1+" "+t2+" "+s2);
			
			if(map.containsKey(t1)) {
				
				Info tmpinfo = map.get(t1);
				
				//tmpset = map.get(t1).set;
				//tmpvic = map.get(t1).vic;
				//map.get(t1).setSet(tmpset+(s1-s2));
				tmpinfo.set += (s1-s2);
				
				if(s1>s2)
					tmpinfo.vic += 1;
					//map.get(t1).setSet(tmpvic+1);
				map.put(t1, tmpinfo);
			}else {
				if(s1>s2)
					map.put(t1, new Info(1, s1-s2));
				else 
					map.put(t1, new Info(0, s1-s2));
			}
			
			if(map.containsKey(t2)) {
				Info tmpinfo = map.get(t2);
				
				//tmpset = map.get(t2).set;
				//tmpvic = map.get(t2).vic;
				//map.get(t2).setSet(tmpset+(s2-s1));
				//map.put(key, value)
				
				if(s2>s1)
					//map.get(t2).setSet(tmpvic+1);
					tmpinfo.vic +=1;
				tmpinfo.set += (s2-s1);
				
				map.put(t2, tmpinfo);
				
			}else {
				if(s2>s1)
					map.put(t2, new Info(1, s2-s1));
				else 
					map.put(t2, new Info(0, s2-s1));
			}
			
			//System.out.println(map.get(t1));
			//System.out.println(map.get(t2));
		}
		
		ArrayList<Node> list = new ArrayList<>();
		map.forEach((key, value)
				->list.add(new Node(key, value.vic, value.set)));
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			Node tmp = list.get(i);
			System.out.println(tmp.name+" "+tmp.vic+" "+tmp.set);
		}
		
				
			
		

	}

}
