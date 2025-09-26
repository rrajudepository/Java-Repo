//import java.util.*;
//import java.lang.*;
//import java.io.*;

class Strings
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    /*
		// your code goes here
		String name = "Tony stark";
		System.out.println(name);
		Scanner sc = new Scanner(System.in);
		
		String name2 = sc.nextLine();
		System.out.println("Your name is : "+ name2);
		
		String finalName = name+" @ " +name2; // add both strings 
		System.out.println(finalName);
		
		int i = finalName.length();
		System.out.println(i);
		
		//charAt
		for(i=0;i<name2.length();i++){
		    System.out.println(name2.charAt(i));
		}
		*/
		
		
		
		/*
		String name1 = "Tony";
		String name2 = "Zony";
		
		//s1==s2 : 0
		// s1>s2 : +ve value s1=hello, s2= cell0
		// s1<s2 : -ve value
		
		if(name1.compareTo(name2)==0){
		    System.out.println("Strings are same");
		}else if(name1.compareTo(name2)>0){
		    System.out.println("s1 is greter than s2");
		}else{
		    System.out.println("s1 is less than s2");
		}
		
		String sentence = "My name is Tony";
		String name = sentence.substring(11, sentence.length()); //11th index to last index substring
		System.out.println(name);
		System.out.println(sentence.substring(11)); // automatically goes to last index 
  		*/
  		
  		
  		//Strings in java are immutable i.e does not change 
  		
  		//String builder 
  		/*
  		String s ="h";
  		s=s+"ello"; //we can add  but can's replace characters
  		System.out.println(s);
  		StringBuilder sb = new StringBuilder("Rajkishor");
  		System.out.println(sb);
  		//char at index 0
  		System.out.println(sb.charAt(3));
  		sb.setCharAt(0,'r');
  		System.out.println(sb);// replace R  by r 
  		
  		sb.insert(0,'S'); //insert S at 0 index and shift all index next to it.
  		System.out.println(sb);
  		
  		sb.insert(3,'j');
  		System.out.println(sb);
  		
  		sb.delete(1,4); // delete index 1, 2, 3
  		System.out.println(sb);
  		
  		StringBuilder sb2= new StringBuilder("h");
  		sb2.append("e");
  		sb2.append("l");
  		sb2.append("lo");
  		System.out.println(sb2);
  		System.out.println(sb2.length() + " and " + sb.length());//print length
  		
  		
  		//reverse the character of string 
  		StringBuilder sb3= new StringBuilder("hello");
  		
  		for(int i=0;i<sb3.length()/2;i++){
  		    int front =i;
  		    int back=sb3.length()-1-i;
  		    char c1 = sb3.charAt(front);
  		    char c2 = sb3.charAt(back);
  		    sb3.setCharAt(front, c2);
  		    sb3.setCharAt(back, c1);
  		}
  		System.out.println(sb3);
  		
  		*/
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		

	}
}
