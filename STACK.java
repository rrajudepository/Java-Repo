import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class STACK {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);   // Add element
        stack.push(20);
        System.out.println(stack.pop());   // Removes and returns top element (20)
        System.out.println(stack.peek());  // Returns top element without removing (10)
        System.out.println(stack.isEmpty()); // Checks if stack is empty


        //Using Deque as a stack (recommended)

        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(10);
        stack2.push(20);
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());

    }


}

/*
✅ Important Methods
Method                   Description
push(E e)                Adds element to the top
pop()                    Removes and returns top element
peek()                   Returns top element without removing
isEmpty()                Checks if the stack is empty
search(Object o)         Returns position from top (1-based index)

*/
