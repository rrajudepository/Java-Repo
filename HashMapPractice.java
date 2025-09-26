import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

class HASHMAP
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		//HashMap stores (key, value)
		
		HashMap<String, Integer> map = new HashMap<>();
		
		//Insertion
		map.put("India", 120);
		map.put("US", 40);
		map.put("China", 150);
		
		System.out.println(map); // print all key and  value {China=150, US=40, India=120}
		
		map.put("China", 180); // update china to 180 
		System.out.println(map);
		 
		map.put("china", 180); // add new key and value 
		System.out.println(map);
		
		if(map.containsKey("China")){
		    System.out.println("Key is prenet");
		}else{
		    System.out.println("Not present in map");
		}
		
		System.out.println(map.get("China")); //key exists
		System.out.println(map.get("Indonesia")); //print null
		
		
		
		
		//Iterator 
		
		int arr[] ={12,15,16,20,22};
		for(int i=0;i<arr.length;i++){
		    System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int val : arr){
		    System.out.print(val+ " ");
		}
		System.out.println();
		
		for( Map.Entry<String, Integer> val : map.entrySet()){
		    System.out.println(val.getKey()+" : "+val.getValue());
		}
		
		Set<String> keys = map.keySet(); //make a set of key values 
		
		for(String val : keys){
		    System.out.print(val+ " ");
		}
		System.out.println();
		
		
		//remove a key and value
		
		map.remove("china");
		System.out.println(map);
}
}
/*
Key Characteristics of HashMap:
   Stores key-value pairs.
   Keys are unique; values can be duplicated.
   No guaranteed order of elements (not sorted or insertion order).
   Allows one null key and multiple null values.
   Based on a hash table, offering average O(1) time complexity for put(), get(), and remove().



   Method	                  Description
   put(K key, V value)	      Adds or updates a key-value pair
   get(Object key)	          Returns the value for the given key
   remove(Object key)	      Removes key-value pair
   containsKey(key)	          Checks if key exists
   containsValue(val)	      Checks if value exists
   size()	                  Returns number of key-value pairs
   isEmpty()	              Checks if map is empty
   clear()                    Removes all entries
   keySet()	                  Returns a Set of all keys
   values()	                  Returns a Collection of all values
   entrySet()	              Returns a Set of key-value pairs (entries)




*/