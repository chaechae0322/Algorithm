/*
 * 2020.04.11
 * programmers level 2 다리를지나는트럭
 * 
 * Queue
 */
package programmers;

import java.util.*;
class Solution {
    public class Info{
        int w;
        int t;
        public Info(int w,int t){
            this.w=w;
            this.t=t;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Info> q = new LinkedList<>();
        int time=0;
        int curweight=0;
        int idx=0;
        
        q.add(new Info(truck_weights[0], time+bridge_length));
        time++;
        curweight = truck_weights[0];
        idx++;
        
        while(!q.isEmpty()){
            //System.out.println(time+" "+curweight+" "+idx);
            if(q.peek().t == time){
                curweight -= q.peek().w;
                q.poll();
            }
            if(idx < truck_weights.length && curweight+truck_weights[idx] <= weight){
                //System.out.println("idx:"+idx+" outtime:"+(time+bridge_length));
                curweight += truck_weights[idx];
                q.add(new Info(truck_weights[idx], time+bridge_length));
                idx++;
                
            }
            time++;
        }
        
        answer=time;
        
        return answer;
    }
}