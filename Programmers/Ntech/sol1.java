package Programmers;

public class sol1 {

	public static void main(String[] args) {
		int t[][] = {{3, 4},{4, 5}, {6, 7}, {8, 10}};
		System.out.println(solution(t));

	}
    public static int solution(int[][] flowers) {
        int answer = 0;
        int[] days=new int[366];
        
        for(int i=0; i<flowers.length; i++) {
        	int a=flowers[i][0];
        	int b=flowers[i][1];
        	for(int j=a; j<b; j++) {
        		days[j]++;
        		if(days[j]==1) {
        			answer++;
        		}
        	}
        }
        return answer;
    }

}
