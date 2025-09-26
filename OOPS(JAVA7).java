import java.util.*;
import java.lang.*;
import java.io.*;
class Student{
    String name;
    
    static String school;
    
    public static void changeSchool(String newschool){ //chnage common to all 
        school = newschool;
    }
}
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Student.school = "IIT Patna"; //true for all common to all define by class name
		Student student1 = new Student();
		Student student2 = new Student();
		student1.name = "Ram kapoor";
		student2.name = "Mohit Bansal";
		
		System.out.println("Student1 information => name : "+ student1.name+" , School :"+student1.school);
		System.out.println("Student2 information => name : "+ student2.name+" , School :"+student2.school);
		
		
		
		Student.changeSchool("IIT Bombay");
		
		System.out.println("Student1 information => name : "+ student1.name+" , School :"+student1.school);
		System.out.println("Student2 information => name : "+ student2.name+" , School :"+student2.school);

		

	}
}
