package DSAinJAVA.Lectores22_23_24;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Collections;
//import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class CollectionsDemo {
    public static void main(String[] args){
        //Use of Iterator and forEach()
        /*
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);

        //Using Iterator
        Iterator<Integer> it = values.iterator();

        while(it.hasNext()){
            int value = it.next();
            System.out.print(value+" ");
            if(value==3){
                it.remove(); //removed from list values
            }
        }
        System.out.println("\n\n");
        for(int val: values){
            System.out.print(val+" ");
        }
        System.out.println("\n\n");
        //using forEach method
        values.forEach((Integer val) -> {
            System.out.print(val+" ");
        });

        System.out.println("\n\n");

       */


       /* 
       List<Integer> values = new ArrayList<>();
       Collections.addAll(values, 1,2,3,4,6,7,8,9,10);
       System.out.println("Size of list: "+values.size());
       System.out.println("isEmpty(): "+values.isEmpty());
       System.out.println("contailns 5: "+values.contains(5));

       values.add(5);
       System.out.println("After adding 5, contains 5: "+values.contains(5));

       values.remove(3);
       System.out.println(values);
       values.remove(Integer.valueOf(3));
       System.out.println(values);

       Stack<Integer> stack = new Stack<>();
       stack.add(11);
       stack.add(12);
       stack.add(13);
       System.out.println("Stack: "+stack);
       values.addAll(stack);
       System.out.println("values after adding stack: "+values);
       System.out.println("Stack is available in values: "+values.containsAll(stack));
       values.remove(Integer.valueOf(12));
       System.out.println("Stack is available in values: "+values.containsAll(stack));
       values.removeAll(stack);
       System.out.println(values);
       values.clear();
       System.out.println("values is empty after clear(): "+values.isEmpty());
       stack.clear();
       System.out.println("Stack is empty after clear(): "+stack.isEmpty());
       */

       /* *
       List<Integer> values = new ArrayList<>();
       Collections.addAll(values, 1,3,4,7,6,5,2,10,9,8);
       System.out.println("Max value: "+Collections.max(values));
       System.out.println("Min value: "+Collections.min(values));
       Collections.sort(values);
       System.out.println("Sorted values: ");
       values.forEach((Integer val) -> {
        System.out.print(val+" ");
       });

       */

      /* 
       Queue<Integer> queue = new LinkedList<>();
       Collections.addAll(queue, 1,3,4,2,7,6);
       queue.add(5);
       System.out.println("Queue: "+queue);
       System.out.println("Top element: "+queue.peek());
       int top = queue.poll(); //remove the top element
       int top2 = queue.remove();//same as poll()
       System.out.println("Removed elements: "+top+" and "+top2);

       */


       //Priority Queue is based on two types of heaps.
       //1.Min-Heap: smallest element at the top
       //2.Max-Heap: Largest element ar the top
       //Store element in binary heap structure 
       //not guarantee to store in sorted order but poll() will remove elments in sorted order

       //Min Heap implementations
      PriorityQueue<Integer> minPQ =  new PriorityQueue<>();
      Collections.addAll(minPQ,10,4,6,2,8,12,14,16,18,20);
      minPQ.add(5);
      System.out.println(minPQ); //no guarantee of sorted order

      //Printing values using lambda expression
      System.out.println("Min-Heam priority queue elements in sorted order: "); // no gaurantee of sorted order
      minPQ.forEach((Integer val)-> System.out.print(val+" "));
      System.out.println("\n\n");
      System.out.println("Removing elements from min heap in sorted order: ");
      while(!minPQ.isEmpty()){//give lements in sorted order
        System.out.print(minPQ.poll()+" ");
      }
      System.out.println("\n\n");
      

      //Max Heap implementation
      PriorityQueue<Integer> maxPQ =  new PriorityQueue<>((Integer a, Integer b)-> b-a);
      Collections.addAll(maxPQ, 10,4,6,2,8,12,14,16,18,20);
      maxPQ.add(5);
      System.out.println(maxPQ);

      //Printing values using lambda expression
      System.out.println("Max-Heam priority queue elements in sorted order: ");
      maxPQ.forEach((Integer val)-> System.out.print(val+" "));
      System.out.println("\n\n");
      System.out.println("Removing elements from max heap in sorted order: ");
      while(!maxPQ.isEmpty()){
        System.out.print(maxPQ.poll()+" ");
      }
      System.out.println("\n\n");

    }
}
