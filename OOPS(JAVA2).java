import java.util.*;
import java.lang.*;
import java.io.*;


//Polymorphism 



class Pen {
    String color;
    String type; //ball point, gel pen 
    
    public void write(){
        System.out.println("Writing something");
    }
    
    public void printColor(){
        System.out.println(this.color);
    }
}

class Student{
    String name;
    int age;
    
    
    //same function with different parameter (Polymorphism) => Compile time Polymorphism


    public void printInfo(String name){
        System.out.println("Name of the person : " + name);
    }
    public void printInfo(int age){
        System.out.println("Age of the person : "+ age);
    }
    public void printInfo(String name, int age){
        System.out.println("Name and age of the person : "+name+" ,"+ age);
    }
}

class OOPS 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		
		
		Student s1 = new Student(); //constructor called
		s1.name = "Ram";
		s1.age =23;
		s1.printInfo(s1.age);
		s1.printInfo(s1.name);
		s1.printInfo(s1.name, s1.age);
		
		

	}
}
