package DSAinJAVA.Lecture25_26_27;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;

public class CollectionsDemo3 {
    public static void main(String[] args){
       //HashMap Implementations
       //Do not maintains the insertion order
       /*
        * add : O(1)
        * remove : O(1)
        * get : O(1)
        */

        Map<Integer, String> rollNoVsName = new HashMap<>();
        rollNoVsName.put(122, "Shubham");
        rollNoVsName.put(123,"Ramesh");
        rollNoVsName.put(124,"Raju");
        rollNoVsName.put(125, "Rajesh");
        rollNoVsName.put(126, "Hitesh");

        for(Map.Entry<Integer, String> entry : rollNoVsName.entrySet()){
            int roll = entry.getKey();
            String name = entry.getValue();
            System.out.println("roll: "+roll+" name: "+name);
        }
        System.out.println("\n\n");
        rollNoVsName.putIfAbsent(123, "Suresh");//if 123 key is absent then it will create key and value else leave
        rollNoVsName.putIfAbsent(127, "Shyam"); //create new key and value
        rollNoVsName.putIfAbsent(124, "raju" ); //no effect in map

        for(Map.Entry<Integer, String> entry : rollNoVsName.entrySet()){
            int roll = entry.getKey();
            String name = entry.getValue();
            System.out.println("roll: "+roll+"name: "+name);
        }

        System.out.println("\n\n");

        System.out.println("isEmpty(): "+ rollNoVsName.isEmpty());
        System.out.println("size of map: "+ rollNoVsName.size());
        System.out.println("Is it contains key 125: "+ rollNoVsName.containsKey(125));
        System.out.println("Is it contains key 129: "+ rollNoVsName.containsKey(129));
        System.out.println("Get the value of key 123 "+rollNoVsName.get(123));
        rollNoVsName.remove(123);

        System.out.println("\n\n");
         
        for(Map.Entry<Integer, String> entry : rollNoVsName.entrySet()){
            int roll = entry.getKey();
            String name = entry.getValue();
            System.out.println("roll: "+roll+"name: "+name);
        }
        System.out.println("\n\n");
        System.out.println("Printing value using foreach method: ");
        rollNoVsName.forEach((Integer key, String val)->System.out.println("key: "+key+" value: "+val));
        System.out.println("\n\nKey Set is given: ");
        //keyset
        
        for(Integer key: rollNoVsName.keySet()){
            System.out.println("Key: "+ key);
        }
        System.out.println("\n\n Value of map: ");

        //values
        Collection<String> values = rollNoVsName.values();
        for(String value: values){
            System.out.println("Value: "+ value);
        }
        System.out.println("\n\n");

        /*
         * LinkedHashMap
         * Similar to HashMap. but also using double linkedlist
         */

         Map<Integer, String> map = new LinkedHashMap<>();
         map.put(1,"A");
         map.put(2,"B");
         map.put(3,"C");
         map.put(4,"D");
         map.put(5,"E");
         map.forEach((Integer key, String val)->System.out.println("Key: "+key+" Value: "+val));


         System.out.println("\n\nBelow is the normal HashMap output");
         Map<Integer, String> map2 = new HashMap<>();
         map2.put(1,"A");
         map2.put(2,"B");
         map2.put(3,"C");
         map2.put(4,"D");
         map2.put(5,"E");

         map.forEach((Integer key, String val)-> System.out.println("Key: "+key+" value"+val));
         System.out.println("\n\n");

         /*
          * TreeMap
          * Map is sorted 
          * Based on Red black tree(self balanced BST)
          * insert, remove, get operations: O(n)
          */
          System.out.println("\n\nTreeMap impementation: ");
          Map<Integer, String> map3 = new TreeMap<>((Integer key1, Integer key2)->key2-key1);
          map3.put(23, "A");
          map3.put(24, "B");
          map3.put(21, "C");
          map3.put(22, "D");
          System.out.println("Decreasing order of key");
          map3.forEach((Integer key, String val)->System.out.println("Key: "+key+" Value: "+val));
          System.out.println("\n\n");

          Map<Integer, String> map4 = new TreeMap<>();
          map4.put(23, "A");
          map4.put(24, "B");
          map4.put(21, "C");
          map4.put(22, "D");
          System.out.println("Increasing order of key: ");
          map4.forEach((Integer key, String val)->System.out.println("Key: "+key+" Value: "+val));

          System.out.println("\n\n");
           





    }
}
/*
 * Term	                  Type	                        Description
   Map	                  Interface	                    Defines key–value behavior
   HashMap	              Class	                        Implements Map using hash tables
   Code style      Map<K, V> var = new HashMap<>();    	Recommended — allows flexibility
 * 
 */