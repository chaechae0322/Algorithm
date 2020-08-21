package BOJ.sds_algo.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B6588_골드바흐의추측 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		int[] map=new int[1000000+1];
		
		// 배수고르기
		for(int i=2; i<=Math.sqrt(1000000); i++) {
			if(map[i]==0) {
				//map[i]=1;
				for(int j=2; i*j<=1000000; j++) {
					if(map[i*j]==0) map[i*j]=1;
				}
			}
		}
		
		while(!(input=br.readLine()).equals("0")) {
			int N=Integer.parseInt(input);
			System.out.println(N);
			
			
			int left=3, right=N;
			while(--right>=3 && map[right]==1);
			//System.out.println();
			while(left<=right) {
				if(left+right == N) {
					break;
				}
				else if(left+right < N) {
					while(++left<=right && map[left]==1);
				}else {
					while(--right>=left && map[right]==1);
				}
			}
			
			//System.out.println(Arrays.toString(map));
			//sb.delete(0, sb.length());
			System.out.println(left+" "+right);
			
			if(left+right==N) {
				System.out.println(N+" = "+left+" + "+right);
			}else {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}

	}

}
