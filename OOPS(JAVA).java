import java.util.*;
import java.lang.*;
import java.io.*;

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
    
    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
    
    //Constructor (Non Parametrized)
    
    Student(){
        System.out.println("Constructor called");
    }
    
    //Constructor (Parametrized)
    Student(String name, int age){
        System.out.println("Constructor called");
        this.name = name;
        this.age = age;
    }
    
    //Copy constructor
    Student(Student s2){
        this.name = s2.name;
        this.age=s2.age;
    }
}

class OOPS 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Pen pen1 = new Pen();
		pen1.color = "blue";
		pen1.type = "gelPen";
		pen1.write();
		Pen pen2 = new Pen();
		pen1.color = "black";
		pen1.type = "ballPen";
		
		pen1.printColor();
		pen2.printColor();
		
		Student s1 = new Student(); //constructor called
		Student s2 = new Student(); //constructor called
		s1.name = "Ram";
		s1.age =23;
		s2.name = "Shyam";
		s2.age = 26;
		s1.printInfo();
		s2.printInfo();
		
		Student s3 = new Student("Mohan", 30);
		s3.printInfo();
		
		Student s4 =  new Student(s2);
		s4.printInfo();
		

	}
}
