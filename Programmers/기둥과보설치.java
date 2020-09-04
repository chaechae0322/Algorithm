package Programmers;
import java.util.*;
/*
 * 빡시뮬.... 개빡
 */
public class 기둥과보설치  {
    static int map[][][], cnt;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        map=new int[n+1][n+1][2];
        int x=0,y=0,a=0,b=0;
        
        for(int i=0; i<build_frame.length; i++){
            x=build_frame[i][0]; y=build_frame[i][1];
            a=build_frame[i][2]; b=build_frame[i][3];

            if(b==1){
                insert(x,y,a,n);
            }else{
                delete(x,y,a,n);
            }
        }
        answer=new int[cnt][3];
        int idx=0;
        for(int j=0; j<=n; j++){
            for(int i=0; i<=n; i++){
                if(map[i][j][0]==1){
                    answer[idx][0]=j; answer[idx][1]=i; answer[idx][2]=0;
                    idx++;
                }
                if(map[i][j][1]==1){
                    answer[idx][0]=j; answer[idx][1]=i; answer[idx][2]=1;
                    idx++;
                }
            }
        }
        //for(int i=0; i<cnt; i++)
        //    System.out.println(Arrays.toString(answer[i]));
        return answer;
    }
    public boolean insert(int x, int y, int a, int n){
        map[y][x][a]=1; cnt++;
        boolean t=true;
        loop:for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(map[i][j][0]==1 && !isSafe(j,i,0,n)){
                    t=false;
                    break loop;       
                }
                if(map[i][j][1]==1 && !isSafe(j,i,1,n)){
                    t=false;
                    break loop;
                }
            }
        }
        if(!t) {
            map[y][x][a]=0;
            cnt--;
            return false;
        }
        return true;
    }
    public boolean delete(int x, int y, int a, int n){
        map[y][x][a]=0; cnt--;
        boolean t=true;
        loop:for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(map[i][j][0]==1 && !isSafe(j,i,0,n)){
                    t=false;
                    break loop;       
                }
                if(map[i][j][1]==1 && !isSafe(j,i,1,n)){
                    t=false;
                    break loop;
                }
            }
        }
        if(!t) {
            map[y][x][a]=1;
            cnt++;
            return false;
        }
        return true;
    }
    public boolean isSafe(int x, int y, int a, int n){
        if(a==0){ //기둥
            if(y==0 || map[y-1][x][0]==1) return true;
             
            else if(x-1>=0 && map[y][x-1][1]==1){ //왼쪽보
                    return true;
             }
            else if(map[y][x][1]==1){ //오른쪽보
                return true;
             }
            
        }else{ //보
            if(map[y-1][x][0]==1){ // left
                return true;
            }
            else if(x+1<=n && map[y-1][x+1][0]==1){ // right
                return true;
            }
            else if(x-1>=0 && x+1<=n && map[y][x-1][1]==1 && map[y][x+1][1]==1){ //양쪽에보
                return true;
            }
        }
        return false;
    }
}