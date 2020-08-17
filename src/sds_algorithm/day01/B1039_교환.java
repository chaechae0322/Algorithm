package sds_algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1039_교환 {
	static int[] arr;
	static int len, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token =new StringTokenizer(br.readLine());
		int N=Integer.parseInt(token.nextToken());
		K=Integer.parseInt(token.nextToken());

		if(N<=10) {
			System.out.println(-1);
			return;
		}

		int p=1; int cnt=1;
		while(N/p>=10) {
			p*=10;
			cnt++;
		}
		arr=new int[cnt];
		cnt=0;
		while(p>=1) {
			arr[cnt++]=N/p;
			N-=p*(N/p);
			p/=10;
		}
		len=cnt;

		visited=new int[1000001];
		bfs();
		//System.out.println(Arrays.toString(arr));
	}
	static int[] visited;
	static int[] maxNum;
	private static void bfs() {
		Queue<Integer> pq = new LinkedList<>();
		maxNum=new int[len];
		int num=0; 
		int[] tmparr = arr.clone();

		// make num
		num=makeNum(tmparr);
		maxNum[0]=num;
		pq.add(num);
		boolean changable=false;

		int startp=(int) Math.pow(10, len-1);
		for(int k=1; k<=(K<len?K:len-1); k++) { // K번

			int qsize=pq.size();
			for(int t=0; t<qsize; t++) {
				int tmp = pq.poll();
				System.out.println("q poll:"+tmp);

				// to array
				int p=startp;
				for(int i=0; i<len; i++) {
					tmparr[i]=tmp/p;
					tmp-=(p*(tmp/p));
					p/=10;
				}
				// swap
				for(int i=0; i<len; i++) {
					for(int j=i+1; j<len; j++) {
						if(i==j)continue;
						if(i==0 && tmparr[j]==0) continue;

						swap(i,j,tmparr);
						num=makeNum(tmparr);
						maxNum[k]=Math.max(maxNum[k], num);
						swap(i,j,tmparr);

						if(visited[num]==0) {
							changable=true;
							visited[num]=k;
							pq.add(num);
						}
					}
				}
			}


			//  
			System.out.println(k+"번째");
			System.out.println(pq);
			//maxNum[k]=pq.peek();
		}

		int max=0;

		if(!changable) {
			System.out.println(-1);
			return;
		}


		//System.out.println("ddd");
		System.out.println(Arrays.toString(maxNum));


		if(K%2==0) { // 짝수번
			max=0;
			for(int i=0; i<=(K<len-1?K:len-1); i+=2) {
				max=Math.max(max, maxNum[i]);
			}
			System.out.println(max);
		}else { // 홀수번

			max=0;
			for(int i=1; i<=(K<len-1?K:len-1); i+=2) {
				max=Math.max(max, maxNum[i]);
			}
			System.out.println(max);

		}
	}
	private static void swap(int i, int j, int[] tmparr) {
		int tmp=tmparr[i];
		tmparr[i]=tmparr[j];
		tmparr[j]=tmp;	
	}
	private static int makeNum(int[] tmp) {

		int p=1, res=0;;
		for(int i=tmp.length-1; i>=0; i--) {
			res+=p*tmp[i];
			p*=10;
		}

		return res;
	}
	static int MAXVALUE=1;


}
