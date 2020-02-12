
package beakjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * B1022_소용돌이예쁘게출력하기
 * 2020.02.03
 */
public class B1022_소용돌이예쁘게출력학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int r2=sc.nextInt();
        int c2=sc.nextInt();

        int dist=0;
        int offset=1;

        Queue<Integer> q=new LinkedList<>();
        int maxv=0, val=0;
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                offset=1;
                dist=0;
                dist=Math.max(Math.abs(i-0), Math.abs(j-0));
                for(int k=1; k<=dist; k++){
                    offset+=8*k;
                }

                if(i==dist&&j==dist){
                    val=offset;
                    //System.out.print(offset+" ");
                }
                else if(i==dist && j!=dist){
                    val=offset-(dist-j);
                    //System.out.print((offset-(dist-j))+" ");
                }
                else if(j==-dist && i!=dist){
                    val=offset-(dist*2)-(dist-i);
                    //System.out.print((offset-(dist*2)-(dist-i))+" ");
                }
                else if(i==-dist && j!=dist){
                    val=offset-(dist*4)-(j+dist);
                    //System.out.print((offset-(dist*4)-(j+dist))+" ");
                }
                else {
                    val=offset-(dist*6)-(i+dist);
                    //System.out.print((offset-(dist*6)-(i+dist))+" ");
                }
                maxv=Math.max(val, maxv);
                q.add(val);
            }
            //System.out.println();
        }

        int maxidx=1; //최대공백
        while(maxv/10>0){
            maxidx++;
            maxv/=10;
        }
        int idx=1;
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                idx=1;
                val=q.peek();
                while(val/10>0){
                    idx++;
                    val/=10;
                }
                for(int k=0; k<(maxidx-idx); k++)
                    System.out.print(" ");
                System.out.print(q.poll()+" ");
            }
            System.out.println();
        }
    }
    
}