package BOJ.sds_algo.day01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기 {
	static int M, N;
	static int[] mrr, nrr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		nrr=new int[N];
		//token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nrr[i]=Integer.parseInt(token.nextToken());
		}
		M=Integer.parseInt(br.readLine());
		mrr=new int[M];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			mrr[i]=Integer.parseInt(token.nextToken());
		}
		Arrays.sort(nrr);
		System.out.println(Arrays.toString(nrr));
		for(int i=0; i<M; i++) {
			System.out.println(bsearch(mrr[i]));
		}
	}
	private static int bsearch(int num) {
		System.out.println("num:"+num);
		int s=0, e=M-1, mid=0;
		while(s<=e) {
			mid = (s+e)/2;
			System.out.println("m[mid]:"+mrr[mid]+" s:"+s+" e:"+e);
			if(nrr[mid]==num) {
				return 1;
			}else if(nrr[mid]>num) {
				e=mid-1;
			}else {
				s=mid+1;
			}
		}
		return 0;
	}

}
