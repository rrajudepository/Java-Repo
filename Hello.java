import java.util.*;
//import java.lang.*;
//import java.io.*;

class Hello{
    public static int sum(int a, int b){
        System.out.println("This is Rajkishor Ranjan Kumar. I am doing java coding");
        return a+b;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       // System.out.println("Hello World");
       // System.out.println("My name is Rajkishor Ranjan"); 
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum2 = sum(a,b);
        System.out.println(sum2);
        /*String name = sc.nextLine();
        System.out.println(name);*/


        sc.close();

    }
}