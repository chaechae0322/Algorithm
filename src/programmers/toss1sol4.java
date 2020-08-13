package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class toss1sol4 {
	static class Node implements Comparable<Node>{
		String name;
		int date;
		@Override
		public int compareTo(Node o) {
			return o.date-this.date;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] banks = input.split(" ");
		StringBuilder sb = new StringBuilder();
		
	}

}
