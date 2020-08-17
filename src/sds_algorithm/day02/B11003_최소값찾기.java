package sds_algorithm.day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11003_최소값찾기 {
	static class Node{
		int val, idx;
		public Node(int val, int idx) {
			this.val=val;
			this.idx=idx;
		}
		@Override
		public String toString() {
			return "Node [val=" + val + ", idx=" + idx + "]";
		}
	}
	static int N,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		L=Integer.parseInt(token.nextToken());
		
		token = new StringTokenizer(br.readLine());
		Deque<Node> dq = new LinkedList<>();
		dq.add(new Node(Integer.parseInt(token.nextToken()), 1));
	
		int idx=dq.peekFirst().idx;
		int val=dq.peekFirst().val;
		bw.write(val+" ");
		for(int i=2; i<=N; i++) {
			int tmp=Integer.parseInt(token.nextToken());
			System.out.println("tmp:"+tmp);
			
			while(i>=idx+L) {
				dq.pollFirst();
				idx=dq.peekFirst().idx;
			}
			
			while(!dq.isEmpty() && dq.peekLast().val > tmp) {
				dq.pollLast();
			}
			dq.add(new Node(tmp, i));

			idx=dq.peekFirst().idx;
			val=dq.peekFirst().val;

			
			System.out.println("현재: "+i+" idx:"+idx+" val:"+val);
			System.out.println(dq);
			bw.write(val+" ");
		}

		bw.flush();
        bw.close();
	}

}
