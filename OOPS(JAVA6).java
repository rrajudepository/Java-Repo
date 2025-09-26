import java.util.*;
import java.lang.*;
import java.io.*;

interface Animal{
    int eyes =2; //accessible to all and true for all animal(static i.e fixed value) 
    public void walk();
    
    
}

interface Herbivore{
    String food ="Veg";
    
}
class Horse implements Animal, Herbivore{
    public void walk(){
        System.out.println("Walk on 4 legs");
    }
}
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Horse horse = new Horse();
		horse.walk();
		System.out.println("horse's eyes is : "+ horse.eyes);
		System.out.println("Food of horse is : "+ horse.food);

	}
}
