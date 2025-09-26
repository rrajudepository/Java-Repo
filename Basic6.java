import java.util.ArrayList;
import java.util.Collections;

class ARRAYLIST
{
	public static void main (String[] args)
	{
		// Array = size fixed
		//ArrayList = dynamic size 
		//Integer | Float | String | Boolean 
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		//ArrayList<String> list2 = new ArrayList<String>();
		//ArrayList<Boolean> list3 = new ArrayList<Boolean>();
		list1.add(0);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println(list1); //print all elements of ArrayList
		
		int element = list1.get(1); //will give index 1 element;
		
		
		list1.add(1,5); //add 5 at index 1 and shift others to the next
		System.out.println(list1);
		System.out.println(element);
		
		list1.set(2,6); // replace 2nd index element to 6
		System.out.println(list1);
		
		list1.remove(2); // remove element 2 
		System.out.println(list1);
		
		int size=list1.size();
		System.out.println(size);
		
		for(int i=0;i<list1.size();i++){
		    System.out.println(list1.get(i));
		}
		
		//sorting
		Collections.sort(list1); 
		System.out.println(list1);
		

	}
}
