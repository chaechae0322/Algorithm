package sds_algorithm.day03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Trie
 */
public class B9202_Boggle {
   static TrieNode root;
   static char[][] grid;
   static boolean[][] visited;

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      root = new TrieNode();
      hitList=new ArrayList<>();
      for(int i=0; i<N; i++) {
         String word = br.readLine();
         insert(word);
      }

      br.readLine();
      N=Integer.parseInt(br.readLine());
      grid=new char[4][4];

      StringBuilder sb = new StringBuilder();

      for(int test=0; test<N; test++) {
         for(int i=0; i<4; i++) {
            grid[i]=br.readLine().toCharArray();
         }

         findmaxScore=0; findcnt=0; findmaxWord="";

         visited=new boolean[4][4];
         for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
               if(root.hasChildren(grid[i][j])) {

                  
                  visited[i][j]=true;
                  sb.append(grid[i][j]);
                  dfs(j, i, sb, 1, root.getChildren(grid[i][j]));
                  visited[i][j]=false;
                  sb.delete(0, sb.length());
               }
            }
         }
         clearHit();

         System.out.println(findmaxScore+" "+findmaxWord+" "+findcnt);
         br.readLine();
      }
   }
   static ArrayList<TrieNode> hitList;
   private static void clearHit() {
      for(int i=0; i<hitList.size(); i++)
         hitList.get(i).isHit=false;
      hitList.clear();
   }

   static int[] dx= {1,1,1,0,-1,-1,-1,0};
   static int[] dy= {-1,0,1,1,1,0,-1,-1};
   static int[] score = {0,0,0,1,1,2,3,5,11};
   private static void dfs(int x, int y, StringBuilder sb, int len, TrieNode node) {
      
      // 목적지 인가
      if(node.isEnd && !node.isHit) {
         
         // 값 갱신
         findcnt++;
         String word = sb.toString();
         
         findmaxScore += score[word.length()];
         
         if(word.length() > findmaxWord.length()) {
            findmaxWord=word;
         }else if(word.length() == findmaxWord.length()) {
            if(word.compareTo(findmaxWord)<0) { // 앞에꺼보다 뒤에께 더 사전순이다 = 마이너스나옴
               findmaxWord=word;
            }
         }
         
         hitList.add(node);
         node.isHit=true;
         
      }
      
      // 갈수있는곳 순회
      int tx=0, ty=0;
      for(int i=0; i<8; i++) {
         tx=x+dx[i];
         ty=y+dy[i];
         if(tx<0||ty<0||tx>=4||ty>=4||visited[ty][tx]) continue;
         if(node.hasChildren(grid[ty][tx])) {
            
            visited[ty][tx]=true;
            sb.append(grid[ty][tx]);
            dfs(tx, ty, sb, len+1, node.getChildren(grid[ty][tx]));
            sb.deleteCharAt(sb.length()-1);
            visited[ty][tx]=false;
         }
         
      }

   }
   static int findcnt;
   static int findmaxScore;
   static String findmaxWord;

   private static void insert(String word) {
      TrieNode current = root;
      for(int i=0; i<word.length(); i++) {
         char c= word.charAt(i);
         if(!current.hasChildren(c)) {
            current.children[c-'A']=new TrieNode();
         }
         current = current.getChildren(c);
      }
      current.isEnd=true;
   }
   
   static class TrieNode {
      TrieNode[] children = new TrieNode[26];
      boolean isEnd;
      boolean isHit;
      TrieNode getChildren(char c) {
         return children[c-'A'];
      }
      boolean hasChildren(char c) {
         return children[c-'A']!=null;
      }
   }
}

