package programmers;

public class 기지국설치 {

	public static void main(String[] args) {
		int res = solution(11, new int[] {4,11}, 1);
		System.out.println(res);

	}
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;

		int diff =0;


		diff = (stations[0]-w)-1;
		System.out.println("diff:"+diff);
		if(diff>0) {
			answer += diff/(w*2+1);
			if(diff%(w*2+1)!=0) answer++;
		}
		System.out.println("answer:"+answer);

		for(int i=1; i<stations.length; i++) {
			System.out.println(stations[i]);

			diff = (stations[i]-w)-(stations[i-1]+w)-1;
			if(diff>0) {
				answer += diff/(w*2+1);
				if(diff%(w*2+1)!=0) answer++;
			}

			//System.out.println((int)(diff/(float)(2*w+1) + 1));
			System.out.println("diff:"+diff);
			System.out.println("answer:"+answer);
		}

		diff = n - (stations[stations.length-1]+w);
		System.out.println("diff:"+diff);

		if(diff>0) {
			answer += diff/(w*2+1);
			if(diff%(w*2+1)!=0) answer++;
		}
		System.out.println("answer:"+answer);

		return answer;
	}

}
