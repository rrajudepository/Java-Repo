import java.util.HashSet;
import java.util.Iterator; 

class HASHSET
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		HashSet<Integer> set = new HashSet<>();
		set.add(12);
		set.add(3);
		set.add(10);
		set.add(7);
		set.add(6);
		set.add(1);
		set.add(10); //set contains only unique element.
		int size = set.size(); //size =6 not 7
		System.out.println("Sise of set is : "+size);
		System.out.println(set); // print all elements [1, 3, 6, 7, 10, 12]
		if(set.contains(1)){
		    System.out.println("set contains 1");
		}
		if(!set.contains(2)){
		    System.out.println("Set does not contain 2");
		}
		
		set.remove(1);
		if(!set.contains(1)){
		    System.out.println("1 is deleted from set");
		}
		
		
		//Iterator in set => iterate the all element 
		Iterator it = set.iterator();
		
		//hasNext, hasMap
		//it.hasNext return true if element exist in set else false 
		//it.next give the next value of HashSet 
		while(it.hasNext()){
		    System.out.println(it.next());
		}
		
		

	}
}
/*
 Key Features of HashSet:
   => No duplicates allowed.
   => No guaranteed order of elements (neither sorted nor insertion order).
   => Allows null element (only one).
   => Offers constant-time performance for basic operations like add(), remove(), and contains() (average case).

     Method	                      Description
     add(E e)	                  Adds element to set
     remove(Object o)	          Removes the element
     contains(Object o)	          Checks if element exists
     size()	                      Returns the number of elements
     clear()	                  Removes all elements
     isEmpty()	                  Checks if set is empty
     iterator()	                  Returns an iterator over the set

*/