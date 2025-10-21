package DSAinJAVA.Lectores22_23_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Basic2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		/* 
         int[] dp = new int[10];
         Arrays.fill(dp, -1); // all velue will be -1 now.
         String s = "Rajkishor Ranjan";
         ArrayList<Integer> num = new ArrayList<Integer>();
         for(int i=1;i<=5;i++){
         	num.add(i*10);
         }
         int len1= dp.length;
         int len2= s.length();
         int len3= num.size();

         List<Integer> values = new ArrayList<>();
         Collections.addAll(values, 3, 4, 8, 9, 10, 5, 2, 1, 7, 6, 11);
         values.add(12);           // adds 12 at the end
         values.add(0, 99);        // adds 99 at index 0 and shift every element to next of it
         values.addAll(List.of(13, 14)); // adds multiple elements
         values.remove(3);         // removes element at index 3
         values.remove(Integer.valueOf(10)); // removes the value 10 (not index)
         values.removeAll(List.of(2, 4));    // removes all occurrences of 2 and 4
         values.set(2, 100); // replaces element at index 2 with 100

         System.out.println(values);
         */

         /*
         // your code goes here
        List<Integer> values = new ArrayList<>();
        Collections.addAll(values, 3, 4, 8, 9, 10, 5, 2, 1, 7, 6, 11);
        System.out.println(values);
        values.add(12);
        values.add(0,4);
        values.add(1,3);
        System.out.println(values);
        values.addAll(List.of(15,14,16));
        System.out.println(values);
        
        values.remove(1);
        values.remove(Integer.valueOf(4));
        System.out.println(values);
        values.add(0,4);
        System.out.println(values);
        values.set(0,13);
        System.out.println(values);


         */

         // your code goes here
		List<List<Integer>> matrix = new ArrayList<>();

        // Add inner lists (rows)
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9, -1)));

       // Print matrix
        System.out.println(matrix);
        System.out.println("Element with 2 row and 3 column: "+matrix.get(1).get(2));
        System.out.println("3rd row elelments: "+matrix.get(2));
        
        matrix.get(2).set(2, 10); //update 3rd row and 3rd column Index 
        System.out.println(matrix);
        
        //initialization one dimention ArrayList with value -1
        
        System.out.println("Implementation of 1D ArrayList");
        int n = 5;
        List<Integer> dp1 = new ArrayList<>(Collections.nCopies(n, -1));
        System.out.println(dp1);
        dp1.set(2, 10);   // updates 3rd element
        System.out.println(dp1);  // [-1, -1, 10, -1, -1]
        
        //Two dimension ArrayList
        System.out.println("Implementation of 2D ArrayList");
        
         n = 3;
         int m = 4;
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
           dp.add(new ArrayList<>(Collections.nCopies(m, -1)));
        }
        
        System.out.println(dp);
        // Output: [[-1, -1, -1, -1], [-1, -1, -1, -1], [-1, -1, -1, -1]]

        dp.get(1).set(2, 7);  // set dp[1][2] = 7
        System.out.println(dp.get(1).get(2)); // prints 7
        System.out.println(dp);




	}
}



/*
Aspect                     List<Integer> values = new ArrayList<>();                           ArrayList<Integer> values = new ArrayList<>();

Type of variable           List (interface)                                                    ArrayList (concrete class)

Flexibility                ✅ More flexible — can change implementation easily                ❌ Less flexible — tied to ArrayList implementation

Can switch to              LinkedList, Vector, CopyOnWriteArrayList, etc.                      ❌ Not easily

Best Practice              ✅ Recommended (program to an interface)                            ⚠️ Only use if you need ArrayList-specific methods

Available methods          Only those in List interface                                         All methods of ArrayList, including extra ones

*/




/*
Declaration                                    Access Level                            Usable From
public static                                  Everywhere                              Any package/class
static (default)                               Package-private                         Only within same package
private static                                 Only inside same class                  Not visible anywhere else
protected static                               Within same package + subclasses        Rare for static methods
*/
