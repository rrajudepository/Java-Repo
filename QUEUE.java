import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class QUEUE {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);  // Add element to rear
        queue.offer(20);
        System.out.println(queue.poll()); // Removes and returns front element (10)
        System.out.println(queue.peek()); // Returns front element without removing (20)
        System.out.println(queue.isEmpty()); // Checks if queue is empty


        //Using ArrayDeque (recommended for performance)

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.offer(10);
        queue2.offer(20);
        System.out.println(queue2.poll());
        System.out.println(queue2.peek());
    }
}

/*
Important Methods
Method	         Description
offer(E e)	     Adds element to the rear
poll()	         Removes and returns front element
peek()	         Returns front element without removing
isEmpty()	     Checks if the queue is empty
remove()	     Removes and returns front element (throws exception if empty)
element()	     Returns front element without removing (throws exception if empty)

 */
