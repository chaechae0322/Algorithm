package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 쿠팡1 {

	public static void main(String[] args) {
		int[][] goods= {
				{3100,2},
				{7700,1},
				{3100,2}
		};
		int[][] coupons= {
				{33,4}
				
		};
		solution(goods, coupons);

	}
	
	public static long solution(int[][] goods, int[][] coupons) {
		long answer=0;
		PriorityQueue<Integer> coupq = new PriorityQueue<>();
		PriorityQueue<Integer> goodpq = new PriorityQueue<>();
		int price=0, su=0;
		for(int i=0; i<coupons.length; i++) {
			su=coupons[i][1];
			for(int j=0; j<su; j++)
				coupq.add(coupons[i][0]);
		}
		
		for(int i=0; i<goods.length; i++) {
			su=goods[i][1];
			for(int j=0; j<su; j++)
				goodpq.add(goods[i][0]);
		}
		
		PriorityQueue<Integer> reversedcoupq = 
		new PriorityQueue<Integer>(coupq.size(), Collections.reverseOrder());
		reversedcoupq.addAll(coupq);
		
		PriorityQueue<Integer> reversedgoodpq = 
				new PriorityQueue<Integer>(goodpq.size(), Collections.reverseOrder());
		reversedgoodpq.addAll(goodpq);
		
		
		while(!reversedgoodpq.isEmpty()&&!reversedcoupq.isEmpty()) {
			int good=reversedgoodpq.poll();
			int coupon=reversedcoupq.poll();
			
			System.out.println("good:"+good+" coupon:"+coupon);
			
			answer+=(long)(good)*(100-coupon)/100;
		}
		
		while(!reversedgoodpq.isEmpty()) {
			answer+=(long)(reversedgoodpq.poll());
		}

		System.out.println(answer);
		return answer;
	}

}
