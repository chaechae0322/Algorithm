package BOJ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3425_고스택 {
   static ArrayList<String> orderList;
   static ArrayList<Integer> numList;
   static int[] stack;
   static int[] refst;
   static long LIMIT = 1000000000;
   static int top=-1;
   static int numindex=0;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num=0, n=0;
      String order="";
      orderList=new ArrayList<>();
      numList=new ArrayList<>();
      stack=new int[10001];
      refst=new int[10001];
      while(true) {
         top=-1;
         reftop=-1;
         orderList.clear();
         numList.clear();
         for(;;) {
            order=sc.next();
            if(order.equals("QUIT")) return;
            if(order.equals("END")) break;

            if(order.equals("NUM")) {
               num=sc.nextInt();
               //refpush(num);
               numList.add(num);
            }
            
            orderList.add(order);
         }

         n=sc.nextInt();
         for(int i=0; i<n; i++) {
            top=-1;
            numindex=0;
            num=sc.nextInt();
            push(num);
            calc();
         }
         //sc.next();
         System.out.println();
      }

   }
   private static void calc() {
      int a=0, b=0;
      long res=0;
      for(String order : orderList) {
         
    	 if(order.equals("NUM")) {
             push(numList.get(numindex++));
             continue;
    	 }
    	  
         if(isEmpty()) {
            System.out.println("ERROR");
            return;
         }

         switch (order) {
         case "POP":
            pop();
            break;
         case "INV":
            stack[top]=-stack[top];
            break;
         case "DUP":
            push(stack[top]);
            break;
         case "SWP":
            if(!isCal()) {
               System.out.println("ERROR");
               return;
            }
            int tmp=stack[top];
            stack[top]=stack[top-1];
            stack[top-1]=tmp;
            break;
         case "ADD":
            if(!isCal()) {
               System.out.println("ERROR");
               return;
            }
            a=pop();
            b=pop();
            res=(long)a+b;
            if(Math.abs(res)>LIMIT) {
               System.out.println("ERROR");
               return;
            }
            push((int)res);
            break;
         case "SUB":
            if(!isCal()) {
               System.out.println("ERROR");
               return;
            }
            a=pop();
            b=pop();
            res=b-a;
            if(Math.abs(res)>LIMIT) {
               System.out.println("ERROR");
               return;
            }
            push((int)res);
            break;
         case "MUL":
            if(!isCal()) {
               System.out.println("ERROR");
               return;
            }
            a=pop();
            b=pop();
            res=a*(long)b;
            
            if(Math.abs(res)>LIMIT) {
               System.out.println("ERROR");
               return;
            }
            push((int)res);
            break;
         case "DIV":
            if(!isCal()) {
               System.out.println("ERROR");
               return;
            }
            a=pop();
            b=pop();
            if(a==0) {
               System.out.println("ERROR");
               return;
            }
            res=(int)Math.abs(b)/Math.abs(a);
            if(a<0&&b>=0 || a>0&&b<0) res=-res;
            
            if(Math.abs(res)>LIMIT) {
               System.out.println("ERROR");
               return;
            }
            push((int)res);
            break;
         case "MOD":
            if(!isCal()) {
               System.out.println("ERROR");
               return;
            }
            a=pop();
            b=pop();
            if(a==0) {
               System.out.println("ERROR");
               return;
            }
            res=(int)Math.abs(b)%Math.abs(a);
            if(b<0) res=-res;
            
            if(Math.abs(res)>LIMIT) {
               System.out.println("ERROR");
               return;
            }
            push((int)res);
            break;
         default:
            break;
         }
         
      }
      if(top!=0) {
         System.out.println("ERROR");
         return;
      }else System.out.println(pop());

   }

   private static boolean isCal() {
      return top>0;
   }
   private static boolean isEmpty() {
      return top==-1;
   }
   private static int pop() {
      return stack[top--];
   }
   private static void push(int num) {
      stack[++top]=num;
   }
   static int reftop=-1;
   private static void refpush(int num) {
      refst[++reftop]=num;
   }
}