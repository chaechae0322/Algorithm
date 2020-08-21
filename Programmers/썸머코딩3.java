package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 썸머코딩3 {

	public static void main(String[] args) {
		int[][] skills = {
				{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}	
		};
		int total_sp = 121;
		System.out.println(solution(total_sp, skills));

	}
	
	static int[] mem;
	static int[][] graph;
	//static ArrayList<Integer> graph[];
	static int N;

	public static int[] solution(int total_sp, int[][] skills) {
        int[] answer;
        int max=0;
        
        N = skills.length+1;
        answer = new int[N];
        graph = new int[N+1][N+1];
        /*graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++)
        	graph[i]=new ArrayList<>();*/
        mem = new int[N+1];
        
        //100001+1
        for(int i=0; i<skills.length; i++) {
        	graph[skills[i][0]][skills[i][1]]=1;
        	//graph[skills[i][0]].add(skills[i][1]);
        }
        
        boolean find = true;
        int root = -1;
        for(int i=1; i<=N; i++) {
        	find = true;
        	for(int j=0; j<=N; j++) {
        		if(graph[j][i]!=0) {
        			find = false;
        			break;
        		}
        	}
        	if(find) {
        		root = i;
        		break;
        	}
        }
        
        dfs(root);
        
        //System.out.println(Arrays.toString(mem));
        int cnt=0;
        for(int i=1; i<=N; i++) {
        	cnt+=mem[i];
        }
        int sp = total_sp / cnt;
        //System.out.println(sp);
        for(int i=1; i<=N; i++) {
        	answer[i-1]= sp*mem[i];
        
        }
        //System.out.println(Arrays.toString(answer));
        
        return answer;
    }

	private static int dfs(int idx) {
		//System.out.println("idx:"+idx);
		
		int num = 0;
		for(int i=0; i<=N; i++) {
			if(graph[idx][i]!=0) {
				num += dfs(i);
			}
		}
		
		if(num == 0) mem[idx]=1;
		else mem[idx]=num;
		return mem[idx];
	}
}
