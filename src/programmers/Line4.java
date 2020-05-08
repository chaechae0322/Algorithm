package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Line4 {

	public static void main(String[] args) {
		String [][] snapshots = {
				{"ACCOUNT1", "100"}, 
				{"ACCOUNT2", "150"}
			};
		String[][] transactions = {
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
				{"1", "SAVE", "ACCOUNT2", "100"}, 
				{"4", "SAVE", "ACCOUNT3", "500"}, 
				{"3", "WITHDRAW", "ACCOUNT2", "30"}
		};
		                    		  
		TreeMap<String, String> map = new TreeMap<String, String>();
		//map.put("people", "사람");
		//map.put("baseball", "야구");
		for(int i=0; i<snapshots.length; i++) {
			map.put(snapshots[i][0], snapshots[i][1]);
		}
		
		boolean[] idcheck=new boolean[100001];
		ArrayList<String[]> trans = new ArrayList<>();
		for(int i=0; i<transactions.length; i++) {
			if(!idcheck[Integer.parseInt(transactions[i][0])]) {
				idcheck[Integer.parseInt(transactions[i][0])]=true;
				trans.add(transactions[i]);
			}
		}
		
		System.out.println(map.get("ACCOUNT1"));
		for(int i=0; i<trans.size(); i++) {
			String[] tmp  = trans.get(i);
			System.out.println(Arrays.toString(tmp));
			
			int v = 0;
			if(!map.containsKey(tmp[2])){
				v=0;
			}
			else {
				v = Integer.parseInt(map.get(tmp[2]));
			}
			
			if(tmp[1]=="SAVE") {
				v += Integer.parseInt(tmp[3]);
				map.put(tmp[2], String.valueOf(v));
			}
			else if(tmp[1].equals("WITHDRAW")) {
				v -= Integer.parseInt(tmp[3]);
				map.put(tmp[2], String.valueOf(v));
			}
		}
		
		System.out.println(map.get("ACCOUNT3"));
		int len = map.size();
		String[][] answer = new String[map.size()][2];
		Iterator iterator = map.keySet().iterator();
		int idx=0;
        while(iterator.hasNext()) {
            String temp = (String) iterator.next();
            answer[idx][0]=temp;
            answer[idx][1]=map.get(temp);
            idx++;
            System.out.println(temp + " = " + map.get(temp));
        }
		
	}

}
