package programmers;

import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int start; 
        int cost;
        
        @Override
        public int compareTo(Object o){
            if(this.start == o.start){
                return this.cost - o.cost;
            }
            return this.start-o.start;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQeueu<Node> pq = new PriorityQueue<>();
        Node cur = new Node(jobs[0][0], jobs[0][1]); //start, cost 
        for(int i=0; i<jobs.length; i++){
            
        }
        return answer;
    }
}
