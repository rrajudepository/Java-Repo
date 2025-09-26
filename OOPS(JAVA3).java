import java.util.*;
import java.lang.*;
import java.io.*;

//Inheritance 

//parent class
class Shape{
    String color;
    
    public void area(){
        System.out.println("display area");
    }
}
//child class 
class Triangle extends Shape{
    
    public void area(int l , int h){
        System.out.println("Area of triangle is : " + l*h/2);
    }
    
}

class EquilateralTriangle extends Triangle{
    public void area(int l, int h){
        System.out.println("Area  of equialteral triangle is : "+ l*h/2);
    }
}

class Circle extends Shape{
    public void area(int r){
        System.out.println("Area of Circle is : "+ 3.14*r*r);
    }
}

class OOPS 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Triangle t1 = new Triangle();
		t1.color = "red";
		t1.area();
		t1.area(2,6);
		
		EquilateralTriangle t2 =new EquilateralTriangle();
		t2.color = "red";
		t2.area(4,9);
		System.out.println(t2.color);
		
		Circle c = new Circle();
		c.color = "blue";
		c.area(4);
		System.out.println("Color of circle is : "+ c.color);
		

	}
}
