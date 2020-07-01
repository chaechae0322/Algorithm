/*
 * 2020.04.11 
 * programmers level 2 기능개발
 * 
 * Queue 
 */

package programmers;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int days = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] > 0 ) days+=1;
            //System.out.println(i+" "+days);
            q.add(days);
        }
        
        int cur=q.peek(), prev=q.peek();
        int cnt=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            cur= q.poll();
            if(prev<cur){
                list.add(cnt);
                cnt=1;
            }
            else cnt++;
            prev=Math.max(prev, cur);
        }
        list.add(cnt);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}
