package sds_algorithm.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5568_카드놓기 {
	static int N, K;
	static int[] arr;
	static int[] visited;
	static int[] dense;
	static int[] facto;
	static int uniqueCount;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		arr=new int[N];
		visited=new int[N];
		check=new boolean[(int) 1e8];
		dense=new int[100];
		sb=new StringBuilder();
		facto=new int[K+1];
		facto[1]=1; facto[2]=2;
		if(K>2) {
			for(int i=3; i<=K; i++) {
				facto[i]=facto[i-1]*i;
			}
		}

		int tmp=0;
		for(int i=0; i<N; i++) {
			tmp=Integer.parseInt(br.readLine());
			if(dense[tmp]==0) {
				arr[uniqueCount++]=tmp;
				//uniqueCount++;
			}
			dense[tmp]++;
		}
		//System.out.println(Arrays.toString(dense));
		//System.out.println(Arrays.toString(arr));

		
		combi(0, 0);
		System.out.println(ans);
	}
	
	
	static StringBuilder sb;
	private static void perm(int pos, int[] copy) {

		//System.out.println("pos:"+pos);

		if(pos==copy.length) {
			System.out.println(Arrays.toString(copy));
			//System.out.println("dfdf");
			sb.delete(0, sb.length());
			for(int i=0; i<K; i++) {
				sb.append(copy[i]);
			}
			int n=Integer.parseInt(sb.toString());

			if(!check[n]) {

				System.out.println("숫자:"+n);
				ans++;
				check[n]=true;
			}
			return;
		}

		for(int i=pos; i<copy.length; i++) {
			swap(i,pos, copy);
			perm(pos+1, copy);
			swap(i,pos, copy);

		}

	}
	
	
	static int ans=0;
	private static void combi(int pos, int cnt) {
		//System.out.println(pos+" "+cnt+" "+arr[pos]);

		//목적지인가
		if(cnt==K) {

			System.out.println(Arrays.toString(visited));
			// 순열 

			int[] su = new int[K];
			int idx=0;
			for(int i=0; i<uniqueCount; i++) {
				if(visited[i]>0) {
					for(int j=0; j<visited[i]; j++) {
						su[idx++]=arr[i];
					}
					
				}
			}
			System.out.println(Arrays.toString(su));
			perm(0, su);

			/*int res = facto[K];
			for(int i=0; i<uniqueCount; i++) {
				if(visited[i]!=0) {
					res/=facto[visited[i]];
				}
			}
			System.out.println("res:"+res);
			ans+=res;*/
			return;
		}
		if(pos==uniqueCount) return;

		//갈수있는가
		for(int i=pos; i<uniqueCount; i++) {
			if(dense[arr[i]]>0) {
				dense[arr[i]]--;
				visited[i]++;
				combi(i, cnt+1);
				visited[i]--;
				dense[arr[i]]++;
			}
		}


	}

	private static void swap(int i, int pos, int[] copy) {
		int tmp=copy[i];
		copy[i]=copy[pos];
		copy[pos]=tmp;
	}


}
