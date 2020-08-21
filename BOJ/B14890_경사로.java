package BOJ;

import java.util.Scanner;

/**
 * B14890_경사로
 * 2020.02.02
 */
public class B14890_경사로 {
    static int N,L;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        L=sc.nextInt();
        map=new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                map[i][j]=sc.nextInt();
            
        solve();
    }
    static boolean[][] check;
    public static void solve() {
        check =new boolean[N][N];
        int prev=0, now=0;
        int ans=0;
        System.out.println("가로검사");

        for(int i=0; i<N; i++){ //horizon
            boolean isok=true;
            System.out.println("i:"+i);
            prev=now=map[i][0];
            for(int j=0; j<N; j++){
                System.out.println("j:"+j);
                if(!isok) {
                   for(int k=0; k<N; k++) check[i][k]=false;  
                    break;
                }
                now=map[i][j];
                System.out.println("prev:"+prev+" now:"+now);
                if(Math.abs(now-prev)==1){
                    if(prev > now){
                        for(int k=0; k<L; k++){
                            if(j+k>=N || check[i][j+k] || now!=map[i][j+k]){
                                isok=false; break;
                            }
                        }
                        if(isok){
                            for(int k=0; k<L; k++)
                                check[i][j+k]=true;
                        }
                    }else{
                        System.out.println("ddddd");
                        for(int k=1; k<=L; k++){
                            System.out.println("j-k:"+(j-k));
                            System.out.println("check:"+(check[i][j-k]));
                        
                            if(j-k<0 || check[i][j-k] ||prev!=map[i][j-k]){
                                isok=false; break;
                            }
                        }
                        System.out.println("isok:"+isok);
                        if(isok){
                            for(int k=1; k<=L; k++)
                                check[i][j-k]=true;
                        }
                    }
                }
                else if(prev==now){

                }
                else {
                    isok=false; break;
                }

                prev=now;
            }
            if(isok) {
                ans++;
                System.out.println("여기 가능 ans:"+ans);
            }
        }

        check =new boolean[N][N];
        System.out.println("세로검사");
        for(int j=0; j<N; j++){ //vertical
            System.out.println("j:"+j);
            boolean isok=true;
            prev=now=map[0][j];
            for(int i=0; i<N; i++){
                System.out.println("i:"+i);
                if(!isok) {
                    for(int k=0; k<N; k++)
                        check[k][j]=false;
                    break;    
                }
                now=map[i][j];
                System.out.println("prev:"+prev+" now:"+now);
                if(Math.abs(now-prev)==1){
                    if(prev > now){
                        for(int k=0; k<L; k++){
                            if(i+k>=N || check[i+k][j] || now!=map[i+k][j]){
                                isok=false; break;
                            }
                        }
                        if(isok){
                            for(int k=0; k<L; k++)
                                check[i+k][j]=true;
                        }
                    }else{
                        for(int k=1; k<=L; k++){
                            if(i-k<0 || check[i-k][j] || prev!=map[i-k][j]){
                                isok=false; break;
                            }
                        }
                        if(isok){
                            for(int k=1; k<=L; k++)
                                check[i-k][j]=true;
                        }
                    }
                }
                else if(prev==now){

                }
                else {
                    isok=false; break;
                }
                prev=now;
            }
            if(isok) {
                ans++;
                System.out.println("여기 가능 ans:"+ans);
            }
        }

        System.out.println(ans);
    }
    
}