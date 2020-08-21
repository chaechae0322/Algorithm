package BOJ.sds_algo.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2143_두배열의합 {
	static int T, N, M;
	static int[] arr, brr;
	//static ArrayList<Integer> suba, subb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		T=Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		arr=new int[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		M=Integer.parseInt(token.nextToken());
		brr=new int[M];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			brr[i]=Integer.parseInt(token.nextToken());
		}
		ArrayList<Integer> suba, subb;
		suba=new ArrayList<>(); subb=new ArrayList<>();
		int sum=0;
		for(int i=0; i<N; i++) {
			sum=0;
			for(int j=i; j<N; j++) {
				sum+=arr[j];
				suba.add(sum);
			}
		}
		for(int i=0; i<M; i++) {
			sum=0;
			for(int j=i; j<M; j++) {
				sum+=brr[j];
				subb.add(sum);
			}
		}
		
		Collections.sort(suba);
		Collections.sort(subb);
		System.out.println(suba);
		System.out.println(subb);
		
		long ans=0;
		for(int i=0; i<suba.size(); i++) {
			int lower = lowerBound(subb, 0, subb.size(), T-suba.get(i));
			int upper = upperBound(subb, 0, subb.size(), T-suba.get(i));
			ans+=upper-lower;
		}
		
		/*if(suba.size()>subb.size()) lowerupperBound(suba, subb);
		else lowerupperBound(subb, suba);*/
		System.out.println(ans);
	}
	static int ans;
	private static void lowerupperBound(ArrayList<Integer> suba, ArrayList<Integer> subb) {
		int low=0, high=subb.size()-1, mid=0;
		long tar=0L;
		int lowerBound=0, upperBound=0;
		long pretar=Long.MAX_VALUE; int preres=0;
		for(int i=0; i<suba.size(); i++) {
			tar=T-(long)suba.get(i);
			if(pretar==tar) {
				ans+=preres;
				continue;
			}
			low=0; high=subb.size()-1;
			
			System.out.println("tar: "+tar);
			
			//binary search
			while(low<=high) {
				mid=(low+high)/2;
				
				if(subb.get(mid)==tar) {
					
					lowerBound=mid; //lower bound
					while(lowerBound>=0 && subb.get(lowerBound)==tar) {lowerBound--;}
					lowerBound++;
					upperBound=lowerBound;
					while(upperBound<subb.size() && subb.get(upperBound)==tar) {upperBound++;}
					System.out.println("T: "+(upperBound-lowerBound));
					preres=upperBound-lowerBound;
					ans+=upperBound-lowerBound;
					break;
				}else if(subb.get(mid)>tar) {
					high=mid-1;
				}else {
					low=mid+1;
				}
			}
			pretar=tar;
		}

	}
	static int upperBound(List<Integer> list, int left, int right, long target) {
		int mid=0;
		while(left<right) {
			mid=(left+right)/2;
			
			if(list.get(mid)<=target) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return right;
	}
	static int lowerBound(List<Integer> list, int left, int right, long target) {
		int mid=0;
		while(left<right) {
			mid=(left+right)/2;
			
			if(list.get(mid)<target) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return right;
	}

}
