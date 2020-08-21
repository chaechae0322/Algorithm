package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11279_최대힙 {
	static int N, idx;
	static int[] heap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		heap=new int[N+1];
		
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp==0) {
				System.out.println(delete());
			}else {
				idx++;
				insert(tmp);
			}
		}
		

	}
	private static int delete() {
		if(idx==0) {
			//System.out.println(0);
			return 0;
		}
		int res = heap[1];
		heap[1]=heap[idx--];
		int cu=1, child=cu*2;
		
		while(child<=idx) {
			if(child<=idx) { // 완쪽 자식이 있을 때
				if(child+1<=idx && heap[child]<heap[child+1]) { // 
					child+=1;
				}
				
				if(heap[child]>heap[cu]){ // 왼쪽자식이 더 클때 
					int tmp=heap[cu];
					heap[cu]=heap[child];
					heap[child]=tmp;
					
					cu=child;
					child=cu*2;
				}
				else {
					break;
				}
			}
		}
		
		return res;
	}
	private static void insert(int num) {
		
		heap[idx]=num;
		int child=idx, parent = idx/2;
		while(child>1) {
			if(heap[child]>heap[parent]) {
				int tmp=heap[child];
				heap[child]=heap[parent];
				heap[parent]=tmp;
				child=parent;
				parent=child/2;
			}else {
				break;
			}
		}
		
	}

}
