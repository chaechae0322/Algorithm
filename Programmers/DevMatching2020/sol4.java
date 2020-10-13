package Programmers.DevMatching2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class sol4 {
	 public class Node{
	       String name;
	       int count;
	       public Node(String name, int count){
	           this.name=name;
	           this.count=count;
	       }
	   }
	   public String solution(String[] votes, int k) {
	       String answer = "";
	       HashMap<String, Integer> map=new HashMap<>();
	       for(int i=0; i<votes.length; i++){
	           if(!map.containsKey(votes[i])){
	               map.put(votes[i], 1);
	           }else{
	               int count = map.get(votes[i]);
	               map.put(votes[i], count+1);
	           }
	       }
	       ArrayList<Node> uplist=new ArrayList<>();
	       for(Iterator<String> it = map.keySet().iterator(); it.hasNext();){
	           String key = it.next();
	           uplist.add(new Node(key, map.get(key)));
	       }
	       Collections.sort(uplist, new Comparator<Node>(){
	           @Override
	           public int compare(Node o1, Node o2) {
	               if(o1.count == o2.count){
	                   return o1.name.compareTo(o2.name);
	               }else{
	                   return o2.count-o1.count;
	               }
	           }
	       });
	       
	       long limit = 0;
	       for(int i=0; i<k; i++){
	           limit += uplist.get(i).count;
	       }
	       long lower = 0;
	       for(int i=uplist.size()-1; i>=0; i--){
	           if(lower+uplist.get(i).count<limit){
	               lower += uplist.get(i).count;
	               answer = uplist.get(i).name;
	           }
	       }
	       
	       return answer;
	   }
}
