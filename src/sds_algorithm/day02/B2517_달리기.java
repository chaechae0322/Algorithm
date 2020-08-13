package sds_algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2517_달리기 {
	static class Node implements Comparable<Node>{
		int num, cnt, pos;
		public Node(int num, int cnt, int pos) {
			this.num=num;
			this.cnt=cnt;
			this.pos=pos;
		}
		@Override
		public String toString() {
			return "Node [num="+num+", cnt=" + cnt + ", pos=" + pos + "]";
		}
		@Override
		public int compareTo(Node o) {
			return o.num-this.num;
		}
	}
	static Node[] arr;
	static Node[] temp;
	static int N;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		rank = new int[N+1];
		arr=new Node[N];
		for(int i=0; i<N; i++) {
			arr[i]=new Node(Integer.parseInt(br.readLine()), 0, i+1);
			//rank[i]=arr[i].num;
		}
		temp=new Node[N];
		mergeSort(0, N-1);
		for(Node t : arr)
			System.out.println(t.toString());
		System.out.println("--------------");
		for(Node t : temp)
			System.out.println(t.toString());
		System.out.println(Arrays.toString(rank));
		for(int i=1; i<=N; i++) {
			System.out.print(arr[rank[i]].pos-arr[rank[i]].cnt+" ");
		}
	}
	public static void mergeSort(int s, int e) {
		if(s<e) {
			int mid=(s+e)/2;
			mergeSort(s, mid);
			mergeSort(mid+1, e);
			merge(s,mid,e);
		}
	}
	private static void merge(int s, int m, int e) {
		System.out.println("s:"+s+" e:"+e);
		for(int i=s; i<=e; i++) {
			System.out.println(arr[i].toString());
		}
		int p1=s, p2=m+1, k=s;
		while(p1<=m&&p2<=e) {
			if(arr[p1].num<=arr[p2].num) {
				temp[k++]=arr[p1++];
			}else {
				System.out.println("count");
				temp[k]=arr[p2];
				temp[k].cnt+=(p1-s);
				System.out.println(temp[k].toString());
				k++; p2++;
			}
			System.out.println(p1+" "+p2);
		}
		while(p1<=m) {
			temp[k++]=arr[p1++];
		}
		while(p2<=e) {
			System.out.println("count");
			temp[k]=arr[p2];
			temp[k].cnt+=(p1-s);
			System.out.println(temp[k].toString());
			k++; p2++;
		}
		for(int i=s; i<=e; i++) {
			rank[temp[i].pos]=i;
			arr[i]=temp[i];
		}
	}
}
