package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 *  우선순위큐
 *  중복제거
 *  모르겠음..
 */
public class B2014_소수의곱 {
	static int N,K,nums[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		K=Integer.parseInt(token.nextToken()); N=Integer.parseInt(token.nextToken());
		nums=new int[K];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			nums[i]=Integer.parseInt(token.nextToken());
		}
		solve();
	}
	private static void solve() {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int cnt=0; 
		long t=0, re;
		for(int i=0; i<K; i++) {
			pq.add((long)nums[i]);
		}
		while(cnt<N) {
			t=pq.poll();
			System.out.println(t);
			cnt++;

			for(int i=0; i<K; i++) {
				re=t*nums[i];
				if(re>Math.pow(2, 31)) continue;
				System.out.println("넣음 "+re);
				pq.add(re);
				if(t%nums[i]==0) {
					System.out.println("ssibal");
					break; 
				}
			}

		}
		System.out.println(t);
	}
}
