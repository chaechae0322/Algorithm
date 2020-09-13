package Programmers.lineTest;

import java.util.ArrayList;

public class Solution5 {

	public static void main(String[] args) {
		int[] cards= {12, 7, 11, 6, 2, 12};
		System.out.println(solution(cards));
	}
    public static int solution(int[] cards) {
        int answer = -1;
        ArrayList<Integer> p=new ArrayList<Integer>();
        ArrayList<Integer> d=new ArrayList<Integer>();
        int sel=0, ptarget=21, dtarget=21;
        boolean stop=false;
        int pnum=0, dnum=0;
        for(int i=0;i<cards.length; i++) {
        	System.out.println("------------------------");
        	if(i%2==0) {
        		if(stop) continue;
        		p.add(cards[i]);
        		pnum=make(p, ptarget);
        		if(pnum>21) {
        			answer-=2;
        			p.clear(); d.clear();
        			sel=0; ptarget=21; dtarget=21;
        			pnum=0; dnum=0;
        			stop=false;
        		}
        		else if(pnum==21) {
        			
        			if(dnum!=21) {
        				answer+=(answer*1.5);
        			}
        			p.clear(); d.clear();
        			sel=0; ptarget=21; dtarget=21;
        			pnum=0; dnum=0;
        			stop=false;
        		}
        		else if(pnum>=ptarget) {
        			stop=true;
        		}
        	}else {
        		if(i==3) {
        			sel=cards[i];
        			if(sel==1||sel==7) { //플레이어는 카드 합이 17 이상이 될 때까지 받는다.
        				System.out.println("플레이어는 카드 합이 17 이상이 될 때까지 받는다.");
        				ptarget=17;
        			}else if(sel==4||sel==5||sel==6) { //플레이어는 카드를 받지 않는다.
        				System.out.println("플레이어는 카드를 받지 않는다.");
        				stop=true;
        			}else if(sel==2||sel==3) { //플레이어는 카드 합이 12 이상이 될 때까지 받는다.
        				System.out.println("플레이어는 카드 합이 12 이상이 될 때까지 받는다.");
        				ptarget=12;
        			}
        			
        		}
        		d.add(cards[i]);
        		dnum=make(d, dtarget);
        		if(dnum>21) {
        			answer+=2;
        			d.clear(); p.clear();
        			sel=0; ptarget=21; dtarget=21;
        			pnum=0; dnum=0;
        			stop=false;
        		}else if(dnum>=17) { // 끝 
        			if(21-dnum<21-pnum) {
        				answer-=2;
        				
        			}else if(21-dnum>21-pnum) {
        				answer+=2;
        			}
        			d.clear(); p.clear();
        			sel=0; ptarget=21; dtarget=21;
        			pnum=0; dnum=0;
        			stop=false;
        		}
        	}
        	
        	System.out.println(p);
        	System.out.println(d);
        }
        return answer;
    }
	private static int make(ArrayList<Integer> p, int target) {
		int res=0;
		ArrayList<Integer> one=new ArrayList<Integer>();
		for(int i=0; i<p.size(); i++) {
			int t=p.get(i);
			if(t==1) {
				one.add(i);
				continue;
			}
			
			if(t>=10) t=10;
			res+=t;
		}
		int tmp=res;
		return 0;
	}

}
