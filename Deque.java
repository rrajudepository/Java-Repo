import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

 class LinkedListDequeExample {
    public static void main(String[] args) {
        // Creating Deque using LinkedList
        Deque<String> deque = new LinkedList<>();

        // Insert at the front
        deque.addFirst("A");
        deque.addFirst("B");  // B -> A

        // Insert at the rear
        deque.addLast("C");   // B -> A -> C
        deque.offerLast("D"); // B -> A -> C -> D

        System.out.println("Deque after additions: " + deque); //Deque after additions: [B, A, C, D]

        // Peek front and rear
        System.out.println("Front element: " + deque.peekFirst()); // Front element: B
        System.out.println("Rear element: " + deque.peekLast());   // Rear element: D

        // Remove from front
        deque.removeFirst();  // removes B
        System.out.println("After removeFirst: " + deque); //After removeFirst: [A, C, D]

        // Remove from rear
        deque.pollLast();     // removes D
        System.out.println("After pollLast: " + deque); //After pollLast: [A, C]

        // Stack-like usage
        deque.push("X"); // add at front
        deque.push("Y");
        System.out.println("Stack style: " + deque); //Stack style: [Y, X, A, C]

        deque.pop(); // remove from front
        System.out.println("After pop: " + deque); //After pop: [X, A, C]
        
        
        //Example: Queue behavior (FIFO)
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offerLast(10);
        dq.offerLast(20);
        dq.offerLast(30);
        
        while (!dq.isEmpty()) {
            System.out.println(dq.pollFirst()); // 10 20 30
        }
        
        
        // Example: Stack behavior (LIFO)
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 30 20 10
        }
        
        
        //Code to check palindrome 
        
        String str = "madam";
        Deque<Character> dq3 = new ArrayDeque<>();
        
        for (char c : str.toCharArray()) {
            dq3.offerLast(c);
        }
        
        boolean isPalindrome = true;
        while (dq3.size() > 1) {
            if (!dq3.pollFirst().equals(dq3.pollLast())) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }
}



/*
dq.addFirst(1);  // insert at head
dq.addLast(2);   // insert at tail
dq.removeFirst(); // remove head
dq.removeLast();  // remove tail
dq.peekFirst();   // view head
dq.peekLast();    // view tail
dq.push(5);       // stack push
dq.pop();         // stack pop


*/