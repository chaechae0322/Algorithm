package Programmers.kakaoBlindtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution5 {

	public static void main(String[] args) {
		String p="02:03:55", a="00:14:15", l[]=
			{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.println(solution(p,a,l));
		
	}
	static class Node{
		int st, et;

		public Node(int st, int et) {
			super();
			this.st = st;
			this.et = et;
		}

		public int getSt() {
			return st;
		}

		public void setSt(int st) {
			this.st = st;
		}

		@Override
		public String toString() {
			return "Node [st=" + st + ", et=" + et + "]";
		}
		
	}
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int ans=0;
        int n=logs.length;
        Node[] info=new Node[n];
        int hour=0, min=0, sec=0, start=0, end=0;
        for(int i=0; i<n; i++) {
        	hour=Integer.parseInt(logs[i].substring(0, 2))*3600;
        	min=Integer.parseInt(logs[i].substring(3,5))*60;
        	sec=Integer.parseInt(logs[i].substring(6,8));
        	start=hour+min+sec;

        	hour=Integer.parseInt(logs[i].substring(9, 11))*3600;
        	min=Integer.parseInt(logs[i].substring(12,14))*60;
        	sec=Integer.parseInt(logs[i].substring(15,17));
        	end=hour+min+sec;
        	
        	info[i]=new Node(start, end);
        }
        hour=Integer.parseInt(adv_time.substring(0, 2))*3600;
    	min=Integer.parseInt(adv_time.substring(3,5))*60;
    	sec=Integer.parseInt(adv_time.substring(6,8));
    	int len=hour+min+sec;
        Arrays.sort(info, Comparator.comparingInt(Node::getSt));
        System.out.println(Arrays.toString(info));
        
        int res=0, anstime=0;
        int sidx=0, eidx=0;
        start=info[0].st;
        end=start+len;
        
        
        ArrayList<Node> list=new ArrayList<Node>();
        int cc=0;
        while(true) {
        	cc++;
        	if(cc==5) break;
        	System.out.println("start:"+start+" end:"+end);
        	
        	for(; eidx<n; eidx++) {
        		System.out.println("eidx:"+eidx);
        		if(info[eidx].st<=end) {
        			System.out.println("겹쳐");
        			list.add(info[eidx]);
        		}else { // 안 겹칠 때
        			System.out.println("안겹쳐");
        			eidx-=1;
        			break;
        		}
        	}
        	System.out.println("res:"+res+" sidx:"+sidx+" eidx:"+eidx);
        	for(Node t:list) {
        		System.out.println(t.toString());
        	}
        	
        	if(ans<res) {
        		ans=res;
        		anstime=start;
        	}
        	sidx+=1;
        	if(eidx<sidx) eidx=sidx;
        	if(end>info[sidx].st) {
        		res-=(info[sidx].st-start);
        	}else {
        		res-=end-start;
        	}
        	start=info[sidx].st;
        	end=start+len;
        	
        }
        
        return answer;
    }

}
