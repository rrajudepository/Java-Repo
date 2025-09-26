//import java.util.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		//bit manipulation

		
		//get bit
		int n =5; //0101
		int pos=3; //4th bit 0
		int bitmask = 1<<3;
		if((n & bitmask)==0){
		    System.out.println("0");
		}else{
		    System.out.println("1");
		}
		System.out.println(pos);
		
		//set bit
		
		 n=5;
		 pos=1; //2nd bit 0 make it 1 
		bitmask=1<<1;
		int newNumber = bitmask | n;
		System.out.println(newNumber);
		
		//clear bit 
		
		n=5;
		pos=2;
		bitmask=1<<2;
		newNumber= ~(bitmask)&n;
		System.out.println(newNumber);
		
		

	}
}
