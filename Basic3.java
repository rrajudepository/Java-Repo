import java.util.*;
//import java.lang.*;
//import java.io.*;

class ARRAYS 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		//Arrays in java 
	    //int[] num = new int[10];
	    /*int num[] = new int[10]; // both are same 
		for(int i=1;i<=10;i++){
		    num[i-1]=i*10;
		}
		for(int i=1;i<=10;i++){
		    System.out.print(num[i-1] + " ");
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int numbers[] = new int[size];
		//store 0 automatically 
		for(int i=0;i<size;i++){
		    System.out.print(numbers[i]+" ");// print 0
		}
		System.out.println();
		for(int i=0;i<size;i++){
		    numbers[i]=i+1;
		}
		for(int i=0;i<size;i++){
		    System.out.print(numbers[i]+" "); //print 1 2 3 4 5 ....
		}
		System.out.println();
		
		*/
		
		
		
		//2D arrays concept 
		/*Scanner sc = new Scanner(System.in);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		int nums[][] = new int[a][b];
		int n=0;
		for(int i=0;i<a;i++){
		    for(int j=0;j<b;j++){
		        nums[i][j]=n++;
		    }
		    
		}
		for(int i=0;i<a;i++){
		    for(int j=0;j<b;j++){
		        System.out.print(nums[i][j]+ " ");
		    }
		    System.out.println();
		}*/
		/*
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int nums[][] = new int[a][b];
		int n=0;
		for(int i=0;i<a;i++){
		    for(int j=0;j<b;j++){
		        nums[i][j]=sc.nextInt();
		    }
		    
		}
		for(int i=0;i<a;i++){
		    for(int j=0;j<b;j++){
		        System.out.print(nums[i][j]+ " ");
		    }
		    System.out.println();
		}
		
		
		*/
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int nums[][] = new int[a][b];
		for(int i=0;i<a;i++){
		    for(int j=0;j<b;j++){
		        nums[i][j]=sc.nextInt();
		    }
		    
		}
		int search = sc. nextInt();
		boolean found=false;
		for(int i=0;i<a;i++){
		    for(int j=0;j<b;j++){
		        if(nums[i][j]==search){
		            System.out.println("Numbers found at index : ( "+i+" , "+j+" )");
		            found = true;
		            
		        }
		    }
		    
		}
		if(!found){
		    System.out.println("Number not found in 2D array");
		}


		sc.close();
		

	}
}
