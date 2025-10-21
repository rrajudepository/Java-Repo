package DSAinJAVA.Lecture25_26_27;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class CollectionsDemo4 {
    public static void main(String[] args) {
        /*
         * Set
         * Collections of OBJECTS
         * does not contains duplicate value
         * can not accessed by index
         * 
         */
        /*
         * HashSet
         * Data staructure used here is HashMap
         * No order gaurantee
         * 
         */

         Set<Integer> set1 = new HashSet<>();
         set1.add(12);
         set1.add(11);
         set1.add(33);
         set1.add(4);

         Set<Integer> set2 = new HashSet<>();
         set2.add(11);
         set2.add(9);
         set2.add(88);
         set2.add(10);
         set2.add(5);
         set2.add(12);

         //Union of set1 and set2
         set1.addAll(set2);
         System.out.println("After Union");
         set1.forEach((Integer val)-> System.out.print(val+" "));
         System.out.println("\n\n");

         System.out.println("Size of set1: "+set1.size());
         System.out.println("Is set empty: "+ set1.isEmpty());
         System.out.println("Set1 contains element 88: "+set1.contains(88));
         set1.remove(11);
         System.out.println("After removinf 11 set1 is: ");
         set1.forEach((Integer val)-> System.out.print(val+" "));
         System.out.println("\n\n");


         //Intersetion of set1 and set2
         set1 = new HashSet<>();
         set1.add(12);
         set1.add(11);
         set1.add(33);
         set1.add(4);

         set1.retainAll(set2);
         System.out.println("After Intersetion");
         set1.forEach((Integer val)-> System.out.print(val+" "));
         System.out.println("\n\n");

         //difference of set1 and set2
         set1 = new HashSet<>();
         set1.add(12);
         set1.add(11);
         set1.add(33);
         set1.add(4);

         set1.removeAll(set2);
          System.out.println("After Difference");
         set1.forEach((Integer val)-> System.out.print(val+" "));
         System.out.println("\n\n");

         /*
          * LinkedHashSet
          * uses LinkedHashMap
          * 
          */

          System.out.println("\n\nImplementation of LinkedHashSet");
          Set<Integer> set3 = new LinkedHashSet<>();
          set3.add(2);
          set3.add(11);
          set3.add(9);
          set3.add(88);
          set3.add(10);
          set3.add(5);
          set3.add(12);
          System.out.println("Printing set3 using forEach");
          set3.forEach((Integer val)->System.out.print(val+" "));
          System.out.println("\n\nPrinting set3 using Iterator");
          Iterator<Integer> it = set3.iterator();
          while(it.hasNext()){
              System.out.print(it.next()+" ");
          }

          System.out.println("\n\n");

          /*
           * TreeSet (Internally uses TreeMap and can not store null value)
           */

          Set<Integer> set4 = new LinkedHashSet<>();
          set4.add(2);
          set4.add(11);
          set4.add(9);
          set4.add(88);
          set4.add(10);
          set4.add(5);
          set4.add(12);
          System.out.println("Printing set4 using forEach");
          set4.forEach((Integer val)->System.out.print(val+" "));
          System.out.println("\n\nPrinting set4 using Iterator");
          it = set4.iterator();
          while(it.hasNext()){
              System.out.print(it.next()+" ");
          }

          System.out.println("\n\n");

    }
}
