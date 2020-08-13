package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1927_최소힙 {
	static int[] tree;
	static int N;
	static int end=1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		tree=new int[N+1];
		int idx=1;
		for(int i=0; i<N; i++) {
			int order = Integer.parseInt(br.readLine());
			if(order==0) {
				System.out.println(delete());
			}else {
				insert(order);
				
			}
		}

	}
	private static void insert(int order) {
		tree[end++]=order;
		upheap();
	}
	private static void upheap() {
		int pos = end-1;
		int parent = (end-1)/2;
		boolean up=true;
		while(up) {
			if(pos==1) break;
			if(tree[pos]<tree[parent]) {
				int tmp=tree[pos];
				tree[pos]=tree[parent];
				tree[parent]=tmp;
				
				pos=parent;
				parent=pos/2;
				up=true;
			}else {
				up=false;
			}
		}
	}
	private static int delete() {
		if(end==1) return 0;
		
		int res = tree[1];
		tree[1]=tree[end-1];
		tree[end-1]=0;
		end--;
		
		downheap();
		
		return res;
		
	}
	private static void downheap() {
		int pos = 1;
		int child = pos*2;
		boolean down=true;
		while(down) {
			if(pos>=end-1) break;
			if((child<end && tree[pos]>tree[child]) || (child+1<end&&tree[pos]>tree[child+1])) {
				if(child+1<end) {
					child = tree[child] < tree[child+1] ? child : child+1;
				}
				int tmp=tree[pos];
				tree[pos]=tree[child];
				tree[child]=tmp;
				
				pos=child;
				child=pos*2;
				down=true;
			}else {
				down=false;
			}
		}
	}

}
