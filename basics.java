import java.util.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		/*
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = a+b;
		System.out.println(sum);
		
		int age = sc.nextInt();
		if(age>18){
		    System.out.println("Adult");
		}else{
		    System.out.println("Not adult");
		}
		//Conditional statements 
		
		int x = sc.nextInt();
		
		if(x%2==0){
		    System.out.println("Even number");
		}else{
		    System.out.println("Odd Number");
		}
		
		 a= sc.nextInt();
		 b = sc.nextInt();
		
		if(a==b){
		    System.out.println("Equal");
		}else if(a>b){
		    System.out.println("a is greater than b");
		}else{
		    System.out.println("a is less than b");
		}
		
		int c = sc.nextInt();
		if(c==1){
		    System.out.println("Hello");
		}else if(c==2){
		    System.out.println("Namaste");
		}else if(c==3){
		    System.out.println("Bonjour");
		    
		}else{
		    System.out.println("Wrong number");
		}
		
		*/
		
		//Switch conditional statements
		
		int button = sc.nextInt();
		
		switch(button){
		    case 1 : System.out.println("Hello");
		    break;
		    case 2 : System.out.println("Namste");
		    break;
		    case 3 : System.out.println("Bonjour");
		    break;
		    default : System.out.println("Invalid button");
		}
		
		switch(button){
		    case 1 : System.out.println("Hello");
		    break;
		    case 2 : System.out.println("Namste");
		    case 3 : System.out.println("Bonjour");
		    break;
		    default : System.out.println("Invalid button");
		}
		
		
		for(int i=0;i<=4;i++){
		    System.out.println("Hello Rajkishor");
		}
		
		for(int i=1;i<=10;i++){
		    System.out.print(i+" ");
		}
		System.out.println();
		
		
		int i=1;
		while(i++<=10){
		    System.out.print(i+ " ");
		   // i++;
		}
		System.out.println();
		i=1;
		do{
		    System.out.print(i+" ");
		    i++;
		}while(i<11);
		System.out.println();
		
		//print sum of first n natural number. 
		int sum=0;
		int n=sc.nextInt();
		for(i=1;i<n;i++){
		    sum+=i;
		}
		System.out.println("Sum of "+ n + " number is : "+sum);
		
		for( i=0;i<4;i++){
		   /* for(int j=1;j<=20;j++){
		        System.out.print("*");
		    }*/
		    System.out.print("**********************");
		    System.out.println();
		}


		sc.close();
		

	}
}
