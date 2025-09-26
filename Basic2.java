import java.util.*;

class Basic2
{
    public static void printMyName(String name){
        System.out.println(name);
        return;
    }
    public static int sum(int a, int b){
        return a+b;
    }
    
    public static int fact(int n){
        if(n<0){
            System.out.println("Factorial of negative number does not exist");
            return -1;
        }
        if(n==1 || n==0) return 1;
        return n*fact(n-1);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		printMyName(name);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = sum(a,b);
		System.out.println("Sum of a and b is "+sum);
		/*int n = sc.nextInt();
		int factN=fact(n);
		if(n>=0){
		    System.out.println("Factorial of "+ n + " is : "+factN);
		    
		}*/
		


		sc.close();

	}
}
