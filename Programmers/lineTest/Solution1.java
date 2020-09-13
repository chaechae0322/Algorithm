package Programmers.lineTest;

public class Solution1 {

	public static void main(String[] args) {
		//int[][] boxes= {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
		int[][] boxes= {{5, 5}, {5, 1}, {2, 4}};
		//int[][] boxes= {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
		System.out.println(solution(boxes));

	}
    public static int solution(int[][] boxes) {
        int answer = -1;
        int n=boxes.length; 
        int[] count=new int[1000001];
        int c=0;
        for(int i=0; i<n; i++) {
        	count[boxes[i][0]]++; 
        	if(count[boxes[i][0]]==2) {
        		c++;
        		count[boxes[i][0]]=0;
        	}
        	count[boxes[i][1]]++;
        	if(count[boxes[i][1]]==2) {
        		c++;
        		count[boxes[i][1]]=0;
        	}
        }
        answer=0;
        if(c==n) {
        	return answer;
        }
        for(int i=1; i<=1000000; i++) {
        	if(count[i]==1) {
        		answer++;
        		c++;
        		if(c==n) {
        			break;
        		}
        	}
        }
        return answer;
    }

}
