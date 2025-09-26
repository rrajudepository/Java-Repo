import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    //Min-Heap 
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(5);
        pq.add(1);
        pq.add(5);
        pq.add(3);
        pq.add(10);
        pq.add(8);
        System.out.println(pq); // print all element in ascending order [1, 3, 5, 5, 10, 8]
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // remove element one by one 
        }
        
        
        //MaxHeap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        pq2.add(5);
        pq2.add(1);
        pq2.add(5);
        pq2.add(3);
        pq2.add(10);
        pq2.add(8);
        
        System.out.println(pq2);//[10, 5, 8, 1, 3, 5]
        while (!pq2.isEmpty()) {
            System.out.println(pq2.poll()); // 
        }

	}
}


/*
1. What is PriorityQueue?
Part of java.util package.

A queue where elements are ordered according to priority instead of insertion order.

By default → min-heap (smallest element at the head).

Can be customized with a Comparator to make it behave like a max-heap or to set custom ordering.

Not thread-safe → use PriorityBlockingQueue if you need concurrency.

Method              Description
add(E e)            Inserts element (throws exception if fails)
offer(E e)          Inserts element (returns false if fails)
peek()              Returns head without removing (null if empty)
element()           Returns head without removing (throws exception if empty)
poll()              Removes and returns head (null if empty)
remove()            Removes and returns head (throws exception if empty)
size()              Returns number of elements
isEmpty()           Checks if queue is empty
clear()             Removes all elements


Feature               Min Heap                   Max Heap
Heap Property         Parent ≤ children          Parent ≥ children
Root Node             Smallest element           Largest element
Usage                 Get smallest quickly       Get largest quickly

*/