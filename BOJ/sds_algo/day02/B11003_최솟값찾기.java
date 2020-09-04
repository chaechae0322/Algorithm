package BOJ.sds_algo.day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
// deque (two pointer도 가능) 
public class B11003_최솟값찾기 {
	static int N,L,arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		L=Integer.parseInt(token.nextToken());
		arr=new int[N];
		int[] re=new int[N];
		token = new StringTokenizer(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayDeque<Integer> dq=new ArrayDeque<>(); // index
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
			if(!dq.isEmpty() && i>=dq.getFirst()+L) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && arr[dq.getLast()]>arr[i]) {
				dq.removeLast();
			}
			dq.offer(i);
			re[i]=arr[dq.getFirst()];
		}
		for(int i=0; i<N; i++)
			bw.write(re[i]+" ");
		
		bw.flush();
		bw.close();
	}

}
