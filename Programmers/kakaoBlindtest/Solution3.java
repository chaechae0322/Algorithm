package Programmers.kakaoBlindtest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution3 {

	public static void main(String[] args) {
		//String[] t={"java backend junior pizza 150\",\"python frontend senior chicken 210\",\"python frontend senior chicken 150\",\"cpp backend senior pizza 260\","java backend junior chicken 80","python backend senior chicken 50\"};
		//String[] q={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		//solution(t, q);
		solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
				new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});

	}
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int n=info[0].split(" ").length;
        String[][] map=new String[info.length][n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<info.length; i++) {
        	String[] tt=info[i].split(" ");
        	int res=0;
        	for(int j=0; j<tt.length; j++) {
        		System.out.println(tt[j]);
        		if(tt[j].equals("java")) {
        			res+=1000000;
        		}else if(tt[j].equals("python")) {
        			res+=2000000;
        		}
        		else if(tt[j].equals("cpp")) {
        			res+=3000000;
        		}
        		else if(tt[j].equals("python")) {
        			res+=4000000;
        		}
        		else if(tt[j].equals("backend")) {
        			res+=100000;
        		}
        		else if(tt[j].equals("frontend")) {
        			res+=200000;
        		}
        		else if(tt[j].equals("junior")) {
        			res+=10000;
        		}
        		else if(tt[j].equals("senior")) {
        			res+=20000;
        		}
        		else if(tt[j].equals("chicken")) {
        			res+=1000;
        		}
        		else if(tt[j].equals("pizza")) {
        			res+=2000;
        		}else {
        			res+=Integer.parseInt(tt[j]);
        		}
        	}
        	
        	set.add(res);
        }
        
        System.out.println(set);
        
        for(int i=0; i<query.length; i++) {
        	int res=0, score=0;
        	String[] tt = query[i].split(" ");
        	for(int j=0; j<tt.length; j++) {
        //		sysout
        		
        		if(tt[j].equals("java")) {
        			res+=1000000;
        		}else if(tt[j].equals("python")) {
        			res+=2000000;
        		}
        		else if(tt[j].equals("cpp")) {
        			res+=3000000;
        		}
        		else if(tt[j].equals("python")) {
        			res+=4000000;
        		}
        		else if(tt[j].equals("backend")) {
        			res+=100000;
        		}
        		else if(tt[j].equals("frontend")) {
        			res+=200000;
        		}
        		else if(tt[j].equals("junior")) {
        			res+=10000;
        		}
        		else if(tt[j].equals("senior")) {
        			res+=20000;
        		}
        		else if(tt[j].equals("chicken")) {
        			res+=1000;
        		}
        		else if(tt[j].equals("pizza")) {
        			res+=2000;
        		}else if(tt[j].equals("and")||tt[j].equals("-")){
        			continue;
        		}else { // 숫자
        			//res+=Integer.parseInt(tt[j]);
        			score=Integer.parseInt(tt[j]);
        		}
        	}
        	
        	Iterator<Integer> it=set.iterator();
        	int cnt=0;
        	while(it.hasNext()) {
        		if(it.next()>=(res+score) && it.next()<(res+1000)) {
        			cnt++;
        		}
        	}
        	answer[i]=cnt;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
