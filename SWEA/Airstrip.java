package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Airstrip {
    static int n;
    static int x;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token= new StringTokenizer(br.readLine());
         
        int tc=Integer.parseInt(token.nextToken());
        for(int t=1; t<=tc; t++) {
            token=new StringTokenizer(br.readLine());
            n=Integer.parseInt(token.nextToken());
            x=Integer.parseInt(token.nextToken());
             
            map=new int[n][n];
            boolean[][] check = new boolean[n][n];
             
            for(int i=0; i<n; i++) {
                token=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j]=Integer.parseInt(token.nextToken());
                }
            }// �Է� �Ϸ�
             
            int res=0;
             
            // ���� ����� ��
            int curh=0, preh=0;
            boolean able=true;
             
            for(int j=0; j<n; j++) {
                able=true;
                 
                a: for(int i=0; i<n; i++) {
                     
                    curh=map[i][j]; 
                     
                    if(i!= 0 && curh != preh) {
                         
                        if(Math.abs(curh-preh) > 1) { // ���� ���̰� 1�� �ʰ��� ��
                            able=false;
                            break a;
                        }
                         
                         
                        if(curh > preh) { // ���� ��
                             
                             
                            for(int k=1; k<=x; k++) { // x ��ŭ Ȯ��
                                 
                                // �������          ������ ���� �ƴϾ�                         �̹� ���� �Ǽ��Ѱ�
                                if(i-k < 0 || map[i-k][j] != preh || check[i-k][j]) {
                                    able=false;
                                    break a;
                                }
                            }
                             
                            if(able) { // ���� ���� ������ üũ
                                for(int k=1; k<=x; k++) {
                                    check[i-k][j]=true;
                                }
                            }
                             
                        }
                        else if(curh < preh) { // ���� ��
                            for(int k=0; k<x; k++) {
                                if(i+k >= n || map[i+k][j] != curh || check[i+k][j]) {
                                    able=false;
                                    break a;
                                }
                            }
                            if(able) {
                                for(int k=0; k<x; k++) {
                                    check[i+k][j]=true;
                                }
                            }
                        }
                    }
                     
                    preh=curh;
                }
                 
                if(able) {
                    res++;
                }
                 
            }
             
             
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    check[i][j]=false;
                 
             
             
             
            // ���� ����� ��
            for(int i=0; i<n; i++) {
                able=true;
                 
                a: for(int j=0; j<n; j++) {
                    curh=map[i][j]; 
                     
                    if(j!=0 && curh != preh) {
                         
                        if(Math.abs(curh-preh) > 1) {
                            able=false;
                            break a;
                        }
                         
                        if(curh > preh) { // ���� ��
                            for(int k=1; k<=x; k++) { // x ��ū Ȯ��
                                if(j-k < 0 || map[i][j-k] != preh || check[i][j-k]) {
                                     
                                    able=false;
                                    break a;
                                }
                            }
                            if(able) {
                                for(int k=1; k<=x; k++) {
                                    check[i][j-k]=true;
                                }
                            }
                        }
                        else if(curh < preh) { // ���� ��
                            for(int k=0; k<x; k++) {
                                if(j+k >= n || map[i][j+k] != curh || check[i][j+k]) {
                                    able=false;
                                    break a;
                                }
                            }
                            if(able) {
                                for(int k=0; k<x; k++) {
                                    check[i][j+k]=true;
                                }
                            }
                        }
                    }
                    preh=curh;
                }
                 
                if(able) {
                    res++;
                }
                 
            }
             
            System.out.println("#"+t+" "+res);
        }
 
    }
 
}