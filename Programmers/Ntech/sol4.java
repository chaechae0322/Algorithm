package Programmers;

import java.util.ArrayList;

public class sol4 {

	public static void main(String[] args) {
		int[][] t1= {{-1, 1}, {-1, 2},{-1,-1}};
		int[][] t2=	{{-1, -1}};
		
		
//		int[][] t1= {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
//		int[][] t2=	{{1,2},{-1,-1},{-1,-1}};
		System.out.println(solution(t1, t2));

	}
	static int[][] r1,r2;
	static String root2; 
    public static int solution(int[][] t1, int[][] t2) {
        int answer = 0;
        r1=t1; r2=t2;

        // t2 root 만들기
        root2 = dfs(0, -1, 2);
        
        dfs(0, -1, 1);
        answer=ans;
        return answer;
    }
    static int ans;
	private static String dfs(int pos, int c, int sel) {
		StringBuilder s=new StringBuilder();
		
		int tmp=0;
		for(int i=0; i<2; i++) {
			if(sel==1) tmp=r1[pos][i];
			else tmp=r2[pos][i];
			if(tmp==-1) continue;
			
			s.append(dfs(tmp, i, sel));
			if(s.toString().equals(root2)) {
				ans++;
			}
		}
		if(c==0) s.append("L");
		else if(c==1) s.append("R");
		
		return s.toString();
	}

}
