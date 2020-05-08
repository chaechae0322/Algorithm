package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Line5 {
	static class doc implements Comparable<doc>{
		String name;
		int count;
		
		
		public doc(String name, int count) {
			super();
			this.name = name;
			this.count = count;
		}


		@Override
		public int compareTo(doc o) {
			if(o.count == this.count) {
				return this.name.compareTo(o.name);
			}
			return o.count-this.count;
			
		}
	}

	public static void main(String[] args) {
		String [][] dataSource = {
			{"doc1", "t1", "t2", "t3"},
			{"doc2", "t0", "t2", "t3"},
			{"doc3", "t1", "t6", "t7"},
			{"doc4", "t1", "t2", "t4"},
			{"doc5", "t6", "t100", "t8"}
		};
		String[] tags = {"t1", "t2", "t3"};
		
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0; i<tags.length; i++) {
			map.put(tags[i], 1);
		}
		ArrayList<doc> doclist = new ArrayList<>(); 
		int count=0;
		for(int i=0; i<dataSource.length; i++) {
			count=0;
			for(int j=1; j<dataSource[0].length && dataSource[i][j]!=null; j++) {
				if(map.containsKey(dataSource[i][j])) {
					count++;
				}
			}
			if(count==0) continue;
			doclist.add(new doc(dataSource[i][0], count));
		}
		Collections.sort(doclist);
		
		int len = doclist.size()>10?10:doclist.size();
		String[] answer = new String[len];
		
		for(int i=0; i<len; i++) {
			answer[i]=doclist.get(i).name;
		}
		System.out.println(Arrays.toString(answer));
	}

}
