package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class 현카2 {

	public static void main(String[] args) {
		String[] ip_addrs = {
				"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", 
				"5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"
		};
		
		String[] langs = {
				"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"
		};
		
		
		int[] scores = {
			294, 197, 373, 45, 294, 62, 373, 373	
		};
		
		solution(ip_addrs, langs, scores);

	}
	
	public static int solution(String[] ip_addrs, String[] langs, int[] scores) {
		int answer = ip_addrs.length;
		
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i=0; i<ip_addrs.length; i++) {
			if(!map.containsKey(ip_addrs[i])) {
				tmp = new ArrayList<>();
				tmp.add(i);
				map.put(ip_addrs[i], tmp);
			}
			else {
				tmp = new ArrayList<>();
				tmp = map.get(ip_addrs[i]);
				tmp.add(i);
				map.put(ip_addrs[i], tmp);
			}
		}
		
		// 방법1
		
        Iterator<String> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            System.out.println("key:"+key);
            //System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
            
            tmp = new ArrayList<>();
            tmp = map.get(key);
            
            
            System.out.println(tmp.size());
            
            if(tmp.size()==2) {
            	
            	String first = langs[tmp.get(0)];
            	String sec = langs[tmp.get(1)];
            	
            	if(!first.equals(sec)) {
            		if((first.equals("C")||first.equals("C++")||first.equals("C#")) 
            				&& (sec.equals("C")||sec.equals("C++")||sec.equals("C#"))) {
            			if(scores[tmp.get(0)] == scores[tmp.get(1)]) {
            				answer -= 2;
            			}
            		}
            	}
            	else { //같을때 
            		if(scores[tmp.get(0)] == scores[tmp.get(1)]) {
        				answer -= 2;
        			}
            	}
            	
            }
            else if(tmp.size()==3) {
            	String prelang = langs[tmp.get(0)];
            	int pre = 0;
            	if(prelang.equals("C")||prelang.equals("C++")||prelang.equals("C#")) pre = 1;
            	else if(prelang.equals("Java")) pre =2;
            	else if(prelang.equals("JavaScript")) pre =3;
            	else if(prelang.equals("Python3")) pre =4;
            	
            	boolean fall=true;
            	
            	for(int i=1; i<tmp.size(); i++) {
            		int now=0;
            		prelang = langs[tmp.get(i)];
            		
            		if(prelang.equals("C")||prelang.equals("C++")||prelang.equals("C#")) now = 1;
                	else if(prelang.equals("Java")) now =2;
                	else if(prelang.equals("JavaScript")) now =3;
                	else if(prelang.equals("Python3")) now =4;
            		
            		if(now != pre) {
            			fall =false;
            			break;
            		}
            	}
            	
            	if(fall) answer -= 3;
            }
            else if(tmp.size()>=4) {
            	answer -= tmp.size();
            }
        }

        
        System.out.println(answer);
		
        return answer;
	}

}
