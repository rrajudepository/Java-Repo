import java.util.*;
import java.lang.*;
import java.io.*;

//abstarct = imagination no real existence 
abstract class Animal{
    
    Animal(){
        System.out.println("You are creating a new animal");
    }
    abstract void walk(); //can not have a body
    
    public void eat(){
        System.out.println("Animal eats");
    }
    
    
}

class Horse extends Animal{
    Horse(){
        System.out.println("Created a Horse");
    }
    public void walk(){
        System.out.println("Walk on 4 legs");
    }
}

class Chicken extends Animal{
    Chicken(){
        System.out.println("Created a  Chicken");
    }
    public void walk(){
        System.out.println("Walk on 2 legs");
    }
    
}
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Horse horse = new Horse();
		horse.walk();
		Chicken chicken = new Chicken();
		chicken.walk();

	}
}
