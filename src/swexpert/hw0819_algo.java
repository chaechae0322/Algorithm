import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw0819_algo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		int[] nonPrime= {1,4,6,8,9,10,12,14,15,16,18};
		double[] comb=new double[nonPrime.length];
		
		for(int t=1; t<=tc; t++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			double A=Double.parseDouble(token.nextToken());
			double B=Double.parseDouble(token.nextToken());
			
			//calc combination
			for(int i=0; i<nonPrime.length; i++) {
				comb[i]=combination(18,nonPrime[i]);
			}
//			System.out.println(Arrays.toString(comb));
			
			double ans=1;
			for(int i=0; i<nonPrime.length; i++) {
				for(int j=0; j<nonPrime.length; j++) {
					ans -= comb[i]*Math.pow(A/100.0, nonPrime[i])*Math.pow((100-A)/100.0, 18-nonPrime[i])
							*comb[j]*Math.pow(B/100.0, nonPrime[j])*Math.pow((100-B)/100.0, 18-nonPrime[j]);
				}
			}
//			ans += 0.0000005;
			System.out.printf("#%d %.6f\n",t, ans);
		}

	}
	static int combination(int n, int r) {
		if(n == r || r == 0) return 1; 
		else return combination(n - 1, r - 1) + combination(n - 1, r); 
	}

}
