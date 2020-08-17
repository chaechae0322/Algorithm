package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *  heap
 */
public class B1655_가운데를말해요 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> ascending = new PriorityQueue<>();
		PriorityQueue<Integer> descending = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
		
		if(N==1) {
			int tmp=Integer.parseInt(br.readLine());
			System.out.println(tmp);
			return;
		}
		
		// initial
		int s1=Integer.parseInt(br.readLine());
		System.out.println(s1);
		System.out.println();
		int s2=Integer.parseInt(br.readLine());
		if(s1>=s2) {
			ascending.add(s1);
			descending.add(s2);
		}else {
			ascending.add(s2);
			descending.add(s1);
		}
		
		//System.out.println(descending.peek());
		System.out.println(descending.peek());
		
		System.out.println("---pq check---");
		System.out.println(descending);
		System.out.println(ascending);
		System.out.println("-----------");
		System.out.println();
		
		for(int i=3; i<=N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			
			if(descending.peek()<tmp) { // 
				ascending.add(tmp);
			}else {
				descending.add(tmp);
			}
			
			if(ascending.size()-descending.size() >= 2) {
				while(ascending.size()-descending.size() >= 2) {
					descending.add(ascending.poll());
				}
			}
			
			if(descending.size()-ascending.size() >= 2) {
				while(descending.size()-ascending.size() >= 2) {
					ascending.add(descending.poll());
				}
			}
			
			if(descending.size()>=ascending.size()) {
				System.out.println(descending.peek());
			}else { // 
				System.out.println(ascending.peek());
			}
			
			System.out.println("---pq check---");
			System.out.println("작은거: "+descending);
			System.out.println("큰거: "+ascending);
			System.out.println("-----------");
			System.out.println();
		}
		
	}

}
