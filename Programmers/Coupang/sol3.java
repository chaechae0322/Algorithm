package Programmers.Coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class sol3 {

	public static void main(String[] args) {
		int n = 3;
		int[] s= {
				2000000000,
				1999999999,
				1999999998,
				1999999997,
				1999999996,
				1999999995,
				1999999994
		};
		System.out.println(solution(n,s));

	}
	public static int solution(int k, int[] score) {
		int answer=score.length;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for(int i=1; i<score.length; i++) {
			int diff = score[i-1] - score[i];
			if(!map.containsKey(diff)) { // 없을때
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(diff, list);
			}else { // 있을때
				map.get(diff).add(i); 
			}
		}
		System.out.println(map);
		boolean[] check=new boolean[score.length];
		Iterator<Integer> iter  = map.keySet().iterator();
		ArrayList<Integer> list = null;
		while(iter.hasNext()) {
			list = map.get(iter.next());
			if(list.size()>=k) {
				System.out.println(list);
				for(int i=0; i<list.size(); i++) {
					

					if(!check[list.get(i)-1]) {
						check[list.get(i)-1]=true;
						answer--;
					}
					if(!check[list.get(i)]) {
						check[list.get(i)]=true;
						answer--;
					}

				}
			}
		}
		System.out.println(Arrays.toString(check));
		return answer;
	}

}
